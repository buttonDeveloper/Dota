package com.example.example.data.matches

import com.example.example.data.matches.cloud.MatchesCloudDataSource
import com.example.example.data.matches.cloud.MatchesCloudMapper
import io.ktor.client.*
import javax.inject.Inject

class MatchesRepository @Inject constructor(private val client: HttpClient, private val mapper: MatchesCloudMapper) {

    suspend fun getMatches() = MatchesCloudDataSource(client).fetchCloud().map { mapper.cloudToData(it) }

}