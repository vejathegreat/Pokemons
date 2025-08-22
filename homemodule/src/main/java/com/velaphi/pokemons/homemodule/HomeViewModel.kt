package com.velaphi.pokemons.homemodule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.velaphi.pokemons.core.Result
import com.velaphi.pokemons.network.model.PokemonListItem
import com.velaphi.pokemons.network.usecase.GetPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.velaphi.pokemons.homemodule.constants.StringConstants

/**
 * ViewModel for the Home screen.
 * This ViewModel manages the state of the Pokemon list and handles user interactions.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase
) : ViewModel() {
    
    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()
    
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()
    
    private var allPokemon: List<PokemonListItem> = emptyList()
    
    init {
        loadPokemonList()
    }
    
    /**
     * Load the Pokemon list from the API.
     */
    fun loadPokemonList() {
        viewModelScope.launch {
            getPokemonListUseCase.execute().collectLatest { result ->
                when (result) {
                    is Result.Success -> {
                        allPokemon = result.data
                        _uiState.update {
                            HomeUiState.Success(
                                pokemonList = filterPokemon(result.data, _searchQuery.value)
                            )
                        }
                    }

                    is Result.Error -> {
                        val isNetworkError = result.exception.isNetworkRelated()
                        _uiState.update {
                            HomeUiState.Error(
                                message = result.exception.message ?: "Unknown error occurred",
                                isNetworkError = isNetworkError,
                                isRetryable = true
                            )
                        }
                    }

                    is Result.Loading -> {
                        _uiState.update { HomeUiState.Loading }
                    }
                }
            }
        }
    }
    
    /**
     * Update the search query and filter the Pokemon list.
     * @param query The search query string
     */
    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
        val filteredList = filterPokemon(allPokemon, query)
        _uiState.value = HomeUiState.Success(pokemonList = filteredList)
    }
    
    /**
     * Filter Pokemon based on search query.
     * @param pokemonList The list of all Pokemon
     * @param query The search query
     * @return Filtered list of Pokemon
     */
    private fun filterPokemon(pokemonList: List<PokemonListItem>, query: String): List<PokemonListItem> {
        return if (query.isBlank()) {
            pokemonList
        } else {
            pokemonList.filter { pokemon ->
                pokemon.name.contains(query, ignoreCase = true) ||
                pokemon.getId().contains(query, ignoreCase = true)
            }
        }
    }
    
    /**
     * Refresh the Pokemon list.
     */
    fun refresh() {
        loadPokemonList()
    }
}

/**
 * UI state for the Home screen.
 */
sealed class HomeUiState {
    object Loading : HomeUiState()
    data class Success(val pokemonList: List<PokemonListItem>) : HomeUiState()
    data class Error(
        val message: String,
        val isNetworkError: Boolean = false,
        val isRetryable: Boolean = true
    ) : HomeUiState()
}

/**
 * Extension function to check if an exception is network-related.
 * Uses hardcoded keywords for network error detection.
 */
private fun Throwable.isNetworkRelated(): Boolean {
    val message = this.message?.lowercase() ?: return false
    return listOf(
        "no internet",
        "network",
        "timeout",
        "server"
    ).any { keyword -> message.contains(keyword.lowercase()) }
}
