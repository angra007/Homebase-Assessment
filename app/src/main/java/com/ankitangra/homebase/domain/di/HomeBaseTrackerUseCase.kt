package com.ankitangra.homebase.domain.di

import com.ankitangra.homebase.domain.repository.HomebaseRepository
import com.ankitangra.homebase.domain.usecase.CreateShift
import com.ankitangra.homebase.domain.usecase.GetShift
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object HomeBaseTrackerUseCase {

    @Provides
    @ViewModelScoped
    fun provideGetShiftUseCase(
        repository: HomebaseRepository
    ): GetShift {
        return GetShift(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideCreateShiftUseCase(
        repository: HomebaseRepository
    ): CreateShift {
        return CreateShift(repository)
    }
}