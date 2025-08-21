package com.velaphi.pokemons.network.repository;

import com.velaphi.pokemons.core.NetworkUtils;
import com.velaphi.pokemons.network.api.PokeApiService;
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
public final class PokemonRepository_Factory implements Factory<PokemonRepository> {
  private final Provider<PokeApiService> pokeApiServiceProvider;

  private final Provider<NetworkUtils> networkUtilsProvider;

  public PokemonRepository_Factory(Provider<PokeApiService> pokeApiServiceProvider,
      Provider<NetworkUtils> networkUtilsProvider) {
    this.pokeApiServiceProvider = pokeApiServiceProvider;
    this.networkUtilsProvider = networkUtilsProvider;
  }

  @Override
  public PokemonRepository get() {
    return newInstance(pokeApiServiceProvider.get(), networkUtilsProvider.get());
  }

  public static PokemonRepository_Factory create(Provider<PokeApiService> pokeApiServiceProvider,
      Provider<NetworkUtils> networkUtilsProvider) {
    return new PokemonRepository_Factory(pokeApiServiceProvider, networkUtilsProvider);
  }

  public static PokemonRepository newInstance(PokeApiService pokeApiService,
      NetworkUtils networkUtils) {
    return new PokemonRepository(pokeApiService, networkUtils);
  }
}
