package ru.netology.recyclerviewsample.data

import com.google.gson.annotations.SerializedName
import ru.netology.recyclerviewsample.domain.Track

data class TrackDto(
    @SerializedName("file")
    val file: String = "",
    @SerializedName("id")
    val id: Int = 0
)

fun TrackDto.toModel(): Track =
    Track(file, id)