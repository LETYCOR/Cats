package com.example.catsMVIFlow.data.network

import com.example.catsMVIFlow.domain.models.Fact
//import com.example.catsMVIFlow.domain.models.Fact
import retrofit2.Response
import retrofit2.http.GET

interface CatFactsService {
    @GET("/facts/random")
    suspend fun getCatRandomFact(): Response<Fact>
}

