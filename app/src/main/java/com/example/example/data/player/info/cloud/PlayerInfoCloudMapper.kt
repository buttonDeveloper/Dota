package com.example.example.data.player.info.cloud

import com.example.example.data.player.info.PlayerInfoData

class PlayerInfoCloudMapper {

    fun cloudToData(cloud: PlayerInfoCloud?): PlayerInfoData? {
        cloud?.let { it ->
            return PlayerInfoData(
                it.soloRank,
                it.competitiveRank,
                it.rankTier,
                it.boardTier,
                it.mmrData,
                it.profile
            )
        } ?: kotlin.run {
            return null
        }
    }
}