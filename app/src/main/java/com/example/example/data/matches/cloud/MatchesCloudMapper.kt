package com.example.example.data.matches.cloud

import com.example.example.data.matches.MatchesData

class MatchesCloudMapper {

    fun cloudToData(cloud: MatchesCloudData) = MatchesData(
        cloud.match_id,
        cloud.duration,
        cloud.start_time,
        cloud.radiant_team_id,
        cloud.radiant_name,
        cloud.dire_team_id,
        cloud.dire_name,
        cloud.leagueid,
        cloud.league_name,
        cloud.series_id,
        cloud.series_type,
        cloud.radiant_score,
        cloud.dire_score,
        cloud.radiant_win,
        cloud.radiant
    )
}