package com.example.example.domain.player

import com.example.example.data.player.PlayerInfoData

interface PlayerInfoRepository {

    suspend fun getPlayerInfo(id: Long): PlayerInfoData?
}