package com.example.playwithretrofit.data

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Api {

    fun createConverterFactory(): GsonConverterFactory {
        val gson = GsonBuilder().create()
        return GsonConverterFactory.create(gson)
    }

    fun createHttpClient() = OkHttpClient()

    fun <T : Any?> createApiService(
        baseUrl: String,
        service: Class<T>
    ): T {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(createConverterFactory())
            .client(createHttpClient())
            .build()
            .create(service)
    }
}
