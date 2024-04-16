package com.example.catsLiveData.data.network

import com.example.catsLiveData.domain.models.Fact
import retrofit2.Response
import retrofit2.http.GET

interface CatFactsService {
    @GET("/facts/random")
    suspend fun getCatRandomFact(): Response<Fact>
}
