package com.example.playwithretrofit.utils

import com.example.playwithretrofit.config.AppConfigDataSource
import com.example.playwithretrofit.data.Api
import com.example.playwithretrofit.data.DefaultJsonPlaceholderRepository
import com.example.playwithretrofit.data.JsonPlaceholderService
import com.example.playwithretrofit.ui.StartedReposViewModelFactory
import timber.log.Timber

object InjectorUtils {
    fun provideStartedReposViewModelFactory(): StartedReposViewModelFactory {
        Timber.d("Creating JSONPlaceholder service")
        val service = Api.createApiService(
            baseUrl = AppConfigDataSource.JSON_PLACEHOLDER_SERVICE_ENDPOINT,
            service = JsonPlaceholderService::class.java
        )
        val jsonPlaceholderRepository = DefaultJsonPlaceholderRepository(service)
        return StartedReposViewModelFactory(jsonPlaceholderRepository)
    }
}