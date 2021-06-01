package ru.netology.recyclerviewsample.presentation.recycler

import androidx.recyclerview.widget.RecyclerView
import ru.netology.recyclerviewsample.databinding.TrackItemBinding
import ru.netology.recyclerviewsample.presentation.MediaTrackItem

class TrackViewHolder(
    private val binding: TrackItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: MediaTrackItem) {
        binding.trackName.text = item.file
    }
}