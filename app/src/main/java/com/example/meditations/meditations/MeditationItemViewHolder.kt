package com.example.meditations.meditations

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.meditations.databinding.MeditationItemBinding

class MeditationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val meditationText: TextView get() = binding.meditationText
    private val binding: MeditationItemBinding = MeditationItemBinding.bind(itemView)

    fun bind(item: UI.Item) {
        meditationText.text = item.quote
    }
}