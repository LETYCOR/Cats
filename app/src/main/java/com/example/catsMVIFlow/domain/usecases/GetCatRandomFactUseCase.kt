package com.example.catsMVIFlow.domain.usecases

import com.example.catsMVIFlow.domain.models.CatFactStates
import kotlinx.coroutines.flow.Flow

interface GetCatRandomFactUseCase {
    suspend operator fun invoke(): Flow<CatFactStates>
}