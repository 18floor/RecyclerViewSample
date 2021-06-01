package ru.netology.recyclerviewsample.data

import ru.netology.recyclerviewsample.domain.Media
import ru.netology.recyclerviewsample.domain.MediaRepository
import javax.inject.Inject

class MediaRepositoryImpl @Inject constructor(
    private val api: MediaApi
) : MediaRepository {

    override suspend fun getMedia(): Media =
        api.getMedia().toModel()

}