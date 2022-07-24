package com.example.example.ui.fragments

import androidx.lifecycle.ViewModel
import com.example.example.data.matches.MatchesData
import com.example.example.domain.MatchesCloudUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(private val matchesCloudUseCase: MatchesCloudUseCase): ViewModel() {

    suspend fun getMatches(): List<MatchesData> = matchesCloudUseCase.getMatches()

}