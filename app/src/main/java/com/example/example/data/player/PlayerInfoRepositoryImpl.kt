package com.example.example.data.player

import com.example.example.data.player.cloud.PlayerInfoCloudDataSource
import com.example.example.data.player.cloud.PlayerInfoCloudMapper
import com.example.example.domain.player.PlayerInfoRepository
import io.ktor.client.*
import javax.inject.Inject

class PlayerInfoRepositoryImpl @Inject constructor(private val client: HttpClient, private val mapper: PlayerInfoCloudMapper) :
    PlayerInfoRepository {

    override suspend fun getPlayerInfo(id: Long) = mapper.cloudToData(PlayerInfoCloudDataSource(client).fetchCloud(id))

}