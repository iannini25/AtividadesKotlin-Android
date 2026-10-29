package com.bernardo.listatarefas.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.bernardo.listatarefas.model.Tarefa
import com.bernardo.listatarefas.repository.TarefaRepository
import kotlinx.coroutines.launch

class TarefaViewModel(application: Application) : AndroidViewModel(application) {

    private val repositorio = TarefaRepository(application)

    var tarefas by mutableStateOf(listOf<Tarefa>())
        private set

    init {
        carregar()
    }

    fun carregar() {
        viewModelScope.launch {
            tarefas = repositorio.listar()
        }
    }

    fun adicionar(titulo: String, descricao: String) {
        viewModelScope.launch {
            repositorio.inserir(Tarefa(titulo = titulo, descricao = descricao))
            tarefas = repositorio.listar()
        }
    }
}
