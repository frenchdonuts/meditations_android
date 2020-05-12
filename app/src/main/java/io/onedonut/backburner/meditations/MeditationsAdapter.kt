package io.onedonut.backburner.meditations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import io.onedonut.backburner.R

class MeditationsAdapter : ListAdapter<UI.Item, MeditationItemViewHolder>(
    DiffCallback
) {

    override fun onBindViewHolder(holder: MeditationItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeditationItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.meditation_item, parent, false)
        return MeditationItemViewHolder(view)
    }

    companion object {
        val DiffCallback = object : DiffUtil.ItemCallback<UI.Item>() {
            override fun areItemsTheSame(oldItem: UI.Item, newItem: UI.Item): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: UI.Item, newItem: UI.Item): Boolean {
                return oldItem == newItem
            }

        }
    }
}