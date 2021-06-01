package ru.netology.recyclerviewsample.presentation.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.netology.recyclerviewsample.R
import ru.netology.recyclerviewsample.databinding.HeaderItemBinding
import ru.netology.recyclerviewsample.databinding.TrackItemBinding
import ru.netology.recyclerviewsample.presentation.MediaHeaderItem
import ru.netology.recyclerviewsample.presentation.MediaItem
import ru.netology.recyclerviewsample.presentation.MediaTrackItem

class TrackAdapter : ListAdapter<MediaItem, RecyclerView.ViewHolder>(
    MediaDiffUtil()
) {

    override fun getItemViewType(position: Int): Int =
        when (getItem(position)) {
            is MediaHeaderItem -> R.layout.header_item
            is MediaTrackItem -> R.layout.track_item
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            R.layout.header_item -> HeaderViewHolder(
                HeaderItemBinding.inflate(
                    parent.requireInflater(),
                    parent,
                    false
                )
            )
            R.layout.track_item -> TrackViewHolder(
                TrackItemBinding.inflate(
                    parent.requireInflater(),
                    parent,
                    false
                )
            )
            else -> error("Unknown view type $viewType")
        }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TrackViewHolder -> holder.bind(getItem(position) as MediaTrackItem)
            is HeaderViewHolder -> holder.bind(getItem(position) as MediaHeaderItem)
        }
    }
}

fun View.requireInflater(): LayoutInflater = LayoutInflater.from(context)