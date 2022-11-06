package com.example.example.ui.fragments.player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.example.databinding.FragmentPlayerProfileBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class PlayerInfoFragment @Inject constructor() : Fragment() {

    private lateinit var binding: FragmentPlayerProfileBinding
    private val viewModel: PlayerInfoViewModel by viewModels()
    private var userId = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userId = requireArguments().getLong("id")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPlayerProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch(Dispatchers.Main) {
            viewModel.getPlayerInfo(userId)?.let { info ->
                Glide.with(requireContext()).load(info.profile?.avatarFull).centerCrop().into(binding.imageViewAvatar)
                binding.textViewLastLogin.text = "last login = ${info.profile?.lastLogin}"
                binding.textViewName.text = info.profile?.personName
                binding.textViewLeaderboardRank.text = "leaderboard rank = ${info.boardTier}"
                binding.textViewPlus.text = "does the plus have = ${info.profile?.plus}"
                binding.textViewMmr.text = "mmr = ${info.soloRank}"
                binding.textViewRank.text = "rank = ${info.soloRank}"
                binding.textViewRankTier.text = "rank tier = ${info.rankTier}"
            }
            viewModel.getPlayerMatches(userId)?.let { matches ->
                binding.textViewWin.text = "Wins: ${matches.wins}"
                binding.textViewLose.text = "Wins: ${matches.loses}"
                binding.textViewPercent.text = "Winrate: ${getWinrate(matches.wins!!, matches.loses!!)}%"
            }
        }
        lifecycleScope.launch(Dispatchers.IO) {
            viewModel.getPlayer()
        }
    }

    private fun getWinrate(wins: Long, loses: Long): String {
        val matches = wins + loses
        val winrate = (wins.toDouble() / matches.toDouble()) * 100
        return winrate.toString().take(5)
    }
}