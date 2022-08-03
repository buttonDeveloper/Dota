package com.example.example.data.matches

import com.example.example.data.matches.cloud.MatchesCloudDataSource
import com.example.example.data.matches.cloud.MatchesCloudMapper
import com.example.example.domain.matches.MatchesRepository
import io.ktor.client.*
import javax.inject.Inject

class MatchesRepositoryImpl @Inject constructor(private val client: HttpClient, private val mapper: MatchesCloudMapper) :
    MatchesRepository {

    override suspend fun getMatches() = MatchesCloudDataSource(client).fetchCloud().map { mapper.cloudToData(it) }

}