package com.example.example.di.matches

import com.example.example.core.ApiService
import com.example.example.data.matches.MatchesRepository
import com.example.example.data.matches.cloud.MatchesCloudMapper
import com.example.example.domain.MatchesCloudUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MatchesModule {

    @Provides
    fun provideMatchesRepository(client: HttpClient, mapper: MatchesCloudMapper) = MatchesRepository(client, mapper)

    @Provides
    @Singleton
    fun provideMapper() = MatchesCloudMapper()

    @Provides
    fun provideMatchesCloudUseCase(repository: MatchesRepository) = MatchesCloudUseCase(repository)
}