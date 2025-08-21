package com.velaphi.pokemons.core;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"getUserFriendlyMessage", "", "Lcom/velaphi/pokemons/core/NetworkResult$Error;", "isRetryable", "", "toBasicNetworkError", "", "core_release"})
public final class NetworkResultKt {
    
    /**
     * Extension function to convert basic exceptions to NetworkResult.Error
     */
    @org.jetbrains.annotations.NotNull()
    public static final com.velaphi.pokemons.core.NetworkResult.Error toBasicNetworkError(@org.jetbrains.annotations.NotNull()
    java.lang.Throwable $this$toBasicNetworkError) {
        return null;
    }
    
    /**
     * Extension function to get user-friendly error message
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getUserFriendlyMessage(@org.jetbrains.annotations.NotNull()
    com.velaphi.pokemons.core.NetworkResult.Error $this$getUserFriendlyMessage) {
        return null;
    }
    
    /**
     * Extension function to check if error is retryable
     */
    public static final boolean isRetryable(@org.jetbrains.annotations.NotNull()
    com.velaphi.pokemons.core.NetworkResult.Error $this$isRetryable) {
        return false;
    }
}