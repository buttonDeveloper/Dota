package com.example.example.di.player

import com.example.example.data.player.PlayerInfoRepositoryImpl
import com.example.example.data.player.cloud.PlayerInfoCloudMapper
import com.example.example.domain.player.PlayerInfoCloudUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*

@Module
@InstallIn(SingletonComponent::class)
class PlayerModule {

    @Provides
    fun providePlayerInfoRepositoryImpl(client: HttpClient, mapper: PlayerInfoCloudMapper) =
        PlayerInfoRepositoryImpl(client, mapper)

    @Provides
    fun provideMapper() = PlayerInfoCloudMapper()

    @Provides
    fun providePlayerInfoCloudUseCase(repository: PlayerInfoRepositoryImpl) = PlayerInfoCloudUseCase(repository)
}