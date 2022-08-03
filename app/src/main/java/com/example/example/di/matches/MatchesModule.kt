package com.example.example.di.matches

import com.example.example.data.matches.MatchesRepositoryImpl
import com.example.example.data.matches.cloud.MatchesCloudMapper
import com.example.example.domain.matches.MatchesCloudUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*

@Module
@InstallIn(SingletonComponent::class)
class MatchesModule {

    @Provides
    fun provideMatchesRepository(client: HttpClient, mapper: MatchesCloudMapper) = MatchesRepositoryImpl(client, mapper)

    @Provides
    fun provideMapper() = MatchesCloudMapper()

    @Provides
    fun provideMatchesCloudUseCase(repository: MatchesRepositoryImpl) = MatchesCloudUseCase(repository)
}