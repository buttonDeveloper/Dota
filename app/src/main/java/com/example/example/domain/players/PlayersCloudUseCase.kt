package com.example.example.domain.players

import com.example.example.data.players.PlayersRepositoryImpl
import javax.inject.Inject

class PlayersCloudUseCase @Inject constructor(private val repository: PlayersRepositoryImpl) {

    suspend fun getPlayers(query: String) = repository.getPlayers(query)
}