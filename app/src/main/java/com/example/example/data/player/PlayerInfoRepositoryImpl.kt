package com.example.example.data.player

import com.example.example.data.player.info.cloud.PlayerInfoCloudDataSource
import com.example.example.data.player.info.cloud.PlayerInfoCloudMapper
import com.example.example.data.player.matches.cloud.PlayerMatchesCloudDataSource
import com.example.example.data.player.matches.cloud.PlayerMatchesCloudMapper
import com.example.example.domain.player.PlayerInfoRepository
import io.ktor.client.*
import javax.inject.Inject

class PlayerInfoRepositoryImpl @Inject constructor(
    private val client: HttpClient,
    private val mapperInfo: PlayerInfoCloudMapper,
    private val mapperMatches: PlayerMatchesCloudMapper
) : PlayerInfoRepository {

    override suspend fun getPlayerInfo(id: Long) = mapperInfo.cloudToData(PlayerInfoCloudDataSource(client).fetchCloud(id))

    override suspend fun getPlayerMatches(id: Long) =
        mapperMatches.cloudToData(PlayerMatchesCloudDataSource(client).fetchCloud(id))

}