package com.example.example.data.players.cloud

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlayerCloud(
    @SerialName("account_id") val accountId: Long? = 0,
    @SerialName("avatarfull") val avatar: String? = " ",
    @SerialName("personaname") val name: String? = " ",
    @SerialName("last_match_time") val lastMitchTime: String? = " ",
    @SerialName("similarity") val similarity: String? = " ",
)