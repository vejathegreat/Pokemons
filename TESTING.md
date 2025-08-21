# Testing Guide for Pokemon App

This document provides comprehensive information about the testing setup and how to run tests for the Pokemon app.

## Test Structure

The app follows a modular architecture with comprehensive testing at each layer:

### 1. Unit Tests (`src/test/`)
- **Network Layer**: API service, error handling, repository, and use cases
- **Core Layer**: Network utilities and connectivity management
- **ViewModel Layer**: Business logic and state management
- **Constants**: Validation of constant values and configurations

### 2. Instrumentation Tests (`src/androidTest/`)
- **UI Tests**: Compose UI testing with test rules
- **Integration Tests**: End-to-end functionality testing
- **Hilt Testing**: Dependency injection testing

## Test Dependencies

The project uses the following testing libraries:

```kotlin
// Unit Testing
testImplementation(libs.junit)                    // JUnit 4
testImplementation(libs.kotlinx.coroutines.test) // Coroutines testing
testImplementation(libs.mockk)                   // Mocking library
testImplementation(libs.turbine)                 // Flow testing
testImplementation(libs.androidx.core.testing)   // Architecture testing

// Android Testing
androidTestImplementation(libs.androidx.junit)   // Android JUnit
androidTestImplementation(libs.androidx.espresso.core) // UI testing
androidTestImplementation(libs.androidx.ui.test.junit4) // Compose testing
androidTestImplementation(libs.hilt.android.testing) // Hilt testing
```

## Running Tests

### Run All Unit Tests
```bash
./gradlew test
```

### Run Unit Tests for Specific Module
```bash
./gradlew :homemodule:test
./gradlew :network:test
./gradlew :core:test
./gradlew :infomodule:test
```

### Run All Instrumentation Tests
```bash
./gradlew connectedAndroidTest
```

### Run Instrumentation Tests for Specific Module
```bash
./gradlew :app:connectedAndroidTest
./gradlew :homemodule:connectedAndroidTest
./gradlew :infomodule:connectedAndroidTest
```

### Run Tests with Coverage
```bash
./gradlew testDebugUnitTestCoverage
```

## Test Categories

### 1. Network Layer Tests

#### PokeApiServiceTest
- Tests API endpoint configurations
- Validates request/response handling
- Tests parameter passing and URL construction

#### NetworkErrorHandlerTest
- Tests error classification logic
- Validates HTTP status code handling
- Tests network connectivity error detection

#### PokemonRepositoryTest
- Tests repository business logic
- Validates network availability checks
- Tests error propagation and handling

#### Use Case Tests
- Tests business logic in use cases
- Validates data transformation
- Tests error handling and edge cases

### 2. ViewModel Tests

#### HomeViewModelTest
- Tests Pokemon list loading logic
- Validates search functionality
- Tests error state management
- Tests network error detection

#### InfoViewModelTest
- Tests Pokemon detail loading
- Validates refresh functionality
- Tests error handling for different Pokemon types

### 3. Core Module Tests

#### NetworkUtilsTest
- Tests network connectivity detection
- Validates network state flow emissions
- Tests network callback handling
- Tests edge cases and error scenarios

### 4. Constants Tests

#### StringConstantsTest
- Validates all string constants are defined
- Tests constant values and formats
- Ensures meaningful content in constants

#### NetworkConstantsTest
- Validates API configuration constants
- Tests error message constants
- Ensures proper URL formatting

## Test Utilities

### TestUtils Object
Located in `app/src/test/java/com/velaphi/pokemons/TestUtils.kt`

Provides helper functions for creating mock data:
- `createMockPokemonList(count: Int)`
- `createMockPokemonDetail(...)`
- `createMockSprites()`
- `createMockStats()`
- `createMockTypes()`
- `createMockAbilities()`
- `createMockForms()`

### Mock Data Examples
```kotlin
// Create a simple Pokemon list
val mockPokemonList = TestUtils.createMockPokemonList(5)

// Create a detailed Pokemon response
val mockPokemonDetail = TestUtils.createMockPokemonDetailComplete(
    id = 25,
    name = "pikachu"
)

// Create edge case data
val edgeCasePokemon = TestUtils.createMockEdgeCasePokemonList()
```

## Test Configuration

### Hilt Test Runner
Custom test runner for Android instrumentation tests:
```kotlin
class HiltTestRunner : AndroidJUnitRunner() {
    override fun newApplication(cl: ClassLoader?, name: String?, context: Context?): Application {
        return super.newApplication(cl, HiltTestApplication::class.java.name, context)
    }
}
```

### Compose Test Rules
Test rules for UI testing:
```kotlin
@get:Rule
val composeTestRule: ComposeContentTestRule = createComposeRule()
```

## Test Best Practices

### 1. Test Naming
Use descriptive test names that explain the scenario:
```kotlin
@Test
fun `getAll returns success when network is available and API call succeeds`() = runTest {
    // Test implementation
}
```

### 2. Test Structure
Follow the Given-When-Then pattern:
```kotlin
@Test
fun testExample() = runTest {
    // Given - Setup test data and mocks
    val mockData = createMockData()
    coEvery { mockService.getData() } returns flowOf(Result.Success(mockData))
    
    // When - Execute the method under test
    val result = useCase.execute()
    
    // Then - Verify the expected behavior
    assertTrue(result is Result.Success)
    assertEquals(mockData, result.data)
}
```

### 3. Mocking
Use MockK for mocking dependencies:
```kotlin
@Before
fun setUp() {
    mockService = mockk()
    useCase = MyUseCase(mockService)
}

@Test
fun testWithMock() = runTest {
    coEvery { mockService.getData() } returns flowOf(Result.Success(data))
    // Test implementation
}
```

### 4. Coroutines Testing
Use `runTest` and test dispatchers for coroutine testing:
```kotlin
@Test
fun testCoroutine() = runTest {
    val testDispatcher = StandardTestDispatcher()
    Dispatchers.setMain(testDispatcher)
    
    // Test implementation
    
    Dispatchers.resetMain()
}
```

## Test Coverage Goals

- **Unit Tests**: Aim for >90% line coverage
- **ViewModel Tests**: 100% coverage of business logic
- **Repository Tests**: 100% coverage of data operations
- **Use Case Tests**: 100% coverage of business rules
- **Constants Tests**: 100% coverage of constant validation

## Debugging Tests

### Common Issues

1. **MockK Setup Issues**
   - Ensure mocks are properly configured with `coEvery`
   - Check that mock functions match the actual function signatures

2. **Coroutine Testing Issues**
   - Use `runTest` for coroutine tests
   - Properly handle test dispatchers
   - Use `testDispatcher.scheduler.advanceUntilIdle()` when needed

3. **Hilt Testing Issues**
   - Ensure `@HiltAndroidTest` annotation is used
   - Check that test runner is properly configured
   - Verify module bindings in test configuration

### Debug Commands
```bash
# Run tests with debug output
./gradlew test --debug

# Run specific test class
./gradlew test --tests "com.velaphi.pokemons.network.PokeApiServiceTest"

# Run tests with info logging
./gradlew test --info
```

## Continuous Integration

### GitHub Actions
The project includes GitHub Actions workflows for:
- Running tests on pull requests
- Code coverage reporting
- Test result analysis

### Pre-commit Hooks
Consider adding pre-commit hooks to:
- Run unit tests before commits
- Check test coverage thresholds
- Validate test naming conventions

## Performance Testing

### Test Execution Time
- Unit tests should complete in <30 seconds
- Instrumentation tests should complete in <5 minutes
- Individual test methods should complete in <1 second

### Memory Usage
- Tests should not cause memory leaks
- Mock objects should be properly cleaned up
- Test data should be reasonable in size

## Future Enhancements

### Planned Test Improvements
1. **Property-based Testing**: Using libraries like KotlinTest
2. **Mutation Testing**: Using PITest for mutation testing
3. **Performance Testing**: Adding performance benchmarks
4. **Accessibility Testing**: UI accessibility validation
5. **Visual Regression Testing**: Screenshot comparison tests

### Test Infrastructure
1. **Test Database**: In-memory database for testing
2. **Mock Server**: WireMock for API testing
3. **Test Fixtures**: Factory pattern for test data
4. **Test Categories**: JUnit 5 test tags for organization

## Support and Resources

### Documentation
- [Android Testing Guide](https://developer.android.com/training/testing)
- [Compose Testing](https://developer.android.com/jetpack/compose/testing)
- [Hilt Testing](https://dagger.dev/hilt/testing)
- [MockK Documentation](https://mockk.io/)

### Community
- Stack Overflow: `android-testing`, `compose-testing`
- Android Developers Discord
- Kotlin Testing Community

---

For questions or issues with testing, please refer to the project's issue tracker or contact the development team.
