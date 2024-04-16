package com.example.catsFlow.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.catsFlow.domain.repositories.CatFactRepository
import com.example.catsFlow.data.repositories.CatFactRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCatFactRepository(
        catFactRepositoryImpl: CatFactRepositoryImpl
    ): CatFactRepository
}