package com.example.example.core

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiServiceRetrofit {

    fun <T> makeService(clazz: Class<T>): T =
        Retrofit.Builder().baseUrl("ВОТ ЗДЕСЬ ВСТАВЬ СВОЙ АДРЕС")
            .addConverterFactory(GsonConverterFactory.create())
            .client(makeOkHttpClient())
            .build()
            .create(clazz)

    private fun makeOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
        return builder.build()
    }

}