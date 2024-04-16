package com.example.catsMVIFlow.domain.usecases

import com.example.catsMVIFlow.domain.models.CatFactStates
import com.example.catsMVIFlow.domain.repositories.CatFactRepository
import kotlinx.coroutines.flow.Flow


class GetCatRandomFactUseCaseImpl(
    private val catFactRepository: CatFactRepository
): GetCatRandomFactUseCase {
    override suspend fun invoke(): Flow<CatFactStates> = catFactRepository.getCatRandomFact()
}
