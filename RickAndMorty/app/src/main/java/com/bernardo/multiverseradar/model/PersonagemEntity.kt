package com.bernardo.multiverseradar.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "personagens")
data class PersonagemEntity(
    @PrimaryKey
    val id: Int,
    val nome: String,
    val especie: String,
    val imagemUrl: String
)
