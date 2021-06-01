package ru.netology.recyclerviewsample.presentation.recycler

import androidx.recyclerview.widget.DiffUtil
import ru.netology.recyclerviewsample.presentation.MediaHeaderItem
import ru.netology.recyclerviewsample.presentation.MediaItem
import ru.netology.recyclerviewsample.presentation.MediaTrackItem

class MediaDiffUtil: DiffUtil.ItemCallback<MediaItem>() {
    override fun areItemsTheSame(oldItem: MediaItem, newItem: MediaItem): Boolean =
        when {
            oldItem is MediaHeaderItem && newItem is MediaHeaderItem -> true
            oldItem is MediaTrackItem && newItem is MediaTrackItem -> oldItem.file == oldItem.file
            else -> false
        }

    override fun areContentsTheSame(oldItem: MediaItem, newItem: MediaItem): Boolean =
        areItemsTheSame(oldItem, newItem)
}