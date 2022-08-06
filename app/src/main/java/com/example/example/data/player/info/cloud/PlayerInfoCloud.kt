package com.example.example.data.player.info.cloud

import com.example.example.data.player.info.MMREstimateData
import com.example.example.data.player.info.PlayerProfileData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlayerInfoCloud(
    @SerialName("solo_competitive_rank") val soloRank: Long? = null,
    @SerialName("competitive_rank") val competitiveRank: Long? = null,
    @SerialName("rank_tier") val rankTier: Long? = null,
    @SerialName("leaderboard_rank") val boardTier: Long? = null,
    @SerialName("mmr_estimate") val mmrData: MMREstimateData? = null,
    @SerialName("profile") val profile: PlayerProfileData? = null,
)
