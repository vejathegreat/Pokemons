package com.velaphi.pokemons.infomodule

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.velaphi.pokemons.core.Result
import com.velaphi.pokemons.network.model.PokemonDetailResponse
import com.velaphi.pokemons.network.usecase.GetPokemonDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for the Info screen.
 * Manages state of Pokemon detail and user interactions.
 */
@HiltViewModel
class InfoViewModel @Inject constructor(
    private val getPokemonDetailUseCase: GetPokemonDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState = MutableStateFlow<InfoUiState>(InfoUiState.Loading)
    val uiState: StateFlow<InfoUiState> = _uiState.asStateFlow()

    private val pokemonId: String =
        savedStateHandle.get<String>("pokemonId")
            ?: error("Pokemon ID is required in SavedStateHandle")

    private var loadJob: Job? = null

    init {
        loadPokemonDetail()
    }

    /**
     * Load the Pokemon detail from the API.
     */
    fun loadPokemonDetail() {
        // Cancel any ongoing job to avoid duplicate collectors
        loadJob?.cancel()
        loadJob = viewModelScope.launch {
            getPokemonDetailUseCase.execute(pokemonId)
                .onStart { _uiState.value = InfoUiState.Loading }
                .catch { e ->
                    val isNetworkError = e.message?.contains("No internet connection", ignoreCase = true) == true ||
                                       e.message?.contains("network", ignoreCase = true) == true ||
                                       e.message?.contains("timeout", ignoreCase = true) == true
                    
                    _uiState.value = InfoUiState.Error(
                        message = e.message ?: "Unexpected error occurred",
                        isNetworkError = isNetworkError,
                        isRetryable = true
                    )
                }
                .collect { result ->
                    _uiState.value = when (result) {
                        is Result.Success -> InfoUiState.Success(result.data)
                        is Result.Error -> {
                            val exception = result.exception
                            val isNetworkError = exception.message?.contains("No internet connection", ignoreCase = true) == true ||
                                               exception.message?.contains("network", ignoreCase = true) == true ||
                                               exception.message?.contains("timeout", ignoreCase = true) == true
                            
                            InfoUiState.Error(
                                message = exception.message ?: "Unknown error",
                                isNetworkError = isNetworkError,
                                isRetryable = true
                            )
                        }
                        is Result.Loading -> InfoUiState.Loading
                    }
                }
        }
    }

    /**
     * Refresh the Pokemon detail (re-fetch).
     */
    fun refresh() = loadPokemonDetail()
}

/**
 * UI state for the Info screen.
 */
sealed interface InfoUiState {
    object Loading : InfoUiState
    data class Success(val pokemon: PokemonDetailResponse) : InfoUiState
    data class Error(
        val message: String,
        val isNetworkError: Boolean = false,
        val isRetryable: Boolean = true
    ) : InfoUiState
}