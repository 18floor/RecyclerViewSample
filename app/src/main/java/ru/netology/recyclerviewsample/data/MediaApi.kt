package ru.netology.recyclerviewsample.data

import retrofit2.http.GET

interface MediaApi {

    @GET("data/album.json")
    suspend fun getMedia(): MediaDto
}