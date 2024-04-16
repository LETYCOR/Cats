package com.example.catsFlow.data.network

import com.example.catsFlow.domain.models.Fact
import retrofit2.Response
import retrofit2.http.GET

interface CatFactsService {
    @GET("/facts/random")
    suspend fun getCatRandomFact(): Response<Fact>
}
