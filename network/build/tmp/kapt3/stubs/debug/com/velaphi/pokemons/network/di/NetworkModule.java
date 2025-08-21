package com.velaphi.pokemons.network.di;

/**
 * Hilt module providing networking dependencies.
 * This module configures Retrofit, OkHttp, and Moshi for API communication.
 */
@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/velaphi/pokemons/network/di/NetworkModule;", "", "()V", "BASE_URL", "", "provideMoshi", "Lcom/squareup/moshi/Moshi;", "provideNetworkUtils", "Lcom/velaphi/pokemons/core/NetworkUtils;", "context", "Landroid/content/Context;", "provideOkHttpClient", "Lokhttp3/OkHttpClient;", "providePokeApiService", "Lcom/velaphi/pokemons/network/api/PokeApiService;", "retrofit", "Lretrofit2/Retrofit;", "provideRetrofit", "okHttpClient", "moshi", "network_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class NetworkModule {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String BASE_URL = "https://pokeapi.co/api/v2/";
    @org.jetbrains.annotations.NotNull()
    public static final com.velaphi.pokemons.network.di.NetworkModule INSTANCE = null;
    
    private NetworkModule() {
        super();
    }
    
    /**
     * Provides Moshi instance for JSON parsing.
     * @return Configured Moshi instance
     */
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.squareup.moshi.Moshi provideMoshi() {
        return null;
    }
    
    /**
     * Provides OkHttpClient with logging interceptor.
     * @return Configured OkHttpClient instance
     */
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.OkHttpClient provideOkHttpClient() {
        return null;
    }
    
    /**
     * Provides Retrofit instance configured with OkHttp and Moshi.
     * @param okHttpClient The OkHttpClient instance
     * @param moshi The Moshi instance for JSON parsing
     * @return Configured Retrofit instance
     */
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit provideRetrofit(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient okHttpClient, @org.jetbrains.annotations.NotNull()
    com.squareup.moshi.Moshi moshi) {
        return null;
    }
    
    /**
     * Provides PokeApiService implementation.
     * @param retrofit The Retrofit instance
     * @return PokeApiService implementation
     */
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.velaphi.pokemons.network.api.PokeApiService providePokeApiService(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    /**
     * Provides NetworkUtils instance for network connectivity checking.
     * @param context The application context
     * @return NetworkUtils instance
     */
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.velaphi.pokemons.core.NetworkUtils provideNetworkUtils(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
}