package com.example.catsFlow.domain.usecases

import com.example.catsFlow.domain.models.CatFactStates
import com.example.catsFlow.domain.repositories.CatFactRepository
import kotlinx.coroutines.flow.Flow


class GetCatRandomFactUseCaseImpl(
    private val catFactRepository: CatFactRepository
): GetCatRandomFactUseCase {
    override suspend fun invoke(): Flow<CatFactStates> = catFactRepository.getCatRandomFact()
}