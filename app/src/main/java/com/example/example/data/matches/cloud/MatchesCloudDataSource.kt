package com.example.example.data.matches.cloud

import android.util.Log
import com.example.example.core.ApiService
import io.ktor.client.*
import io.ktor.client.request.*

class MatchesCloudDataSource(private val client: HttpClient) {

    suspend fun fetchCloud(): List<MatchesCloudData> {
        return try {
            client.get {
                url(ApiService.MATCHES)
                header("Bearer", ApiService.token)
            }
        } catch (e: Exception) {
            Log.d("bugger", e.stackTraceToString())
            emptyList()
        }
    }

}