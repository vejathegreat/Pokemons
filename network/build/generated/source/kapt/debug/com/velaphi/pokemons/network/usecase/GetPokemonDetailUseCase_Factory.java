package com.velaphi.pokemons.network.usecase;

import com.velaphi.pokemons.network.repository.PokemonRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class GetPokemonDetailUseCase_Factory implements Factory<GetPokemonDetailUseCase> {
  private final Provider<PokemonRepository> pokemonRepositoryProvider;

  public GetPokemonDetailUseCase_Factory(Provider<PokemonRepository> pokemonRepositoryProvider) {
    this.pokemonRepositoryProvider = pokemonRepositoryProvider;
  }

  @Override
  public GetPokemonDetailUseCase get() {
    return newInstance(pokemonRepositoryProvider.get());
  }

  public static GetPokemonDetailUseCase_Factory create(
      Provider<PokemonRepository> pokemonRepositoryProvider) {
    return new GetPokemonDetailUseCase_Factory(pokemonRepositoryProvider);
  }

  public static GetPokemonDetailUseCase newInstance(PokemonRepository pokemonRepository) {
    return new GetPokemonDetailUseCase(pokemonRepository);
  }
}
