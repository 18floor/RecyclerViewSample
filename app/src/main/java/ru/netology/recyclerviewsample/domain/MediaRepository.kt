package ru.netology.recyclerviewsample.domain

interface MediaRepository {

    suspend fun getMedia(): Media
}