package com.bernardo.buscacep.network

import com.bernardo.buscacep.model.Endereco
import retrofit2.http.GET
import retrofit2.http.Path

interface ViaCepApi {
    @GET("ws/{cep}/json/")
    suspend fun buscarCep(@Path("cep") cep: String): Endereco
}
