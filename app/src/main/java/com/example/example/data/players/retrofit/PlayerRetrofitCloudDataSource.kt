package com.example.example.data.players.retrofit

import java.lang.Exception

class PlayerRetrofitCloudDataSource(private val service: PlayerRetrofitCloudService) {

    fun getPlayers(): PlayerRetrofitData {
        val response = service.getUserInfo().execute()
        if (response.code() == 200)
            return response.body()!!
        else
            throw Exception()
    }
}