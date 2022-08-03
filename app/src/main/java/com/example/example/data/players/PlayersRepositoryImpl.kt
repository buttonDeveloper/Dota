package com.example.example.data.players

import com.example.example.data.players.cloud.PlayerSearchCloudDataSource
import com.example.example.data.players.cloud.PlayersCloudMapper
import com.example.example.domain.players.PlayersRepository
import io.ktor.client.*
import javax.inject.Inject

class PlayersRepositoryImpl @Inject constructor(private val client: HttpClient, private val mapper: PlayersCloudMapper) :
    PlayersRepository {

    override suspend fun getPlayers(query: String) =
        PlayerSearchCloudDataSource(client).fetchCloud(query).map { mapper.cloudToData(it) }
}