package com.velaphi.pokemons.core

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import androidx.core.content.ContextCompat
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Utility class for network connectivity checks and monitoring.
 */
@Singleton
class NetworkUtils @Inject constructor(
    private val context: Context
) {

    private val connectivityManager: ConnectivityManager
        get() = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    /** Check if the app has permission to access network state */
    private fun hasPermission(): Boolean =
        ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_NETWORK_STATE
        ) == PackageManager.PERMISSION_GRANTED

    /** Safely get current NetworkCapabilities or null */
    private fun getCapabilities(): NetworkCapabilities? {
        if (!hasPermission()) return null
        val network = connectivityManager.activeNetwork ?: return null
        return connectivityManager.getNetworkCapabilities(network)
    }

    /** Check if the device has internet connectivity */
    fun isNetworkAvailable(): Boolean = getCapabilities()?.run {
        hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
    } ?: false

    /** Check if connected via WiFi */
    fun isWifiConnected(): Boolean = getCapabilities()?.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ?: false

    /** Check if connected via Mobile Data */
    fun isMobileConnected(): Boolean = getCapabilities()?.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ?: false

    /** Get current network type as a string */
    fun getNetworkType(): String = when {
        !hasPermission() -> "Permission Denied"
        isWifiConnected() -> "WiFi"
        isMobileConnected() -> "Mobile Data"
        else -> "No Connection"
    }

    /**
     * Flow that emits network connectivity changes.
     * Emits `true` when internet is available and validated, `false` otherwise.
     */
    fun observeNetworkConnectivity(): Flow<Boolean> = callbackFlow {
        if (!hasPermission()) {
            trySend(false)
            awaitClose()
            return@callbackFlow
        }

        val callback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                trySend(true)
            }

            override fun onLost(network: Network) {
                trySend(false)
            }

            override fun onCapabilitiesChanged(network: Network, caps: NetworkCapabilities) {
                val hasInternet = caps.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                        caps.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
                trySend(hasInternet)
            }
        }

        val request = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()

        try {
            connectivityManager.registerNetworkCallback(request, callback)
            trySend(isNetworkAvailable()) // emit initial state
        } catch (_: SecurityException) {
            trySend(false)
        }

        awaitClose { runCatching { connectivityManager.unregisterNetworkCallback(callback) } }
    }.distinctUntilChanged()

    /** Checks if current network is good for API calls */
    fun isNetworkGood(): Boolean = getCapabilities()?.run {
        hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED) &&
                (hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                        hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR))
    } ?: false

    /** Expose permission status */
    fun canAccessNetworkState(): Boolean = hasPermission()
}
