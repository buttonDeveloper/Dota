package com.example.example.ui.fragments

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.example.R
import com.example.example.data.matches.MatchesData
import com.example.example.databinding.MatchesItemBinding

class MatchesAdapter(private val list: List<MatchesData>) : RecyclerView.Adapter<MatchesAdapter.ViewHolder>() {

    private var lastPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(MatchesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    @SuppressLint("SetTextI18n", "ResourceType")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val animation = AnimationUtils.loadAnimation(holder.itemView.context, if(position < lastPosition) R.xml.down_from_top else  R.xml.up_from_bottom)
        holder.itemView.startAnimation(animation)
        lastPosition = holder.adapterPosition
        with(holder.binding) {
            val item = list[position]
            matchId.text = "matches id = ${item.match_id}"
            duration.text = "duration = ${item.duration}"
            startTime.text = "start time = ${item.start_time}"
            radiantName.text = "radiant name = ${item.radiant_name}"
            direName.text = "dire name = ${item.dire_name}"
            radiantScore.text = "radiant scope = ${item.radiant_score}"
            direScore.text = "dire score = ${item.dire_score}"
            radiantWin.text = "radiant win = ${item.radiant_win}"
        }
    }

    override fun getItemCount() = list.size

    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.itemView.clearAnimation()
    }

    class ViewHolder(val binding: MatchesItemBinding) : RecyclerView.ViewHolder(binding.root)

}