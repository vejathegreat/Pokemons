package com.velaphi.pokemons.network.repository

import com.velaphi.pokemons.core.NetworkUtils
import com.velaphi.pokemons.core.Result
import com.velaphi.pokemons.network.api.PokeApiService
import com.velaphi.pokemons.network.constants.NetworkConstants
import com.velaphi.pokemons.network.model.PokemonDetailResponse
import com.velaphi.pokemons.network.model.PokemonListItem
import com.velaphi.pokemons.network.model.PokemonListResponse
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Response

class PokemonRepositoryTest {
    private lateinit var repository: PokemonRepository
    private lateinit var mockPokeApiService: PokeApiService
    private lateinit var mockNetworkUtils: NetworkUtils

    @Before
    fun setUp() {
        mockPokeApiService = mockk()
        mockNetworkUtils = mockk()
        repository = PokemonRepository(mockPokeApiService, mockNetworkUtils)
    }

    @Test
    fun `getAll returns success when network is available and API call succeeds`() = runTest {
        // Given
        val mockResponse = PokemonListResponse(
            count = 2,
            next = null,
            previous = null,
            results = listOf(
                PokemonListItem("bulbasaur", "https://pokeapi.co/api/v2/pokemon/1/"),
                PokemonListItem("ivysaur", "https://pokeapi.co/api/v2/pokemon/2/")
            )
        )

        coEvery { mockNetworkUtils.isNetworkAvailable() } returns true
        coEvery { 
            mockPokeApiService.getPokemonList(
                limit = NetworkConstants.DEFAULT_LIMIT,
                offset = NetworkConstants.DEFAULT_OFFSET
            ) 
        } returns mockResponse

        // When
        var result: Result<List<PokemonListItem>>? = null
        repository.getAll().collect { 
            result = it
        }

        // Then
        assertNotNull(result)
        assertTrue(result!!.isSuccess())
        val successResult = result as Result.Success<List<PokemonListItem>>
        assertEquals(2, successResult.data.size)
        assertEquals("bulbasaur", successResult.data[0].name)
        assertEquals("ivysaur", successResult.data[1].name)
    }

    @Test
    fun `getAll returns error when network is not available`() = runTest {
        // Given
        coEvery { mockNetworkUtils.isNetworkAvailable() } returns false

        // When
        var result: Result<List<PokemonListItem>>? = null
        repository.getAll().collect { 
            result = it
        }

        // Then
        assertNotNull(result)
        assertTrue(result!!.isError())
        val errorResult = result as Result.Error
        assertEquals(NetworkConstants.NO_INTERNET_AVAILABLE, errorResult.exception.message)
    }

    @Test
    fun `getAll returns error when API call fails with HTTP error`() = runTest {
        // Given
        val httpException = HttpException(Response.error<Any>(500, okhttp3.ResponseBody.create(null, "Server Error")))
        
        coEvery { mockNetworkUtils.isNetworkAvailable() } returns true
        coEvery { 
            mockPokeApiService.getPokemonList(
                limit = NetworkConstants.DEFAULT_LIMIT,
                offset = NetworkConstants.DEFAULT_OFFSET
            ) 
        } throws httpException

        // When
        var result: Result<List<PokemonListItem>>? = null
        repository.getAll().collect { 
            result = it
        }

        // Then
        assertNotNull(result)
        assertTrue(result!!.isError())
        val errorResult = result as Result.Error
        assertTrue(errorResult.exception.message?.contains("Server error") == true)
    }

    @Test
    fun `getPokemonDetail returns success when network is available and API call succeeds`() = runTest {
        // Given
        val mockResponse = PokemonDetailResponse(
            id = 1,
            name = "bulbasaur",
            height = 7,
            weight = 69,
            baseExperience = 64,
            types = listOf(),
            abilities = listOf(),
            forms = listOf(),
            sprites = mockk(),
            stats = listOf()
        )

        coEvery { mockNetworkUtils.isNetworkAvailable() } returns true
        coEvery { mockPokeApiService.getPokemonDetail("bulbasaur") } returns mockResponse

        // When
        var result: Result<PokemonDetailResponse>? = null
        repository.getPokemonDetail("bulbasaur").collect { 
            result = it
        }

        // Then
        assertNotNull(result)
        assertTrue(result!!.isSuccess())
        val successResult = result as Result.Success<PokemonDetailResponse>
        assertEquals("bulbasaur", successResult.data.name)
        assertEquals(1, successResult.data.id)
    }

    @Test
    fun `getPokemonDetail returns error when network is not available`() = runTest {
        // Given
        coEvery { mockNetworkUtils.isNetworkAvailable() } returns false

        // When
        var result: Result<PokemonDetailResponse>? = null
        repository.getPokemonDetail("bulbasaur").collect { 
            result = it
        }

        // Then
        assertNotNull(result)
        assertTrue(result!!.isError())
        val errorResult = result as Result.Error
        assertEquals(NetworkConstants.NO_INTERNET_AVAILABLE, errorResult.exception.message)
    }

    @Test
    fun `getPokemonDetail with empty string returns error`() = runTest {
        // Given
        coEvery { mockNetworkUtils.isNetworkAvailable() } returns true
        coEvery { mockPokeApiService.getPokemonDetail("") } throws IllegalArgumentException("Empty string")

        // When
        var result: Result<PokemonDetailResponse>? = null
        repository.getPokemonDetail("").collect { 
            result = it
        }

        // Then
        assertNotNull(result)
        assertTrue(result!!.isError())
        val errorResult = result as Result.Error
        assertTrue(errorResult.exception.message?.contains("Empty string") == true)
    }

    @Test
    fun `getPokemonDetail with numeric ID calls API correctly`() = runTest {
        // Given
        val mockResponse = PokemonDetailResponse(
            id = 25,
            name = "pikachu",
            height = 4,
            weight = 60,
            baseExperience = 112,
            types = listOf(),
            abilities = listOf(),
            forms = listOf(),
            sprites = mockk(),
            stats = listOf()
        )

        coEvery { mockNetworkUtils.isNetworkAvailable() } returns true
        coEvery { mockPokeApiService.getPokemonDetail("25") } returns mockResponse

        // When
        var result: Result<PokemonDetailResponse>? = null
        repository.getPokemonDetail("25").collect { 
            result = it
        }

        // Then
        assertNotNull(result)
        assertTrue(result!!.isSuccess())
        val successResult = result as Result.Success<PokemonDetailResponse>
        assertEquals("pikachu", successResult.data.name)
        assertEquals(25, successResult.data.id)
    }

    @Test
    fun `getAll handles empty response correctly`() = runTest {
        // Given
        val mockResponse = PokemonListResponse(
            count = 0,
            next = null,
            previous = null,
            results = emptyList()
        )

        coEvery { mockNetworkUtils.isNetworkAvailable() } returns true
        coEvery { 
            mockPokeApiService.getPokemonList(
                limit = NetworkConstants.DEFAULT_LIMIT,
                offset = NetworkConstants.DEFAULT_OFFSET
            ) 
        } returns mockResponse

        // When
        var result: Result<List<PokemonListItem>>? = null
        repository.getAll().collect { 
            result = it
        }

        // Then
        assertNotNull(result)
        assertTrue(result!!.isSuccess())
        val successResult = result as Result.Success<List<PokemonListItem>>
        assertTrue(successResult.data.isEmpty())
    }

    @Test
    fun `getAll handles large response correctly`() = runTest {
        // Given
        val largePokemonList = (1..1000).map { 
            PokemonListItem("pokemon$it", "https://pokeapi.co/api/v2/pokemon/$it/")
        }
        val mockResponse = PokemonListResponse(
            count = 1000,
            next = null,
            previous = null,
            results = largePokemonList
        )

        coEvery { mockNetworkUtils.isNetworkAvailable() } returns true
        coEvery { 
            mockPokeApiService.getPokemonList(
                limit = NetworkConstants.DEFAULT_LIMIT,
                offset = NetworkConstants.DEFAULT_OFFSET
            ) 
        } returns mockResponse

        // When
        var result: Result<List<PokemonListItem>>? = null
        repository.getAll().collect { 
            result = it
        }

        // Then
        assertNotNull(result)
        assertTrue(result!!.isSuccess())
        val successResult = result as Result.Success<List<PokemonListItem>>
        assertEquals(1000, successResult.data.size)
        assertEquals("pokemon1", successResult.data[0].name)
        assertEquals("pokemon1000", successResult.data[999].name)
    }

    @Test
    fun `getAll uses correct default parameters`() = runTest {
        // Given
        val mockResponse = PokemonListResponse(
            count = 1,
            next = null,
            previous = null,
            results = listOf(PokemonListItem("test", "https://test.com"))
        )

        coEvery { mockNetworkUtils.isNetworkAvailable() } returns true
        coEvery { 
            mockPokeApiService.getPokemonList(
                limit = NetworkConstants.DEFAULT_LIMIT,
                offset = NetworkConstants.DEFAULT_OFFSET
            ) 
        } returns mockResponse

        // When
        var result: Result<List<PokemonListItem>>? = null
        repository.getAll().collect { 
            result = it
        }

        // Then
        assertNotNull(result)
        assertTrue(result!!.isSuccess())
    }
    
    @Test
    fun `getAll calls API with correct parameters`() = runTest {
        // Given
        val mockResponse = PokemonListResponse(
            count = 1,
            next = null,
            previous = null,
            results = listOf(PokemonListItem("test", "https://test.com"))
        )

        coEvery { mockNetworkUtils.isNetworkAvailable() } returns true
        coEvery { 
            mockPokeApiService.getPokemonList(
                limit = NetworkConstants.DEFAULT_LIMIT,
                offset = NetworkConstants.DEFAULT_OFFSET
            ) 
        } returns mockResponse

        // When
        repository.getAll().collect { }

        // Then
        coVerify { 
            mockPokeApiService.getPokemonList(
                limit = NetworkConstants.DEFAULT_LIMIT,
                offset = NetworkConstants.DEFAULT_OFFSET
            ) 
        }
    }
}
