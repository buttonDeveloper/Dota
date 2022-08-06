package com.example.example.data.player

data class PlayerInfoData(
    val soloRank: Long? = null,
    val competitiveRank: Long? = null,
    val rankTier: Long? = null,
    val boardTier: Long? = null,
    val mmrData: MMREstimateData? = null,
    val profile: PlayerProfileData? = null,
)
