package com.velaphi.pokemons.network.usecase;

/**
 * Use case for retrieving the list of Pokemon.
 * This use case follows the Clean Architecture pattern and encapsulates
 * the business logic for fetching Pokemon data.
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\t0\bH\u0096@\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/velaphi/pokemons/network/usecase/GetPokemonListUseCase;", "Lcom/velaphi/pokemons/core/BaseUseCaseNoParams;", "", "Lcom/velaphi/pokemons/network/model/PokemonListItem;", "pokemonRepository", "Lcom/velaphi/pokemons/network/repository/PokemonRepository;", "(Lcom/velaphi/pokemons/network/repository/PokemonRepository;)V", "execute", "Lkotlinx/coroutines/flow/Flow;", "Lcom/velaphi/pokemons/core/Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "network_debug"})
public final class GetPokemonListUseCase implements com.velaphi.pokemons.core.BaseUseCaseNoParams<java.util.List<? extends com.velaphi.pokemons.network.model.PokemonListItem>> {
    @org.jetbrains.annotations.NotNull()
    private final com.velaphi.pokemons.network.repository.PokemonRepository pokemonRepository = null;
    
    @javax.inject.Inject()
    public GetPokemonListUseCase(@org.jetbrains.annotations.NotNull()
    com.velaphi.pokemons.network.repository.PokemonRepository pokemonRepository) {
        super();
    }
    
    /**
     * Execute the use case to get the Pokemon list.
     * @return Flow of Result containing the list of Pokemon or error
     */
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object execute(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.velaphi.pokemons.core.Result<? extends java.util.List<com.velaphi.pokemons.network.model.PokemonListItem>>>> $completion) {
        return null;
    }
}