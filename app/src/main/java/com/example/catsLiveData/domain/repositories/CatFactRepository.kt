package com.example.catsLiveData.domain.repositories

import com.example.catsLiveData.domain.models.CatFactStates

interface CatFactRepository {
    suspend fun getCatRandomFact(): CatFactStates
}