package com.bernardo.listatarefas.network

import com.bernardo.listatarefas.model.Todo
import retrofit2.http.GET

interface TodoApi {
    @GET("todos")
    suspend fun buscarTodos(): List<Todo>
}
