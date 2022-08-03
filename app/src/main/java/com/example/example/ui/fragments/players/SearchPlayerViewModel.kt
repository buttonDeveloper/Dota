package com.example.example.ui.fragments.players

import androidx.lifecycle.ViewModel
import com.example.example.domain.players.PlayersCloudUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchPlayerViewModel @Inject constructor(private val playersCloudUseCase: PlayersCloudUseCase): ViewModel() {

    suspend fun getPlayers(query: String) = playersCloudUseCase.getPlayers(query)
}