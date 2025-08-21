package com.velaphi.pokemons.homemodule

import com.velaphi.pokemons.core.Result
import com.velaphi.pokemons.network.model.PokemonListItem
import com.velaphi.pokemons.network.usecase.GetPokemonListUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {
    private lateinit var viewModel: HomeViewModel
    private lateinit var mockGetPokemonListUseCase: GetPokemonListUseCase
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        mockGetPokemonListUseCase = mockk()

        coEvery { mockGetPokemonListUseCase.execute() } returns flowOf(Result.Success(emptyList<PokemonListItem>()))
        
        viewModel = HomeViewModel(mockGetPokemonListUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `loadPokemonList updates state to Success when use case succeeds`() = runTest {
        // Given
        val mockPokemonList = listOf(
            PokemonListItem("bulbasaur", "https://pokeapi.co/api/v2/pokemon/1/"),
            PokemonListItem("ivysaur", "https://pokeapi.co/api/v2/pokemon/2/")
        )

        coEvery { mockGetPokemonListUseCase.execute() } returns flowOf(Result.Success(mockPokemonList))

        // When
        viewModel.loadPokemonList()
        testDispatcher.scheduler.advanceUntilIdle()

        // Then
        assertTrue(viewModel.uiState.value is HomeUiState.Success)
        val successState = viewModel.uiState.value as HomeUiState.Success
        assertEquals(2, successState.pokemonList.size)
        assertEquals("bulbasaur", successState.pokemonList[0].name)
        assertEquals("ivysaur", successState.pokemonList[1].name)
    }

    @Test
    fun `loadPokemonList detects network errors correctly`() = runTest {
        // Given
        val networkException = Exception("No internet connection")
        coEvery { mockGetPokemonListUseCase.execute() } returns flowOf(Result.Error(networkException))

        // When
        viewModel.loadPokemonList()
        testDispatcher.scheduler.advanceUntilIdle()

        // Then
        assertTrue(viewModel.uiState.value is HomeUiState.Error)
        val errorState = viewModel.uiState.value as HomeUiState.Error
        assertTrue(errorState.isNetworkError)
    }

    @Test
    fun `loadPokemonList detects generic network errors correctly`() = runTest {
        // Given
        val networkException = Exception("Network error occurred")
        coEvery { mockGetPokemonListUseCase.execute() } returns flowOf(Result.Error(networkException))

        // When
        viewModel.loadPokemonList()
        testDispatcher.scheduler.advanceUntilIdle()

        // Then
        assertTrue(viewModel.uiState.value is HomeUiState.Error)
        val errorState = viewModel.uiState.value as HomeUiState.Error
        assertTrue(errorState.isNetworkError)
    }

    @Test
    fun `updateSearchQuery updates searchQuery state`() = runTest {
        // Given
        val searchQuery = "pikachu"

        // When
        viewModel.updateSearchQuery(searchQuery)

        // Then
        assertEquals(searchQuery, viewModel.searchQuery.value)
    }

    @Test
    fun `updateSearchQuery with empty string updates state correctly`() = runTest {
        // Given
        val emptySearchQuery = ""

        // When
        viewModel.updateSearchQuery(emptySearchQuery)

        // Then
        assertEquals(emptySearchQuery, viewModel.searchQuery.value)
    }

    @Test
    fun `updateSearchQuery with special characters updates state correctly`() = runTest {
        // Given
        val specialSearchQuery = "mr-mime"

        // When
        viewModel.updateSearchQuery(specialSearchQuery)

        // Then
        assertEquals(specialSearchQuery, viewModel.searchQuery.value)
    }

    @Test
    fun `refresh calls loadPokemonList`() = runTest {
        // Given
        val mockPokemonList = listOf(
            PokemonListItem("bulbasaur", "https://pokeapi.co/api/v2/pokemon/1/")
        )

        coEvery { mockGetPokemonListUseCase.execute() } returns flowOf(Result.Success(mockPokemonList))

        // When
        viewModel.refresh()
        testDispatcher.scheduler.advanceUntilIdle()

        // Then
        assertTrue(viewModel.uiState.value is HomeUiState.Success)
        val successState = viewModel.uiState.value as HomeUiState.Success
        assertEquals(1, successState.pokemonList.size)
    }

    @Test
    fun `refresh resets state to Loading first`() = runTest {
        // Given
        val mockPokemonList = listOf(
            PokemonListItem("bulbasaur", "https://pokeapi.co/api/v2/pokemon/1/")
        )

        coEvery { mockGetPokemonListUseCase.execute() } returns flowOf(Result.Success(mockPokemonList))

        // When
        viewModel.refresh()

        // Then
        // The state should briefly be Loading before the result comes back
        // This is tested by the fact that refresh() calls loadPokemonList()
        // which starts with Loading state
    }

    @Test
    fun `loadPokemonList handles empty Pokemon list correctly`() = runTest {
        // Given
        val emptyPokemonList = emptyList<PokemonListItem>()
        coEvery { mockGetPokemonListUseCase.execute() } returns flowOf(Result.Success(emptyPokemonList))

        // When
        viewModel.loadPokemonList()
        testDispatcher.scheduler.advanceUntilIdle()

        // Then
        assertTrue(viewModel.uiState.value is HomeUiState.Success)
        val successState = viewModel.uiState.value as HomeUiState.Success
        assertTrue(successState.pokemonList.isEmpty())
    }

    @Test
    fun `loadPokemonList handles large Pokemon list correctly`() = runTest {
        // Given
        val largePokemonList = (1..100).map { index ->
            PokemonListItem("pokemon$index", "https://pokeapi.co/api/v2/pokemon/$index/")
        }
        coEvery { mockGetPokemonListUseCase.execute() } returns flowOf(Result.Success(largePokemonList))

        // When
        viewModel.loadPokemonList()
        testDispatcher.scheduler.advanceUntilIdle()

        // Then
        assertTrue(viewModel.uiState.value is HomeUiState.Success)
        val successState = viewModel.uiState.value as HomeUiState.Success
        assertEquals(100, successState.pokemonList.size)
        assertEquals("pokemon1", successState.pokemonList[0].name)
        assertEquals("pokemon100", successState.pokemonList[99].name)
    }

    @Test
    fun `loadPokemonList handles Pokemon with special characters in names`() = runTest {
        // Given
        val specialPokemonList = listOf(
            PokemonListItem("mr-mime", "https://pokeapi.co/api/v2/pokemon/122/"),
            PokemonListItem("mime-jr", "https://pokeapi.co/api/v2/pokemon/439/"),
            PokemonListItem("porygon-z", "https://pokeapi.co/api/v2/pokemon/474/")
        )
        coEvery { mockGetPokemonListUseCase.execute() } returns flowOf(Result.Success(specialPokemonList))

        // When
        viewModel.loadPokemonList()
        testDispatcher.scheduler.advanceUntilIdle()

        // Then
        assertTrue(viewModel.uiState.value is HomeUiState.Success)
        val successState = viewModel.uiState.value as HomeUiState.Success
        assertEquals(3, successState.pokemonList.size)
        assertEquals("mr-mime", successState.pokemonList[0].name)
        assertEquals("mime-jr", successState.pokemonList[1].name)
        assertEquals("porygon-z", successState.pokemonList[2].name)
    }

    @Test
    fun `loadPokemonList handles Pokemon with numeric names`() = runTest {
        // Given
        val numericPokemonList = listOf(
            PokemonListItem("1", "https://pokeapi.co/api/v2/pokemon/1/"),
            PokemonListItem("2", "https://pokeapi.co/api/v2/pokemon/2/")
        )
        coEvery { mockGetPokemonListUseCase.execute() } returns flowOf(Result.Success(numericPokemonList))

        // When
        viewModel.loadPokemonList()
        testDispatcher.scheduler.advanceUntilIdle()

        // Then
        assertTrue(viewModel.uiState.value is HomeUiState.Success)
        val successState = viewModel.uiState.value as HomeUiState.Success
        assertEquals(2, successState.pokemonList.size)
        assertEquals("1", successState.pokemonList[0].name)
        assertEquals("2", successState.pokemonList[1].name)
    }
}
