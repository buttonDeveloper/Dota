package com.example.example.data.matches.cloud

import com.example.example.data.matches.MatchesData

class MatchesCloudMapper {

    fun cloudToData(cloud: MatchesCloud) = MatchesData(
        cloud.matchId,
        cloud.duration,
        cloud.startTime,
        cloud.radiantTeamId,
        cloud.radiantName,
        cloud.direTeamId,
        cloud.direName,
        cloud.leagueId,
        cloud.leagueName,
        cloud.seriesId,
        cloud.seriesType,
        cloud.radiantScore,
        cloud.direScore,
        cloud.radiantWin,
        cloud.radiant
    )
}