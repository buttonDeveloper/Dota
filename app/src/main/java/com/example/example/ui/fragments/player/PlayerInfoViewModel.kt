package com.example.example.ui.fragments.player

import androidx.lifecycle.ViewModel
import com.example.example.core.ApiServiceRetrofit
import com.example.example.data.players.retrofit.PayerRetrofitRepository
import com.example.example.data.players.retrofit.PlayerRetrofitCloudDataSource
import com.example.example.data.players.retrofit.PlayerRetrofitCloudService
import com.example.example.domain.player.PlayerInfoCloudUseCase
import com.example.example.domain.player.PlayerMatchesCloudUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlayerInfoViewModel @Inject constructor(
    private val playerInfoCloudUseCase: PlayerInfoCloudUseCase,
    private val playerMatchesCloudUseCase: PlayerMatchesCloudUseCase
) : ViewModel() {

    suspend fun getPlayerInfo(id: Long) = playerInfoCloudUseCase.invoke(id)

    suspend fun getPlayerMatches(id: Long) = playerMatchesCloudUseCase.invoke(id)

    suspend fun getPlayer() =
        PayerRetrofitRepository(PlayerRetrofitCloudDataSource(ApiServiceRetrofit().makeService(PlayerRetrofitCloudService::class.java))).getUserInfo()
}