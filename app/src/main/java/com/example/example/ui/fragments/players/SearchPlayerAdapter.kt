package com.example.example.ui.fragments.players

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.example.R
import com.example.example.data.players.PlayerData
import com.example.example.databinding.ItemPlayerBinding

class SearchPlayerAdapter(private var list: List<PlayerData>) : RecyclerView.Adapter<SearchPlayerAdapter.ViewHolder>() {

    private var lastPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    @SuppressLint("SetTextI18n", "ResourceType")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val animation = AnimationUtils.loadAnimation(
            holder.itemView.context,
            if (position < lastPosition) R.xml.down_from_top else R.xml.up_from_bottom
        )
        holder.itemView.startAnimation(animation)
        lastPosition = holder.adapterPosition
        with(holder.binding) {
            val item = list[position]
            accountId.text = "id = ${item.accountId}"
            name.text = "name = ${item.name}"
            lastMatchTime.text = "last match time = ${item.lastMitchTime}"
            similarity.text = "similarity = ${item.similarity}"
            Glide.with(this.root.context).load(item.avatar).centerCrop().into(image)
        }
    }

    override fun getItemCount() = list.size

    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.itemView.clearAnimation()
    }

    fun repopulate(list: List<PlayerData>) {
        this.list = list
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemPlayerBinding) : RecyclerView.ViewHolder(binding.root)

}