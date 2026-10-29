package com.bernardo.listatarefas.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bernardo.listatarefas.model.Tarefa
import kotlinx.coroutines.flow.Flow

@Dao
interface TarefaDao {

    @Query("SELECT * FROM tarefas ORDER BY id DESC")
    fun listar(): Flow<List<Tarefa>>

    @Insert
    suspend fun inserir(tarefa: Tarefa)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserirVarias(tarefas: List<Tarefa>)
}
