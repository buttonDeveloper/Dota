package com.example.example.domain.player

import com.example.example.data.player.PlayerInfoRepositoryImpl
import javax.inject.Inject

class PlayerInfoCloudUseCase @Inject constructor(private val repository: PlayerInfoRepositoryImpl) {

    suspend fun invoke(id: Long) = repository.getPlayerInfo(id)
}