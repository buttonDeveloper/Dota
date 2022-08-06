package com.example.example.domain.player

import com.example.example.data.player.info.PlayerInfoData
import com.example.example.data.player.matches.PlayerMatchesData

interface PlayerInfoRepository {

    suspend fun getPlayerInfo(id: Long): PlayerInfoData?

    suspend fun getPlayerMatches(id: Long): PlayerMatchesData?
}