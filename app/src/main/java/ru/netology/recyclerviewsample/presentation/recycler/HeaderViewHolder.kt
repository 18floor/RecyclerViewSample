package ru.netology.recyclerviewsample.presentation.recycler

import androidx.recyclerview.widget.RecyclerView
import ru.netology.recyclerviewsample.databinding.HeaderItemBinding
import ru.netology.recyclerviewsample.presentation.MediaHeaderItem

class HeaderViewHolder(
    private val binding: HeaderItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: MediaHeaderItem) {
        with(binding) {
            titleView.text = item.title
            artistView.text = item.artist
            subtitleView.text = item.subtitle
            publishedView.text = item.published
            genreView.text = item.genre
        }
    }
}