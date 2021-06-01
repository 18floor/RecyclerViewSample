package ru.netology.recyclerviewsample.data

import com.google.gson.annotations.SerializedName
import ru.netology.recyclerviewsample.domain.Media

data class MediaDto(
    @SerializedName("artist")
    val artist: String = "",
    @SerializedName("subtitle")
    val subtitle: String = "",
    @SerializedName("genre")
    val genre: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("published")
    val published: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("tracks")
    val tracks: List<TrackDto> = listOf()
)

fun MediaDto.toModel(): Media =
    Media(
        artist = artist,
        subtitle = subtitle,
        genre = genre,
        id = id,
        published = published,
        title = title,
        tracks = tracks.map(TrackDto::toModel)
    )