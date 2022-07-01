package com.dom.nbaplayers.data.repository

import com.dom.nbaplayers.data.api.RetrofitInstance
import com.dom.nbaplayers.model.allPlayers.AllPlayers
import retrofit2.Response

class Repository {
    suspend fun getAllPlayers(): Response<AllPlayers> {
        return RetrofitInstance.api.getPlayer()
    }
}