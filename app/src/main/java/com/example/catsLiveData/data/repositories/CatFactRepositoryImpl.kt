package com.example.catsLiveData.data.repositories

import com.example.catsLiveData.domain.repositories.CatFactRepository
import com.example.catsLiveData.domain.models.CatFactStates
import com.example.catsLiveData.data.network.CatFactsService
import java.io.IOException
import javax.inject.Inject

class CatFactRepositoryImpl @Inject constructor (
    private val catFactsService: CatFactsService
): CatFactRepository {
    override suspend fun getCatRandomFact(): CatFactStates {
        return try {
            val response = catFactsService.getCatRandomFact()
            val fact = response.body()
            return if (fact != null) CatFactStates.CatFactData(fact)
            else CatFactStates.Error(IOException("Data is null"))
        } catch (exception: Exception) {
            CatFactStates.Error(exception)
        }
    }
}
