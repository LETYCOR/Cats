package com.example.catsMVIFlow.data.repositories

import com.example.catsMVIFlow.domain.repositories.CatFactRepository
import com.example.catsMVIFlow.domain.models.CatFactStates
import com.example.catsMVIFlow.data.network.CatFactsService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class CatFactRepositoryImpl @Inject constructor(
    private val catFactsService: CatFactsService
) : CatFactRepository {

    override suspend fun getCatRandomFact(): Flow<CatFactStates> {
        return try {
            val response = catFactsService.getCatRandomFact()
            val fact = response.body()
            if (fact != null) {
                flow { emit(CatFactStates.CatFactData(fact)) }
            } else {
                flow { emit(CatFactStates.Error(IOException("Data is null"))) }
            }
        } catch (exception: Exception) {
            flow { emit(CatFactStates.Error(exception)) }
        }
    }
}

