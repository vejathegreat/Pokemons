package com.velaphi.pokemons.core;

/**
 * Base interface for all repositories in the application.
 * This follows the Repository pattern from Clean Architecture.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J \u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u00050\u0004H\u00a6@\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/velaphi/pokemons/core/BaseRepository;", "T", "", "getAll", "Lkotlinx/coroutines/flow/Flow;", "Lcom/velaphi/pokemons/core/Result;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_debug"})
public abstract interface BaseRepository<T extends java.lang.Object> {
    
    /**
     * Get all items from the repository.
     * @return Flow of Result containing list of items or error
     */
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.velaphi.pokemons.core.Result<? extends java.util.List<? extends T>>>> $completion);
}