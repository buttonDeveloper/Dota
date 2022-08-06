package com.example.example.data.player.matches.cloud

import com.example.example.data.player.matches.PlayerMatchesData

class PlayerMatchesCloudMapper {

    fun cloudToData(cloud: PlayerMatchesCloud?): PlayerMatchesData? {
        cloud?.let { it ->
            return PlayerMatchesData(
                it.wins,
                it.loses
            )
        } ?: kotlin.run {
            return null
        }
    }
}