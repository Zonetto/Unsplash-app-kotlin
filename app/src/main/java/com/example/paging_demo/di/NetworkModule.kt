package com.example.paging_demo.di

import com.example.paging_demo.data.remote.UnsplashAPI
import com.example.paging_demo.utils.Constant.BASE_URL
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS).build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val contentType = "application/json".toMediaType()
        val Json = Json {
            ignoreUnknownKeys = true
        }
        val retrofit: Retrofit by lazy {
            Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
                .addConverterFactory(Json.asConverterFactory(contentType)).build()
        }
        return retrofit
    }

    @Provides
    @Singleton
    fun provideUnsplashApi(retrofit: Retrofit): UnsplashAPI {
        return retrofit.create(UnsplashAPI::class.java)
    }

}