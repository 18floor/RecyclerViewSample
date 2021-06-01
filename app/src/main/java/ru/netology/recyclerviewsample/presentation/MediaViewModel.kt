package ru.netology.recyclerviewsample.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.netology.recyclerviewsample.domain.MediaRepository
import java.io.IOException
import javax.inject.Inject
import ru.netology.recyclerviewsample.presentation.MediaHeaderItem as MediaHeaderItem1

@HiltViewModel
class MediaViewModel @Inject constructor(
    private val repository: MediaRepository
): ViewModel() {

    private val _state = MutableLiveData<MediaState>()
    val state: LiveData<MediaState>
        get() = _state


    init {
        load()
    }

    private fun load() {
        viewModelScope.launch {
            try {
                val media = repository.getMedia()
                val header = MediaHeaderItem1(
                    artist = media.artist,
                    subtitle = media.subtitle,
                    genre = media.genre,
                    published = media.published,
                    title = media.title,
                )
                val mediaTracks = media.tracks.map {
                    MediaTrackItem(it.file)
                }
                _state.value = MediaState(
                    items = listOf(header) + mediaTracks,
                    status = MediaState.Status.Success
                )

            } catch (e: IOException) {
                _state.value = MediaState(status = MediaState.Status.Error)
            }
        }
    }
}