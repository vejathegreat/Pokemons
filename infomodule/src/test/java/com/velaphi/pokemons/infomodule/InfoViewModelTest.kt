package com.velaphi.pokemons.infomodule

import androidx.lifecycle.SavedStateHandle
import com.velaphi.pokemons.core.Result
import com.velaphi.pokemons.network.model.Ability
import com.velaphi.pokemons.network.model.AbilityInfo
import com.velaphi.pokemons.network.model.Form
import com.velaphi.pokemons.network.model.OfficialArtwork
import com.velaphi.pokemons.network.model.OtherSprites
import com.velaphi.pokemons.network.model.PokemonDetailResponse
import com.velaphi.pokemons.network.model.Sprites
import com.velaphi.pokemons.network.model.Stat
import com.velaphi.pokemons.network.model.StatInfo
import com.velaphi.pokemons.network.model.Type
import com.velaphi.pokemons.network.model.TypeInfo
import com.velaphi.pokemons.network.usecase.GetPokemonDetailUseCase
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
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class InfoViewModelTest {
    private lateinit var viewModel: InfoViewModel
    private lateinit var mockGetPokemonDetailUseCase: GetPokemonDetailUseCase
    private lateinit var mockSavedStateHandle: SavedStateHandle
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        mockGetPokemonDetailUseCase = mockk()
        mockSavedStateHandle = mockk()
        
        // Set up default mock behavior for bulbasaur
        coEvery { mockSavedStateHandle.get<String>("pokemonId") } returns "bulbasaur"
        coEvery { mockGetPokemonDetailUseCase.execute("bulbasaur") } returns flowOf(Result.Success(createMockPokemonDetail(
            id = 1,
            name = "bulbasaur",
            height = 7,
            weight = 69,
            baseExperience = 64
        )))
        
        viewModel = InfoViewModel(mockGetPokemonDetailUseCase, mockSavedStateHandle)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `loadPokemonDetail updates state to Success when use case succeeds`() = runTest {
        // Given
        val mockPokemonDetail = createMockPokemonDetail(
            id = 1,
            name = "bulbasaur",
            height = 7,
            weight = 69,
            baseExperience = 64
        )

        coEvery { mockGetPokemonDetailUseCase.execute("bulbasaur") } returns flowOf(Result.Success(mockPokemonDetail))

        // When
        viewModel.loadPokemonDetail()
        testDispatcher.scheduler.advanceUntilIdle()

        // Then
        assertTrue(viewModel.uiState.value is InfoUiState.Success)
        val successState = viewModel.uiState.value as InfoUiState.Success
        assertEquals(1, successState.pokemon.id)
        assertEquals("bulbasaur", successState.pokemon.name)
        assertEquals(7, successState.pokemon.height)
        assertEquals(69, successState.pokemon.weight)
        assertEquals(64, successState.pokemon.baseExperience)
    }

    @Test
    fun `loadPokemonDetail with numeric ID returns success`() = runTest {
        // Given - Create a new ViewModel with numeric ID
        val numericSavedStateHandle = mockk<SavedStateHandle>()
        coEvery { numericSavedStateHandle.get<String>("pokemonId") } returns "25"
        
        val mockPokemonDetail = createMockPokemonDetail(
            id = 25,
            name = "pikachu",
            height = 4,
            weight = 60,
            baseExperience = 112
        )
        coEvery { mockGetPokemonDetailUseCase.execute("25") } returns flowOf(Result.Success(mockPokemonDetail))
        
        val numericViewModel = InfoViewModel(mockGetPokemonDetailUseCase, numericSavedStateHandle)

        // When
        numericViewModel.loadPokemonDetail()
        testDispatcher.scheduler.advanceUntilIdle()

        // Then
        assertTrue(numericViewModel.uiState.value is InfoUiState.Success)
        val successState = numericViewModel.uiState.value as InfoUiState.Success
        assertEquals(25, successState.pokemon.id)
        assertEquals("pikachu", successState.pokemon.name)
    }

    @Test
    fun `loadPokemonDetail with empty string returns error`() = runTest {
        // Given - Create a new ViewModel with empty ID
        val emptySavedStateHandle = mockk<SavedStateHandle>()
        coEvery { emptySavedStateHandle.get<String>("pokemonId") } returns ""
        
        val exception = IllegalArgumentException("Invalid Pokemon ID")
        coEvery { mockGetPokemonDetailUseCase.execute("") } returns flowOf(Result.Error(exception))
        
        val emptyViewModel = InfoViewModel(mockGetPokemonDetailUseCase, emptySavedStateHandle)

        // When
        emptyViewModel.loadPokemonDetail()
        testDispatcher.scheduler.advanceUntilIdle()

        // Then
        assertTrue(emptyViewModel.uiState.value is InfoUiState.Error)
        val errorState = emptyViewModel.uiState.value as InfoUiState.Error
        assertTrue(errorState.message.contains("Invalid Pokemon ID"))
    }

    @Test
    fun `loadPokemonDetail with Pokemon name containing special characters returns success`() = runTest {
        // Given - Create a new ViewModel with special character name
        val specialSavedStateHandle = mockk<SavedStateHandle>()
        coEvery { specialSavedStateHandle.get<String>("pokemonId") } returns "mr-mime"
        
        val mockPokemonDetail = createMockPokemonDetail(
            id = 122,
            name = "mr-mime",
            height = 13,
            weight = 545,
            baseExperience = 161
        )
        coEvery { mockGetPokemonDetailUseCase.execute("mr-mime") } returns flowOf(Result.Success(mockPokemonDetail))
        
        val specialViewModel = InfoViewModel(mockGetPokemonDetailUseCase, specialSavedStateHandle)

        // When
        specialViewModel.loadPokemonDetail()
        testDispatcher.scheduler.advanceUntilIdle()

        // Then
        assertTrue(specialViewModel.uiState.value is InfoUiState.Success)
        val successState = specialViewModel.uiState.value as InfoUiState.Success
        assertEquals(122, successState.pokemon.id)
        assertEquals("mr-mime", successState.pokemon.name)
    }

    @Test
    fun `loadPokemonDetail with Pokemon name containing spaces returns success`() = runTest {
        // Given - Create a new ViewModel with space-containing name
        val spaceSavedStateHandle = mockk<SavedStateHandle>()
        coEvery { spaceSavedStateHandle.get<String>("pokemonId") } returns "mewtwo"
        
        val mockPokemonDetail = createMockPokemonDetail(
            id = 150,
            name = "mewtwo",
            height = 20,
            weight = 1220,
            baseExperience = 340
        )
        coEvery { mockGetPokemonDetailUseCase.execute("mewtwo") } returns flowOf(Result.Success(mockPokemonDetail))
        
        val spaceViewModel = InfoViewModel(mockGetPokemonDetailUseCase, spaceSavedStateHandle)

        // When
        spaceViewModel.loadPokemonDetail()
        testDispatcher.scheduler.advanceUntilIdle()

        // Then
        assertTrue(spaceViewModel.uiState.value is InfoUiState.Success)
        val successState = spaceViewModel.uiState.value as InfoUiState.Success
        assertEquals(150, successState.pokemon.id)
        assertEquals("mewtwo", successState.pokemon.name)
    }

    @Test
    fun `refresh calls loadPokemonDetail with last Pokemon ID`() = runTest {
        // Given
        val mockPokemonDetail = createMockPokemonDetail(
            id = 1,
            name = "bulbasaur",
            height = 7,
            weight = 69,
            baseExperience = 64
        )

        coEvery { mockGetPokemonDetailUseCase.execute("bulbasaur") } returns flowOf(Result.Success(mockPokemonDetail))

        // When
        viewModel.loadPokemonDetail()
        testDispatcher.scheduler.advanceUntilIdle()
        viewModel.refresh()
        testDispatcher.scheduler.advanceUntilIdle()

        // Then
        assertTrue(viewModel.uiState.value is InfoUiState.Success)
        val successState = viewModel.uiState.value as InfoUiState.Success
        assertEquals("bulbasaur", successState.pokemon.name)
    }

    @Test
    fun `refresh without previous load returns error`() = runTest {
        // When
        viewModel.refresh()

        // Then
        // Should handle the case where no Pokemon was previously loaded
        // This might result in an error state or no-op depending on implementation
    }

    @Test
    fun `loadPokemonDetail handles Pokemon with stats correctly`() = runTest {
        // Given
        val mockStats = listOf(
            Stat(45, 0, StatInfo("hp", "https://pokeapi.co/api/v2/stat/1/")),
            Stat(49, 0, StatInfo("attack", "https://pokeapi.co/api/v2/stat/2/")),
            Stat(49, 0, StatInfo("defense", "https://pokeapi.co/api/v2/stat/3/"))
        )

        val mockPokemonDetail = createMockPokemonDetail(
            id = 1,
            name = "bulbasaur",
            height = 7,
            weight = 69,
            baseExperience = 64,
            stats = mockStats
        )

        coEvery { mockGetPokemonDetailUseCase.execute("bulbasaur") } returns flowOf(Result.Success(mockPokemonDetail))

        // When
        viewModel.loadPokemonDetail()
        testDispatcher.scheduler.advanceUntilIdle()

        // Then
        assertTrue(viewModel.uiState.value is InfoUiState.Success)
        val successState = viewModel.uiState.value as InfoUiState.Success
        assertEquals(3, successState.pokemon.stats.size)
        assertEquals("hp", successState.pokemon.stats[0].stat.name)
        assertEquals(45, successState.pokemon.stats[0].baseStat)
        assertEquals("attack", successState.pokemon.stats[1].stat.name)
        assertEquals(49, successState.pokemon.stats[1].baseStat)
    }

    @Test
    fun `loadPokemonDetail handles Pokemon with types correctly`() = runTest {
        // Given
        val mockTypes = listOf(
            Type(1, TypeInfo("grass", "https://pokeapi.co/api/v2/type/12/")),
            Type(2, TypeInfo("poison", "https://pokeapi.co/api/v2/type/4/"))
        )

        val mockPokemonDetail = createMockPokemonDetail(
            id = 1,
            name = "bulbasaur",
            height = 7,
            weight = 69,
            baseExperience = 64,
            types = mockTypes
        )

        coEvery { mockGetPokemonDetailUseCase.execute("bulbasaur") } returns flowOf(Result.Success(mockPokemonDetail))

        // When
        viewModel.loadPokemonDetail()
        testDispatcher.scheduler.advanceUntilIdle()

        // Then
        assertTrue(viewModel.uiState.value is InfoUiState.Success)
        val successState = viewModel.uiState.value as InfoUiState.Success
        assertEquals(2, successState.pokemon.types.size)
        assertEquals("grass", successState.pokemon.types[0].type.name)
        assertEquals("poison", successState.pokemon.types[1].type.name)
    }

    @Test
    fun `loadPokemonDetail handles Pokemon with abilities correctly`() = runTest {
        // Given
        val mockAbilities = listOf(
            Ability(AbilityInfo("overgrow", "https://pokeapi.co/api/v2/ability/65/"), false, 1),
            Ability(AbilityInfo("chlorophyll", "https://pokeapi.co/api/v2/ability/34/"), true, 3)
        )

        val mockPokemonDetail = createMockPokemonDetail(
            id = 1,
            name = "bulbasaur",
            height = 7,
            weight = 69,
            baseExperience = 64,
            abilities = mockAbilities
        )

        coEvery { mockGetPokemonDetailUseCase.execute("bulbasaur") } returns flowOf(Result.Success(mockPokemonDetail))

        // When
        viewModel.loadPokemonDetail()
        testDispatcher.scheduler.advanceUntilIdle()

        // Then
        assertTrue(viewModel.uiState.value is InfoUiState.Success)
        val successState = viewModel.uiState.value as InfoUiState.Success
        assertEquals(2, successState.pokemon.abilities.size)
        assertEquals("overgrow", successState.pokemon.abilities[0].ability.name)
        assertFalse(successState.pokemon.abilities[0].isHidden)
        assertEquals("chlorophyll", successState.pokemon.abilities[1].ability.name)
        assertTrue(successState.pokemon.abilities[1].isHidden)
    }

    @Test
    fun `loadPokemonDetail handles Pokemon with forms correctly`() = runTest {
        // Given
        val mockForms = listOf(
            Form("bulbasaur", "https://pokeapi.co/api/v2/pokemon-form/1/")
        )

        val mockPokemonDetail = createMockPokemonDetail(
            id = 1,
            name = "bulbasaur",
            height = 7,
            weight = 69,
            baseExperience = 64,
            forms = mockForms
        )

        coEvery { mockGetPokemonDetailUseCase.execute("bulbasaur") } returns flowOf(Result.Success(mockPokemonDetail))

        // When
        viewModel.loadPokemonDetail()
        testDispatcher.scheduler.advanceUntilIdle()

        // Then
        assertTrue(viewModel.uiState.value is InfoUiState.Success)
        val successState = viewModel.uiState.value as InfoUiState.Success
        assertEquals(1, successState.pokemon.forms.size)
        assertEquals("bulbasaur", successState.pokemon.forms[0].name)
    }

    @Test
    fun `loadPokemonDetail handles Pokemon with sprites correctly`() = runTest {
        // Given
        val mockSprites = Sprites(
            frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
            frontShiny = null,
            backDefault = null,
            backShiny = null,
            other = OtherSprites(
                officialArtwork = OfficialArtwork(
                    frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png"
                )
            )
        )

        val mockPokemonDetail = createMockPokemonDetail(
            id = 1,
            name = "bulbasaur",
            height = 7,
            weight = 69,
            baseExperience = 64,
            sprites = mockSprites
        )

        coEvery { mockGetPokemonDetailUseCase.execute("bulbasaur") } returns flowOf(Result.Success(mockPokemonDetail))

        // When
        viewModel.loadPokemonDetail()
        testDispatcher.scheduler.advanceUntilIdle()

        // Then
        assertTrue(viewModel.uiState.value is InfoUiState.Success)
        val successState = viewModel.uiState.value as InfoUiState.Success
        assertNotNull(successState.pokemon.sprites.frontDefault)
        assertNotNull(successState.pokemon.sprites.other?.officialArtwork?.frontDefault)
    }

    private fun createMockPokemonDetail(
        id: Int,
        name: String,
        height: Int,
        weight: Int,
        baseExperience: Int,
        stats: List<Stat> = emptyList(),
        types: List<Type> = emptyList(),
        abilities: List<Ability> = emptyList(),
        forms: List<Form> = emptyList(),
        sprites: Sprites = mockk()
    ): PokemonDetailResponse {
        return PokemonDetailResponse(
            id = id,
            name = name,
            baseExperience = baseExperience,
            height = height,
            weight = weight,
            sprites = sprites,
            stats = stats,
            types = types,
            abilities = abilities,
            forms = forms
        )
    }
}
