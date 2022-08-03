package com.example.example.domain.players

import com.example.example.data.players.PlayerData

interface PlayersRepository {

    suspend fun getPlayers(query: String): List<PlayerData>
}