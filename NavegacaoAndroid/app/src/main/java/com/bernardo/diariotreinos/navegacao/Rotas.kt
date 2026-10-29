package com.bernardo.diariotreinos.navegacao

import kotlinx.serialization.Serializable

@Serializable
sealed interface Rota {

    @Serializable
    object Splash : Rota

    @Serializable
    object Login : Rota

    @Serializable
    object Painel : Rota

    // abas
    @Serializable
    object Inicio : Rota

    @Serializable
    object Treinos : Rota

    @Serializable
    object Perfil : Rota

    // detalhe recebe o id do treino
    @Serializable
    data class Detalhe(val id: Int) : Rota
}
