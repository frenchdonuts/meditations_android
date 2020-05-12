package io.onedonut.backburner.meditations

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.onedonut.backburner.databinding.MeditationItemBinding

class MeditationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val meditationText: TextView get() = binding.meditationText
    private val binding: MeditationItemBinding = MeditationItemBinding.bind(itemView)

    fun bind(item: UI.Item) {
        meditationText.text = item.quote
    }
}