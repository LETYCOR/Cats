package com.example.catsFlow.domain.repositories

import com.example.catsFlow.domain.models.CatFactStates
import kotlinx.coroutines.flow.Flow

interface CatFactRepository {
    suspend fun getCatRandomFact(): Flow<CatFactStates>
}