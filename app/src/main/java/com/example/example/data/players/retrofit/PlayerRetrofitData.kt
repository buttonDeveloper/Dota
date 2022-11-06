package com.example.example.data.players.retrofit

import com.google.gson.annotations.SerializedName

data class PlayerRetrofitData(
    @SerializedName("accountId") val accountId: Long? = 0,
    @SerializedName("avatar") val avatar: String? = " ",
    @SerializedName("name") val name: String? = " ",
    @SerializedName("lastMitchTime") val lastMitchTime: String? = " ",
    @SerializedName("similarity") val similarity: String? = " ",
)
