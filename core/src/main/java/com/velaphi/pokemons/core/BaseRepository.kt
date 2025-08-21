package com.velaphi.pokemons.core

import kotlinx.coroutines.flow.Flow

/**
 * Base interface for all repositories in the application.
 * This follows the Repository pattern from Clean Architecture.
 */
interface BaseRepository<T> {
    
    /**
     * Get all items from the repository.
     * @return Flow of Result containing list of items or error
     */
    suspend fun getAll(): Flow<Result<List<T>>>
}

