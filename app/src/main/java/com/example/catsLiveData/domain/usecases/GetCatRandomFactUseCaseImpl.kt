package com.example.catsLiveData.domain.usecases

import com.example.catsLiveData.domain.models.CatFactStates
import com.example.catsLiveData.domain.repositories.CatFactRepository


class GetCatRandomFactUseCaseImpl(
    private val catFactRepository: CatFactRepository
): GetCatRandomFactUseCase {
    override suspend fun invoke(): CatFactStates = catFactRepository.getCatRandomFact()
}
