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
            _uiState.value = HomeUiState.Loading
            
            getPokemonListUseCase.execute().collect { result ->
                when (result) {
                    is Result.Success -> {
                        allPokemon = result.data
                        _uiState.value = HomeUiState.Success(
                            pokemonList = filterPokemon(result.data, _searchQuery.value)
                        )
                    }
                    is Result.Error -> {
                        val exception = result.exception
                        val isNetworkError = exception.message?.contains(StringConstants.KEYWORD_NO_INTERNET, ignoreCase = true) == true ||
                                           exception.message?.contains(StringConstants.KEYWORD_NETWORK, ignoreCase = true) == true ||
                                           exception.message?.contains(StringConstants.KEYWORD_TIMEOUT, ignoreCase = true) == true
                        
                        _uiState.value = HomeUiState.Error(
                            message = exception.message ?: StringConstants.UNKNOWN_ERROR,
                            isNetworkError = isNetworkError,
                            isRetryable = true
                        )
                    }
                    is Result.Loading -> {
                        _uiState.value = HomeUiState.Loading
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
