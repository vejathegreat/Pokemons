package com.velaphi.pokemons.core.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a(\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\"\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\u000e"}, d2 = {"CompactNetworkError", "", "error", "Lcom/velaphi/pokemons/core/NetworkResult$Error;", "onRetry", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "NetworkErrorContent", "NetworkStatusIndicator", "isConnected", "", "networkType", "", "core_release"})
public final class NetworkErrorUIKt {
    
    /**
     * Enhanced error content component specifically for network errors.
     * Provides different UI based on error type and retry capability.
     */
    @androidx.compose.runtime.Composable()
    public static final void NetworkErrorContent(@org.jetbrains.annotations.NotNull()
    com.velaphi.pokemons.core.NetworkResult.Error error, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onRetry, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * Compact network error component for use in smaller spaces.
     */
    @androidx.compose.runtime.Composable()
    public static final void CompactNetworkError(@org.jetbrains.annotations.NotNull()
    com.velaphi.pokemons.core.NetworkResult.Error error, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onRetry, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * Network status indicator showing current connection status.
     */
    @androidx.compose.runtime.Composable()
    public static final void NetworkStatusIndicator(boolean isConnected, @org.jetbrains.annotations.NotNull()
    java.lang.String networkType, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
}