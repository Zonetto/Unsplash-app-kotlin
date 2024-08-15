package com.example.paging_demo.data.remote

import com.example.paging_demo.BuildConfig
import com.example.paging_demo.model.SearchResult
import com.example.paging_demo.model.UnsplashImage
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnsplashAPI {
    @Headers("Authorization: Client-ID ${BuildConfig.API_KEY}")
    @GET("/photos")
    suspend fun getAllImages(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
    ): List<UnsplashImage>

    @Headers("Authorization: Client-ID ${BuildConfig.API_KEY}")
    @GET("/search/photos")
    suspend fun searchImages(
        //@Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("query") query: String,
    ): SearchResult
}