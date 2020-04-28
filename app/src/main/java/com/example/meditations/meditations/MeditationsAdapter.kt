package com.example.meditations.meditations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.meditations.R

class MeditationsAdapter : RecyclerView.Adapter<MeditationItemViewHolder>() {

    var meditationItems: List<UI.Item> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int {
        return meditationItems.size
    }

    override fun onBindViewHolder(holder: MeditationItemViewHolder, position: Int) {
        holder.meditationText.text = meditationItems[position].quote
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeditationItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.meditation_item, parent, false)
        return MeditationItemViewHolder(view)
    }

}