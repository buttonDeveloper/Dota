package com.example.example.domain.matches

import com.example.example.data.matches.MatchesData

interface MatchesRepository {

    suspend fun getMatches(): List<MatchesData>
}