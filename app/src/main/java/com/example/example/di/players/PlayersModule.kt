package com.example.example.di.players

import com.example.example.data.players.PlayersRepositoryImpl
import com.example.example.data.players.cloud.PlayersCloudMapper
import com.example.example.domain.players.PlayersCloudUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*

@Module
@InstallIn(SingletonComponent::class)
class PlayersModule {

    @Provides
    fun providePlayersRepositoryImpl(client: HttpClient, mapper: PlayersCloudMapper) = PlayersRepositoryImpl(client, mapper)

    @Provides
    fun provideMapper() = PlayersCloudMapper()

    @Provides
    fun providePlayersCloudUseCase(repository: PlayersRepositoryImpl) = PlayersCloudUseCase(repository)
}