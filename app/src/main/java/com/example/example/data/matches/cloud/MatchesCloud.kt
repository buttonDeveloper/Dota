package com.example.example.data.matches.cloud

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MatchesCloud(
    @SerialName("match_id") val matchId: Long? = 0,
    @SerialName("duration") val duration: Int? = 0,
    @SerialName("start_time") val startTime: Long? = 0,
    @SerialName("radiant_team_id") val radiantTeamId: Int? = 0,
    @SerialName("radiant_name") val radiantName: String? = " ",
    @SerialName("dire_team_id") val direTeamId: Int? = 0,
    @SerialName("dire_name") val direName: String? = " ",
    @SerialName("leagueid") val leagueId: Int? = 0,
    @SerialName("league_name") val leagueName: String? = " ",
    @SerialName("series_id") val seriesId: Int? = 0,
    @SerialName("series_type") val seriesType: Int? = 0,
    @SerialName("radiant_score") val radiantScore: Int? = 0,
    @SerialName("dire_score") val direScore: Int? = 0,
    @SerialName("radiant_win") val radiantWin: Boolean? = false,
    @SerialName("radiant") val radiant: Boolean? = false
)