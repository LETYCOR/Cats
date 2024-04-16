package com.example.catsLiveData.domain.usecases

import com.example.catsLiveData.domain.models.CatFactStates

interface GetCatRandomFactUseCase {
    suspend operator fun invoke(): CatFactStates
}
