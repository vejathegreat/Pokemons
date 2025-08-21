package com.velaphi.pokemons.core

/**
 * A sealed class representing the result of an operation.
 * This follows the functional programming pattern for handling success and error cases.
 */
sealed class Result<out T> {
    /**
     * Represents a successful operation with data.
     */
    data class Success<T>(val data: T) : Result<T>()
    
    /**
     * Represents an error operation with an exception.
     */
    data class Error(val exception: Exception) : Result<Nothing>()
    
    /**
     * Represents a loading state.
     */
    object Loading : Result<Nothing>()
    
    /**
     * Returns true if this is a Success result.
     */
    fun isSuccess(): Boolean = this is Success
    
    /**
     * Returns true if this is an Error result.
     */
    fun isError(): Boolean = this is Error
    
    /**
     * Returns true if this is a Loading result.
     */
    fun isLoading(): Boolean = this is Loading
    
    /**
     * Returns the data if this is a Success result, null otherwise.
     */
    fun getOrNull(): T? = if (this is Success) data else null
    
    /**
     * Returns the exception if this is an Error result, null otherwise.
     */
    fun exceptionOrNull(): Exception? = if (this is Error) exception else null
}

