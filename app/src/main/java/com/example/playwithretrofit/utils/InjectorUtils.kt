package com.example.playwithretrofit.utils

import com.example.playwithretrofit.config.AppConfigDataSource
import com.example.playwithretrofit.data.Api
import com.example.playwithretrofit.data.DefaultJsonPlaceholderRepository
import com.example.playwithretrofit.data.JsonPlaceholderService
import com.example.playwithretrofit.ui.StartedReposViewModelFactory

object InjectorUtils {
    fun provideStartedReposViewModelFactory(): StartedReposViewModelFactory {
        val service = Api.createApiService(
            baseUrl = AppConfigDataSource.JSON_PLACEHOLDER_SERVICE_ENDPOINT,
            service = JsonPlaceholderService::class.java
        )
        val jsonPlaceholderRepository = DefaultJsonPlaceholderRepository(service)
        return StartedReposViewModelFactory(jsonPlaceholderRepository)
    }
}