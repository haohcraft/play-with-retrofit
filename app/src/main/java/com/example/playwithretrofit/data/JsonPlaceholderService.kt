package com.example.playwithretrofit.data

import com.example.playwithretrofit.data.model.StartedRepo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface JsonPlaceholderService {
    @GET("started/{id}")
    suspend fun getStartedRepoById(@Path("id") id: Int): Response<StartedRepo>

    @GET("started")
    suspend fun getStartedRepos(): Response<List<StartedRepo>>
}




