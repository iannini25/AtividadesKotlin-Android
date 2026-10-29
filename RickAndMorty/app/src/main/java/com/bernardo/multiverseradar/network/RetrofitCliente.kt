package com.bernardo.multiverseradar.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitCliente {
    private const val URL_BASE = "https://rickandmortyapi.com/"

    val api: RickApi by lazy {
        Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickApi::class.java)
    }
}
