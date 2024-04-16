package com.example.catsFlow.domain.usecases

import com.example.catsFlow.domain.models.CatFactStates
import kotlinx.coroutines.flow.Flow

interface GetCatRandomFactUseCase {
    suspend operator fun invoke(): Flow<CatFactStates>
}