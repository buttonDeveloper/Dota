package com.example.example.data.player.matches.cloud

import android.util.Log
import com.example.example.core.ApiService
import io.ktor.client.*
import io.ktor.client.request.*

class PlayerMatchesCloudDataSource(private val client: HttpClient) {

    suspend fun fetchCloud(id: Long): PlayerMatchesCloud? {
        return try {
            client.get {
                url("${ApiService.PLAYER_INFO}/$id/wl")
                header("Bearer", ApiService.token)
            }
        } catch (e: Exception) {
            Log.d("bugger", e.stackTraceToString())
            null
        }
    }
}