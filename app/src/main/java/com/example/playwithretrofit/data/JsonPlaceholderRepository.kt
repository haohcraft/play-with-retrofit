package com.example.playwithretrofit.data

import android.util.Log
import com.example.playwithretrofit.config.AppConfigDataSource
import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


interface JsonPlaceholderRepository {
    suspend fun getStartedRepoById(id: Int): StartedRepo
    suspend fun getStartedRepos(): List<StartedRepo>
}

class DefaultJsonPlaceholderRepository(private val jsonPlaceholderService: JsonPlaceholderService): JsonPlaceholderRepository {
    override suspend fun getStartedRepos(): List<StartedRepo> {
        val response = jsonPlaceholderService.getStartedRepos()
        return response.body()!!

    }

    override suspend fun getStartedRepoById(id: Int): StartedRepo {
        val response = jsonPlaceholderService.getStartedRepoById(id)
        Log.i("MainActivity", "response is ${response}")
        return response.body()!!
    }


}