package com.bernardo.buscacep.model

import com.google.gson.annotations.SerializedName

// resposta do viacep
data class Endereco(
    val cep: String?,
    @SerializedName("logradouro")
    val rua: String?,
    val complemento: String?,
    val bairro: String?,
    @SerializedName("localidade")
    val cidade: String?,
    val uf: String?,
    val ddd: String?,
    // quando o cep nao existe a api manda "erro": "true"
    val erro: String?
)
