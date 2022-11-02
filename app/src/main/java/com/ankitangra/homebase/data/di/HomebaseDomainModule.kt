package com.ankitangra.homebase.data.di

import com.ankitangra.homebase.data.network.mock.MockHomeServer
import com.ankitangra.homebase.data.repository.HomeBaseRepositoryImpl
import com.ankitangra.homebase.domain.repository.HomebaseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomebaseDomainModule {

    @Provides
    @Singleton
    fun provideMockHomeServer(): MockHomeServer {
        return MockHomeServer()
    }

    @Provides
    @Singleton
    fun provideHomeBaseRepository(
        server: MockHomeServer
    ): HomebaseRepository {
        return HomeBaseRepositoryImpl(server)
    }
}