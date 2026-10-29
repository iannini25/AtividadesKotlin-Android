package com.bernardo.listatarefas.model

import com.google.gson.annotations.SerializedName

// o que vem da api jsonplaceholder /todos
data class Todo(
    val id: Int,
    @SerializedName("title")
    val titulo: String,
    @SerializedName("completed")
    val feita: Boolean
)
