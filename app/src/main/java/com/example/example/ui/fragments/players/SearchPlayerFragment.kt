package com.example.example.ui.fragments.players

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.example.databinding.FragmentSearchPlayerBinding
import com.example.example.utils.hide
import com.example.example.utils.show
import com.example.example.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SearchPlayerFragment @Inject constructor() : Fragment() {

    private lateinit var binding: FragmentSearchPlayerBinding
    private lateinit var adapter: SearchPlayerAdapter
    private val viewModel: SearchPlayerViewModel by viewModels()
    private var searchJob: Job? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSearchPlayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        initSearch()
        initButtonClear()
    }

    private fun initRecycler() {
        adapter = SearchPlayerAdapter(emptyList())
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
        binding.recycler.adapter = adapter
    }

    private fun initSearch() {
        binding.search.addTextChangedListener { query ->
            searchDebounced(query.toString())
        }
    }

    private fun initButtonClear() {
        binding.button.setOnClickListener {
            adapter.repopulate(emptyList())
            binding.search.text?.clear()
            searchJob?.cancel()
            binding.progressBar.hide()
        }
    }

    private fun search(query: String) {
        if (query.length < 3) {
            toast(requireContext(), "Минимум 3 символа")
            adapter.repopulate(emptyList())
            return
        }
        lifecycleScope.launch(Dispatchers.Main) {
            binding.progressBar.show()
            val result = viewModel.getPlayers(query.toString())
            if (result.isEmpty()) {
                toast(requireContext(), "Пустой список")
                binding.progressBar.hide()
                return@launch
            }
            adapter.repopulate(result)
            binding.progressBar.hide()
        }
    }


    private fun searchDebounced(searchText: String) {
        searchJob?.cancel()
        searchJob = lifecycleScope.launch {
            delay(500)
            search(searchText)
        }
    }

}