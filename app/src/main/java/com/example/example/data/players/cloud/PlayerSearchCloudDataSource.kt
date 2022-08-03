package com.example.example.data.players.cloud

import android.util.Log
import com.example.example.core.ApiService
import io.ktor.client.*
import io.ktor.client.request.*

class PlayerSearchCloudDataSource(private val client: HttpClient) {

    suspend fun fetchCloud(query: String): List<PlayerCloud> {
        return try {
            client.get {
                url(ApiService.PLAYERS_SEARCH)
                header("Bearer", ApiService.token)
                parameter("q", query)
            }
        } catch (e: Exception) {
            Log.d("bugger", e.stackTraceToString())
            emptyList()
        }
    }
}