package com.example.example.data.players.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface PlayerRetrofitCloudService {
    @GET("/users/current/")
    fun getUserInfo(): Call<PlayerRetrofitData>
}