package com.bernardo.multiverseradar.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bernardo.multiverseradar.model.PersonagemEntity

@Database(entities = [PersonagemEntity::class], version = 1)
abstract class BancoDados : RoomDatabase() {

    abstract fun personagemDao(): PersonagemDao

    companion object {
        private var instancia: BancoDados? = null

        fun pegarBanco(context: Context): BancoDados {
            if (instancia == null) {
                instancia = Room.databaseBuilder(
                    context.applicationContext,
                    BancoDados::class.java,
                    "multiverso.db"
                ).build()
            }
            return instancia!!
        }
    }
}
