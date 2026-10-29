package com.bernardo.multiverseradar.network

import com.bernardo.multiverseradar.model.RespostaApi
import retrofit2.http.GET

interface RickApi {
    @GET("api/character")
    suspend fun buscarPersonagens(): RespostaApi
}
