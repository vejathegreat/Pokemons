package com.velaphi.pokemons.network.repository

import com.velaphi.pokemons.core.BaseRepository
import com.velaphi.pokemons.core.Result
import com.velaphi.pokemons.core.NetworkUtils
import com.velaphi.pokemons.network.NetworkErrorHandler
import com.velaphi.pokemons.network.api.PokeApiService
import com.velaphi.pokemons.network.model.PokemonDetailResponse
import com.velaphi.pokemons.network.model.PokemonListItem
import com.velaphi.pokemons.network.constants.NetworkConstants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepository @Inject constructor(
    private val pokeApiService: PokeApiService,
    private val networkUtils: NetworkUtils
) : BaseRepository<PokemonListItem> {
    
    /**
     * Get all Pokemon from the API.
     * @return Flow of Result containing list of Pokemon or error
     */
    override suspend fun getAll(): Flow<Result<List<PokemonListItem>>> = flow {
        try {
            emit(Result.Loading)
            
            // Check network connectivity first
            if (!networkUtils.isNetworkAvailable()) {
                emit(Result.Error(Exception(NetworkConstants.NO_INTERNET_AVAILABLE)))
                return@flow
            }
            
            val response = pokeApiService.getPokemonList(limit = NetworkConstants.DEFAULT_LIMIT, offset = NetworkConstants.DEFAULT_OFFSET)
            emit(Result.Success(response.results))
        } catch (e: Exception) {
            val errorMessage = NetworkErrorHandler.handleException(e)
            emit(Result.Error(Exception(errorMessage)))
        }
    }

    /**
     * Get detailed Pokemon information by ID or name.
     * @param idOrName The Pokemon ID or name
     * @return Flow of Result containing detailed Pokemon information or error
     */
    fun getPokemonDetail(idOrName: String): Flow<Result<PokemonDetailResponse>> = flow {
        try {
            emit(Result.Loading)

            if (!networkUtils.isNetworkAvailable()) {
                emit(Result.Error(Exception(NetworkConstants.NO_INTERNET_AVAILABLE)))
                return@flow
            }
            
            val response = pokeApiService.getPokemonDetail(idOrName)
            emit(Result.Success(response))
        } catch (e: Exception) {
            val errorMessage = NetworkErrorHandler.handleException(e)
            emit(Result.Error(Exception(errorMessage)))
        }
    }
}
