package ru.netology.recyclerviewsample.presentation

data class MediaState(
    val items: List<MediaItem> = emptyList(),
    val status: Status = Status.Empty
) {
    sealed interface Status {
        object Empty: Status
        object Progress: Status
        object Success: Status
        object Error: Status
    }
}

val MediaState.progress: Boolean
    get() = status == MediaState.Status.Progress