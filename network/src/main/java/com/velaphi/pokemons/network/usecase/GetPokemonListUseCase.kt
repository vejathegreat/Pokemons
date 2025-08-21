package com.velaphi.pokemons.network.usecase

import com.velaphi.pokemons.core.BaseUseCaseNoParams
import com.velaphi.pokemons.core.Result
import com.velaphi.pokemons.network.model.PokemonListItem
import com.velaphi.pokemons.network.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetPokemonListUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) : BaseUseCaseNoParams<List<PokemonListItem>> {
    
    /**
     * Execute the use case to get the Pokemon list.
     * @return Flow of Result containing the list of Pokemon or error
     */
    override suspend fun execute(): Flow<Result<List<PokemonListItem>>> {
        return pokemonRepository.getAll()
    }
}

