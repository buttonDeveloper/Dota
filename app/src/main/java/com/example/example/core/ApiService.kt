package com.example.example.core

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*

class ApiService {

    fun create() = HttpClient(Android) {
        install(Logging) {
            level = LogLevel.ALL
        }
        install(JsonFeature) {
            serializer = KotlinxSerializer(json)
        }
        install(HttpTimeout) {
            requestTimeoutMillis = 15000L
            connectTimeoutMillis = 15000L
            socketTimeoutMillis = 15000L
        }
        defaultRequest {
            if (method != HttpMethod.Get) contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
        }
    }

    private val json = kotlinx.serialization.json.Json {
        ignoreUnknownKeys = true
        isLenient = true
        encodeDefaults = false
    }

    companion object {
        const val token = "CB73BBF1EBD88BF1236903EE2DCFE123"
        private const val BASE_URL = "https://api.opendota.com/api"
        const val MATCHES = "$BASE_URL/proMatches"
        const val MATCHES_LIVE = "$BASE_URL/live"
    }
}




