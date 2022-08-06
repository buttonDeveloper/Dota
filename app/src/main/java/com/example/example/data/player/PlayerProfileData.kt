package com.example.example.data.player

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlayerProfileData(
    @SerialName("account_id") val accountId: Long? = null,
    @SerialName("personaname") val personName: String? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("plus") val plus: Boolean? = null,
    @SerialName("cheese") val cheese: Long? = null,
    @SerialName("steamid") val steamId: String? = null,
    @SerialName("avatar") val avatar: String? = null,
    @SerialName("avatarmedium") val avatarMedium: String? = null,
    @SerialName("avatarfull") val avatarFull: String? = null,
    @SerialName("profileurl") val profileUrl: String? = null,
    @SerialName("last_login") val lastLogin: String? = null,
    @SerialName("loccountrycode") val locCountryCode: String? = null,
    @SerialName("is_contributor") val isContributor: Boolean? = null,
    @SerialName("is_subscriber") val isSubscriber: Boolean? = null,
)