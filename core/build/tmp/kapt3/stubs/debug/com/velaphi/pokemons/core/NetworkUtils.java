package com.velaphi.pokemons.core;

/**
 * Utility class for network connectivity checks and monitoring.
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\nH\u0002J\u0006\u0010\u0010\u001a\u00020\nJ\u0006\u0010\u0011\u001a\u00020\nJ\u0006\u0010\u0012\u001a\u00020\nJ\u0006\u0010\u0013\u001a\u00020\nJ\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0015R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/velaphi/pokemons/core/NetworkUtils;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "connectivityManager", "Landroid/net/ConnectivityManager;", "getConnectivityManager", "()Landroid/net/ConnectivityManager;", "canAccessNetworkState", "", "getCapabilities", "Landroid/net/NetworkCapabilities;", "getNetworkType", "", "hasPermission", "isMobileConnected", "isNetworkAvailable", "isNetworkGood", "isWifiConnected", "observeNetworkConnectivity", "Lkotlinx/coroutines/flow/Flow;", "core_debug"})
public final class NetworkUtils {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    
    @javax.inject.Inject()
    public NetworkUtils(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    private final android.net.ConnectivityManager getConnectivityManager() {
        return null;
    }
    
    /**
     * Check if the app has permission to access network state
     */
    private final boolean hasPermission() {
        return false;
    }
    
    /**
     * Safely get current NetworkCapabilities or null
     */
    private final android.net.NetworkCapabilities getCapabilities() {
        return null;
    }
    
    /**
     * Check if the device has internet connectivity
     */
    public final boolean isNetworkAvailable() {
        return false;
    }
    
    /**
     * Check if connected via WiFi
     */
    public final boolean isWifiConnected() {
        return false;
    }
    
    /**
     * Check if connected via Mobile Data
     */
    public final boolean isMobileConnected() {
        return false;
    }
    
    /**
     * Get current network type as a string
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNetworkType() {
        return null;
    }
    
    /**
     * Flow that emits network connectivity changes.
     * Emits `true` when internet is available and validated, `false` otherwise.
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> observeNetworkConnectivity() {
        return null;
    }
    
    /**
     * Checks if current network is good for API calls
     */
    public final boolean isNetworkGood() {
        return false;
    }
    
    /**
     * Expose permission status
     */
    public final boolean canAccessNetworkState() {
        return false;
    }
}