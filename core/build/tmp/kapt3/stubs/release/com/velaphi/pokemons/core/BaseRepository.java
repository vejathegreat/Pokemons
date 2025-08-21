package com.velaphi.pokemons.core;

/**
 * Base interface for all repositories in the application.
 * This follows the Repository pattern from Clean Architecture.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u00a6@\u00a2\u0006\u0002\u0010\u0007J\"\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\t\u001a\u00020\nH\u00a6@\u00a2\u0006\u0002\u0010\u000bJ \u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\u00050\u0004H\u00a6@\u00a2\u0006\u0002\u0010\u0007J\"\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u00042\u0006\u0010\t\u001a\u00020\nH\u00a6@\u00a2\u0006\u0002\u0010\u000bJ\"\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0010\u001a\u00028\u0000H\u00a6@\u00a2\u0006\u0002\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/velaphi/pokemons/core/BaseRepository;", "T", "", "clear", "Lkotlinx/coroutines/flow/Flow;", "Lcom/velaphi/pokemons/core/Result;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "", "getById", "save", "item", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_release"})
public abstract interface BaseRepository<T extends java.lang.Object> {
    
    /**
     * Get all items from the repository.
     * @return Flow of Result containing list of items or error
     */
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.velaphi.pokemons.core.Result<? extends java.util.List<? extends T>>>> $completion);
    
    /**
     * Get a specific item by its ID.
     * @param id The unique identifier of the item
     * @return Flow of Result containing the item or error
     */
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getById(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.velaphi.pokemons.core.Result<? extends T>>> $completion);
    
    /**
     * Save an item to the repository.
     * @param item The item to save
     * @return Flow of Result indicating success or failure
     */
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object save(T item, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.velaphi.pokemons.core.Result<kotlin.Unit>>> $completion);
    
    /**
     * Delete an item from the repository.
     * @param id The unique identifier of the item to delete
     * @return Flow of Result indicating success or failure
     */
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.velaphi.pokemons.core.Result<kotlin.Unit>>> $completion);
    
    /**
     * Clear all items from the repository.
     * @return Flow of Result indicating success or failure
     */
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object clear(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.velaphi.pokemons.core.Result<kotlin.Unit>>> $completion);
}