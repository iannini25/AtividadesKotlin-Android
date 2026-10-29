package com.bernardo.multiverseradar.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.bernardo.multiverseradar.model.PersonagemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonagemDao {

    @Query("SELECT * FROM personagens")
    fun pegarTodos(): Flow<List<PersonagemEntity>>

    @Upsert
    suspend fun salvarTodos(personagens: List<PersonagemEntity>)
}
