package com.example.playwithretrofit.data

import com.example.playwithretrofit.data.model.StartedRepo
import timber.log.Timber


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
        Timber.d("response is $response")
        return response.body()!!
    }


}