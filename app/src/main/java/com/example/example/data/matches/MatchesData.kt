package com.example.example.data.matches

data class MatchesData(
    val match_id: Long? = 0,
    val duration: Int? = 0,
    val start_time: Long? = 0,
    val radiant_team_id: Int? = 0,
    val radiant_name: String? = " ",
    val dire_team_id: Int? = 0,
    val dire_name: String? = " ",
    val leagueid: Int? = 0,
    val league_name: String? = " ",
    val series_id: Int? = 0,
    val series_type: Int? = 0,
    val radiant_score: Int? = 0,
    val dire_score: Int? = 0,
    val radiant_win: Boolean? = false,
    val radiant: Boolean? = false
)