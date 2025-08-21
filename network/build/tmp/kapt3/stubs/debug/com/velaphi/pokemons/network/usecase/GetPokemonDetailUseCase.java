package com.velaphi.pokemons.network.usecase;

/**
 * Use case for retrieving detailed Pokemon information.
 * This use case follows the Clean Architecture pattern and encapsulates
 * the business logic for fetching detailed Pokemon data.
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\t0\b2\u0006\u0010\n\u001a\u00020\u0002H\u0096@\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/velaphi/pokemons/network/usecase/GetPokemonDetailUseCase;", "Lcom/velaphi/pokemons/core/BaseUseCase;", "", "Lcom/velaphi/pokemons/network/model/PokemonDetailResponse;", "pokemonRepository", "Lcom/velaphi/pokemons/network/repository/PokemonRepository;", "(Lcom/velaphi/pokemons/network/repository/PokemonRepository;)V", "execute", "Lkotlinx/coroutines/flow/Flow;", "Lcom/velaphi/pokemons/core/Result;", "params", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "network_debug"})
public final class GetPokemonDetailUseCase implements com.velaphi.pokemons.core.BaseUseCase<java.lang.String, com.velaphi.pokemons.network.model.PokemonDetailResponse> {
    @org.jetbrains.annotations.NotNull()
    private final com.velaphi.pokemons.network.repository.PokemonRepository pokemonRepository = null;
    
    @javax.inject.Inject()
    public GetPokemonDetailUseCase(@org.jetbrains.annotations.NotNull()
    com.velaphi.pokemons.network.repository.PokemonRepository pokemonRepository) {
        super();
    }
    
    /**
     * Execute the use case to get detailed Pokemon information.
     * @param params The Pokemon ID or name
     * @return Flow of Result containing detailed Pokemon information or error
     */
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object execute(@org.jetbrains.annotations.NotNull()
    java.lang.String params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.velaphi.pokemons.core.Result<com.velaphi.pokemons.network.model.PokemonDetailResponse>>> $completion) {
        return null;
    }
}