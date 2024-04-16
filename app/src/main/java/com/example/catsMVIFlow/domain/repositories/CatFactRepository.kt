package com.example.catsMVIFlow.domain.repositories

import com.example.catsMVIFlow.domain.models.CatFactStates
import kotlinx.coroutines.flow.Flow

/*interface CatFactRepository {
    suspend fun getCatRandomFact(): Flow<CatFactStates>
}*/

interface CatFactRepository {
    suspend fun getCatRandomFact(): Flow<CatFactStates>
}

