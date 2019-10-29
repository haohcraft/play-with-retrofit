package com.example.playwithretrofit.data

import com.example.playwithretrofit.BuildConfig
import com.google.gson.GsonBuilder
import kotlinx.coroutines.processNextEventInCurrentThread
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object Api {

    fun createConverterFactory(): GsonConverterFactory {
        val gson = GsonBuilder().create()
        return GsonConverterFactory.create(gson)
    }

    fun createHttpClient(): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.readTimeout(60, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.HEADERS
            clientBuilder.addInterceptor(interceptor)
        }

        return clientBuilder.build()
    }

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
