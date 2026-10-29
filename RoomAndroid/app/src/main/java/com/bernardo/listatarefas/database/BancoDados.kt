package com.bernardo.listatarefas.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bernardo.listatarefas.model.Tarefa

@Database(entities = [Tarefa::class], version = 1)
abstract class BancoDados : RoomDatabase() {

    abstract fun tarefaDao(): TarefaDao

    companion object {
        private var instancia: BancoDados? = null

        fun pegarBanco(context: Context): BancoDados {
            if (instancia == null) {
                instancia = Room.databaseBuilder(
                    context.applicationContext,
                    BancoDados::class.java,
                    "tarefas_room.db"
                ).build()
            }
            return instancia!!
        }
    }
}
