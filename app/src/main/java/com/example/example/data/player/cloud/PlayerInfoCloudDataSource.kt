package com.example.example.data.player.cloud

import android.util.Log
import com.example.example.core.ApiService
import io.ktor.client.*
import io.ktor.client.request.*

class PlayerInfoCloudDataSource(private val client: HttpClient) {

    suspend fun fetchCloud(id: Long): PlayerInfoCloud? {
        return try {
            client.get {
                url("${ApiService.PLAYER_INFO}/$id")
                header("Bearer", ApiService.token)
            }
        } catch (e: Exception) {
            Log.d("bugger", e.stackTraceToString())
            null
        }
    }
}