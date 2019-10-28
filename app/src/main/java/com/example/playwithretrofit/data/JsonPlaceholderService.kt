package com.example.playwithretrofit.data

import com.example.playwithretrofit.config.AppConfigDataSource
import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface JsonPlaceholderService {
    @GET("started/{id}")
    suspend fun getStartedRepoById(@Path("id") id: Int): Response<StartedRepo>

    @GET("started")
    suspend fun getStartedRepos(): Response<List<StartedRepo>>
}

fun createJsonPlaceholderService(
    client: OkHttpClient,
    converter: Gson
): JsonPlaceholderService {

    val retrofit = Retrofit.Builder()
        .baseUrl(AppConfigDataSource.JSON_PLACEHOLDER_SERVICE_ENDPOINT)
        .addConverterFactory(GsonConverterFactory.create(converter))
        .client(client)
        .build()
    return retrofit.create(JsonPlaceholderService::class.java)
}


