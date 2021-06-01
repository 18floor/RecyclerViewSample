package ru.netology.recyclerviewsample.data

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import ru.netology.recyclerviewsample.domain.BASE_URL
import ru.netology.recyclerviewsample.domain.MediaRepository
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface DataModule {

    companion object {
        @Singleton
        @Provides
        fun provideOkhttp(): OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

        @Singleton
        @Provides
        fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        @Singleton
        @Provides
        fun provideApi(retrofit: Retrofit): MediaApi = retrofit.create()
    }

    @Binds
    fun bindsMediaRepository(impl: MediaRepositoryImpl): MediaRepository

}