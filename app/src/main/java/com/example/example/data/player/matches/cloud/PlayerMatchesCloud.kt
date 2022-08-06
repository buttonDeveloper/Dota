package com.example.example.data.player.matches.cloud

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlayerMatchesCloud(
    @SerialName("win") val wins: Long? = null,
    @SerialName("lose") val loses: Long? = null,
)