package com.example.example.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.example.databinding.LayoutMainFragmentBinding
import com.example.example.utils.hide
import com.example.example.utils.show
import com.example.example.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment @Inject constructor() : Fragment() {

    private lateinit var binding: LayoutMainFragmentBinding
    private val viewModel: MainFragmentViewModel by viewModels()
    private var adapter: MatchesAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = LayoutMainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            showMatches()
        }
    }

    private fun showMatches() {
        binding.button.hide()
        binding.progressBar.show()
        lifecycleScope.launch() {
            val response = viewModel.getMatches()
            withContext(Dispatchers.Main) {
                if (response.isNotEmpty()) {
                    binding.progressBar.hide()
                    binding.recycler.show()
                    binding.recycler.layoutManager = LinearLayoutManager(requireContext())
                    adapter = MatchesAdapter(response)
                    binding.recycler.adapter = adapter
                } else {
                    binding.button.show()
                    binding.progressBar.hide()
                    toast(requireContext(), "Ничего не пришло")
                }

            }
        }
    }
}