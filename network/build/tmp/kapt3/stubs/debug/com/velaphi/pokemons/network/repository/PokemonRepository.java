package com.velaphi.pokemons.network.repository;

/**
 * Repository implementation for Pokemon data.
 * This repository handles API calls and data transformation.
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n0\tH\u0096@\u00a2\u0006\u0002\u0010\fJ\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\n0\t2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/velaphi/pokemons/network/repository/PokemonRepository;", "Lcom/velaphi/pokemons/core/BaseRepository;", "Lcom/velaphi/pokemons/network/model/PokemonListItem;", "pokeApiService", "Lcom/velaphi/pokemons/network/api/PokeApiService;", "networkUtils", "Lcom/velaphi/pokemons/core/NetworkUtils;", "(Lcom/velaphi/pokemons/network/api/PokeApiService;Lcom/velaphi/pokemons/core/NetworkUtils;)V", "getAll", "Lkotlinx/coroutines/flow/Flow;", "Lcom/velaphi/pokemons/core/Result;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPokemonDetail", "Lcom/velaphi/pokemons/network/model/PokemonDetailResponse;", "idOrName", "", "network_debug"})
public final class PokemonRepository implements com.velaphi.pokemons.core.BaseRepository<com.velaphi.pokemons.network.model.PokemonListItem> {
    @org.jetbrains.annotations.NotNull()
    private final com.velaphi.pokemons.network.api.PokeApiService pokeApiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.velaphi.pokemons.core.NetworkUtils networkUtils = null;
    
    @javax.inject.Inject()
    public PokemonRepository(@org.jetbrains.annotations.NotNull()
    com.velaphi.pokemons.network.api.PokeApiService pokeApiService, @org.jetbrains.annotations.NotNull()
    com.velaphi.pokemons.core.NetworkUtils networkUtils) {
        super();
    }
    
    /**
     * Get all Pokemon from the API.
     * @return Flow of Result containing list of Pokemon or error
     */
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.velaphi.pokemons.core.Result<? extends java.util.List<com.velaphi.pokemons.network.model.PokemonListItem>>>> $completion) {
        return null;
    }
    
    /**
     * Get detailed Pokemon information by ID or name.
     * @param idOrName The Pokemon ID or name
     * @return Flow of Result containing detailed Pokemon information or error
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.velaphi.pokemons.core.Result<com.velaphi.pokemons.network.model.PokemonDetailResponse>> getPokemonDetail(@org.jetbrains.annotations.NotNull()
    java.lang.String idOrName) {
        return null;
    }
}