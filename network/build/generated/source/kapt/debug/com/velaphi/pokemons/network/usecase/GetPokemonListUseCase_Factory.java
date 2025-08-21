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
public final class GetPokemonListUseCase_Factory implements Factory<GetPokemonListUseCase> {
  private final Provider<PokemonRepository> pokemonRepositoryProvider;

  public GetPokemonListUseCase_Factory(Provider<PokemonRepository> pokemonRepositoryProvider) {
    this.pokemonRepositoryProvider = pokemonRepositoryProvider;
  }

  @Override
  public GetPokemonListUseCase get() {
    return newInstance(pokemonRepositoryProvider.get());
  }

  public static GetPokemonListUseCase_Factory create(
      Provider<PokemonRepository> pokemonRepositoryProvider) {
    return new GetPokemonListUseCase_Factory(pokemonRepositoryProvider);
  }

  public static GetPokemonListUseCase newInstance(PokemonRepository pokemonRepository) {
    return new GetPokemonListUseCase(pokemonRepository);
  }
}
