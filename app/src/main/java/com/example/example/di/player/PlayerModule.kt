package com.example.example.di.player

import com.example.example.data.player.PlayerInfoRepositoryImpl
import com.example.example.data.player.info.cloud.PlayerInfoCloudMapper
import com.example.example.data.player.matches.cloud.PlayerMatchesCloudMapper
import com.example.example.domain.player.PlayerInfoCloudUseCase
import com.example.example.domain.player.PlayerMatchesCloudUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*

@Module
@InstallIn(SingletonComponent::class)
class PlayerModule {

    @Provides
    fun providePlayerInfoRepositoryImpl(
        client: HttpClient,
        mapperInfo: PlayerInfoCloudMapper,
        mapperMatches: PlayerMatchesCloudMapper
    ) =
        PlayerInfoRepositoryImpl(client, mapperInfo, mapperMatches)

    @Provides
    fun provideMapperInfo() = PlayerInfoCloudMapper()

    @Provides
    fun provideMapperMatches() = PlayerMatchesCloudMapper()

    @Provides
    fun providePlayerInfoCloudUseCase(repository: PlayerInfoRepositoryImpl) = PlayerInfoCloudUseCase(repository)

    @Provides
    fun providePlayerMatchesCloudUseCase(repository: PlayerInfoRepositoryImpl) = PlayerMatchesCloudUseCase(repository)
}