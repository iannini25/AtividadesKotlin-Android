package com.bernardo.listatarefas.repository

import android.content.ContentValues
import android.content.Context
import com.bernardo.listatarefas.database.BancoHelper
import com.bernardo.listatarefas.model.Tarefa
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TarefaRepository(context: Context) {

    private val banco = BancoHelper(context)

    suspend fun inserir(tarefa: Tarefa) {
        withContext(Dispatchers.IO) {
            val db = banco.writableDatabase
            val valores = ContentValues()
            valores.put("titulo", tarefa.titulo)
            valores.put("descricao", tarefa.descricao)
            db.insert("tarefas", null, valores)
        }
    }

    suspend fun listar(): List<Tarefa> {
        return withContext(Dispatchers.IO) {
            val lista = mutableListOf<Tarefa>()
            val db = banco.readableDatabase
            val cursor = db.query("tarefas", null, null, null, null, null, "id DESC")
            while (cursor.moveToNext()) {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                val titulo = cursor.getString(cursor.getColumnIndexOrThrow("titulo"))
                val descricao = cursor.getString(cursor.getColumnIndexOrThrow("descricao"))
                lista.add(Tarefa(id, titulo, descricao))
            }
            cursor.close()
            lista
        }
    }
}
