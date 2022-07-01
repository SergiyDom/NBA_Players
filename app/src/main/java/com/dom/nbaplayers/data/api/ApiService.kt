package com.dom.nbaplayers.data.api

import com.dom.nbaplayers.model.allPlayers.AllPlayers
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("api/v1/players")
    suspend fun getPlayer(@Query("page") page: Int = 1): Response<AllPlayers>
}