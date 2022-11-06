package com.example.example.data.players.retrofit

class PayerRetrofitRepository(private val cloudDataSource: PlayerRetrofitCloudDataSource) {

    fun getUserInfo(): PlayerRetrofitData? {
        return try {
            cloudDataSource.getPlayers()
        } catch (e: Exception) {
            null
        }
    }
}