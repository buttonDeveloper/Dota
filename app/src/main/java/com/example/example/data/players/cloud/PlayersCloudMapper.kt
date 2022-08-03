package com.example.example.data.players.cloud

import com.example.example.data.players.PlayerData

class PlayersCloudMapper {

    fun cloudToData(cloud: PlayerCloud) =
        PlayerData(cloud.accountId, cloud.avatar, cloud.name, cloud.lastMitchTime, cloud.similarity)
}