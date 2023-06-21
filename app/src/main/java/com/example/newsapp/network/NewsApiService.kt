package com.example.newsapp.network

import com.example.newsapp.model.News
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

private const val BASE_URL = "https://newsapi.org/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface NewsApiService {
    @Headers("X-Api-Key: 4fd028e0cf3a410180f97029e7237ae7")
    @GET("v2/top-headlines")
    suspend fun getNewsHeadLines(@Query("country") country: String = "us"): News

    @Headers("X-Api-Key: 4fd028e0cf3a410180f97029e7237ae7")
    @GET("v2/top-headlines")
    suspend fun getNewsByCategory(@Query("country") country: String = "us", @Query("category") category: String): News
}

object NewsApi {
    val retrofitService: NewsApiService by lazy { retrofit.create(NewsApiService::class.java) }
}