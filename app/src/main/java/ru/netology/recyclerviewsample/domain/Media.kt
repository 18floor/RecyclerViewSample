package ru.netology.recyclerviewsample.domain

data class Media(
    val artist: String = "",
    val subtitle: String = "",
    val genre: String = "",
    val id: Int = 0,
    val published: String = "",
    val title: String = "",
    val tracks: List<Track> = listOf()
)