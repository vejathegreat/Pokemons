package com.velaphi.pokemons.network.api;

/**
 * Retrofit service interface for the PokeAPI.
 * This service provides methods to interact with the Pokemon API endpoints.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u000b\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/velaphi/pokemons/network/api/PokeApiService;", "", "getPokemonDetail", "Lcom/velaphi/pokemons/network/model/PokemonDetailResponse;", "idOrName", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPokemonList", "Lcom/velaphi/pokemons/network/model/PokemonListResponse;", "limit", "", "offset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "network_debug"})
public abstract interface PokeApiService {
    
    /**
     * Get a list of Pokemon with pagination support.
     * @param limit The number of Pokemon to return (max 100)
     * @param offset The offset for pagination
     * @return PokemonListResponse containing the list of Pokemon
     */
    @retrofit2.http.GET(value = "pokemon")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPokemonList(@retrofit2.http.Query(value = "limit")
    int limit, @retrofit2.http.Query(value = "offset")
    int offset, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.velaphi.pokemons.network.model.PokemonListResponse> $completion);
    
    /**
     * Get detailed information about a specific Pokemon by its ID or name.
     * @param idOrName The Pokemon ID or name
     * @return PokemonDetailResponse containing detailed Pokemon information
     */
    @retrofit2.http.GET(value = "pokemon/{idOrName}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPokemonDetail(@retrofit2.http.Path(value = "idOrName")
    @org.jetbrains.annotations.NotNull()
    java.lang.String idOrName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.velaphi.pokemons.network.model.PokemonDetailResponse> $completion);
    
    /**
     * Retrofit service interface for the PokeAPI.
     * This service provides methods to interact with the Pokemon API endpoints.
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}