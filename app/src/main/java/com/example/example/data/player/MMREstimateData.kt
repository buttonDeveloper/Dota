package com.example.example.data.player

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MMREstimateData(
    @SerialName("estimate") val estimate: Long? = null,
)
