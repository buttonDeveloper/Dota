package com.example.example.ui.fragments

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.example.data.matches.MatchesData
import com.example.example.databinding.MatchesItemBinding

class MatchesAdapter(private val list: List<MatchesData>) : RecyclerView.Adapter<MatchesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(MatchesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            val item = list[position]
            matchId.text = "matches id = ${item.match_id}"
            duration.text = "duration = ${item.duration}"
            startTime.text = "start time = ${item.start_time}"
            radiantName.text = "radiant name = ${item.radiant_name}"
            direName.text = "radiant name = ${item.dire_name}"
            radiantScore.text = "radiant scope = ${item.radiant_score}"
            direScore.text = "dire score = ${item.dire_score}"
            radiantWin.text = "radiant win = ${item.radiant_win}"
        }
    }

    override fun getItemCount() = list.size

    class ViewHolder(val binding: MatchesItemBinding) : RecyclerView.ViewHolder(binding.root)

}