package com.velaphi.pokemons.core;

import android.content.Context;
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
public final class NetworkUtils_Factory implements Factory<NetworkUtils> {
  private final Provider<Context> contextProvider;

  public NetworkUtils_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public NetworkUtils get() {
    return newInstance(contextProvider.get());
  }

  public static NetworkUtils_Factory create(Provider<Context> contextProvider) {
    return new NetworkUtils_Factory(contextProvider);
  }

  public static NetworkUtils newInstance(Context context) {
    return new NetworkUtils(context);
  }
}
