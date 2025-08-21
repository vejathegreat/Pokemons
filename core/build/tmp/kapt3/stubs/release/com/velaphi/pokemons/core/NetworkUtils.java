package com.velaphi.pokemons.core;

/**
 * Utility class for checking network connectivity status.
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/velaphi/pokemons/core/NetworkUtils;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getNetworkType", "", "isMobileConnected", "", "isNetworkAvailable", "isNetworkGood", "isWifiConnected", "observeNetworkConnectivity", "Lkotlinx/coroutines/flow/Flow;", "core_release"})
public final class NetworkUtils {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    
    @javax.inject.Inject()
    public NetworkUtils(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    /**
     * Check if device has internet connectivity.
     */
    public final boolean isNetworkAvailable() {
        return false;
    }
    
    /**
     * Check if device has WiFi connection.
     */
    public final boolean isWifiConnected() {
        return false;
    }
    
    /**
     * Check if device has mobile data connection.
     */
    public final boolean isMobileConnected() {
        return false;
    }
    
    /**
     * Get current network type as string.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNetworkType() {
        return null;
    }
    
    /**
     * Flow that emits network connectivity changes.
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> observeNetworkConnectivity() {
        return null;
    }
    
    /**
     * Check if the current network is considered "good" (fast enough for API calls).
     */
    public final boolean isNetworkGood() {
        return false;
    }
}