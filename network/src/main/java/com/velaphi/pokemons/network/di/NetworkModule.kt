package com.velaphi.pokemons.network.di

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.velaphi.pokemons.network.api.PokeApiService
import com.velaphi.pokemons.network.constants.NetworkConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton
import com.velaphi.pokemons.core.NetworkUtils

/**
 * Hilt module providing networking dependencies.
 * This module configures Retrofit, OkHttp, and Moshi for API communication.
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    
    private const val BASE_URL = NetworkConstants.BASE_URL
    
    /**
     * Provides Moshi instance for JSON parsing.
     * @return Configured Moshi instance
     */
    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }
    
    /**
     * Provides OkHttpClient with logging interceptor.
     * @return Configured OkHttpClient instance
     */
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }
    
    /**
     * Provides Retrofit instance configured with OkHttp and Moshi.
     * @param okHttpClient The OkHttpClient instance
     * @param moshi The Moshi instance for JSON parsing
     * @return Configured Retrofit instance
     */
    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        moshi: Moshi
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }
    
    /**
     * Provides PokeApiService implementation.
     * @param retrofit The Retrofit instance
     * @return PokeApiService implementation
     */
    @Provides
    @Singleton
    fun providePokeApiService(retrofit: Retrofit): PokeApiService {
        return retrofit.create(PokeApiService::class.java)
    }
    
    /**
     * Provides NetworkUtils instance for network connectivity checking.
     * @param context The application context
     * @return NetworkUtils instance
     */
    @Provides
    @Singleton
    fun provideNetworkUtils(@dagger.hilt.android.qualifiers.ApplicationContext context: Context): NetworkUtils {
        return NetworkUtils(context)
    }
}
