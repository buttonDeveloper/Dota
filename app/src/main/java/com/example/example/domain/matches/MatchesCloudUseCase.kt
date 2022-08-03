package com.example.example.domain.matches

import com.example.example.data.matches.MatchesRepositoryImpl
import javax.inject.Inject

class MatchesCloudUseCase @Inject constructor(private val repository: MatchesRepositoryImpl) {

    suspend fun getMatches() = repository.getMatches()
}