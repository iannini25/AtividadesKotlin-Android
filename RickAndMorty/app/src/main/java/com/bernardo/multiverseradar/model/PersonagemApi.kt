package com.bernardo.multiverseradar.model

import com.google.gson.annotations.SerializedName

// resposta da api: GET /api/character
data class RespostaApi(
    @SerializedName("results")
    val resultados: List<PersonagemApi>
)

data class PersonagemApi(
    val id: Int,
    @SerializedName("name")
    val nome: String,
    @SerializedName("species")
    val especie: String,
    val status: String,
    @SerializedName("image")
    val imagem: String
)

// converte o personagem da api pro personagem do banco
fun PersonagemApi.paraEntity(): PersonagemEntity {
    return PersonagemEntity(
        id = id,
        nome = nome,
        especie = especie,
        imagemUrl = imagem
    )
}
