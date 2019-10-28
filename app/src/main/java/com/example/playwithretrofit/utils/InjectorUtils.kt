package com.example.playwithretrofit.utils

import com.example.playwithretrofit.data.DefaultJsonPlaceholderRepository
import com.example.playwithretrofit.data.createJsonPlaceholderService
import com.example.playwithretrofit.ui.StartedReposViewModelFactory
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient

val client = OkHttpClient()
val gson = GsonBuilder().create()

object InjectorUtils {
    fun provideStartedReposViewModelFactory(): StartedReposViewModelFactory {
        val service = createJsonPlaceholderService(client, gson)
        val jsonPlaceholderRepository = DefaultJsonPlaceholderRepository(service)
        return StartedReposViewModelFactory(jsonPlaceholderRepository)
    }
}