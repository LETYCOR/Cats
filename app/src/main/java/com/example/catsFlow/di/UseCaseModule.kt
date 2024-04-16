package com.example.catsFlow.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import com.example.catsFlow.domain.repositories.CatFactRepository
import com.example.catsFlow.domain.usecases.GetCatRandomFactUseCase
import com.example.catsFlow.domain.usecases.GetCatRandomFactUseCaseImpl


@Module
@InstallIn(ActivityRetainedComponent::class)
class UseCaseModule {

    @Provides
    fun provideGetCatRandomFact(
        catFactRepository: CatFactRepository
    ): GetCatRandomFactUseCase = GetCatRandomFactUseCaseImpl(catFactRepository)
}