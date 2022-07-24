package com.example.example.domain

import com.example.example.data.matches.MatchesRepository
import javax.inject.Inject

class MatchesCloudUseCase @Inject constructor(private val repository: MatchesRepository) {

    suspend fun getMatches() = repository.getMatches()
}