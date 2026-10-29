package com.bernardo.listatarefas.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.bernardo.listatarefas.model.Tarefa
import com.bernardo.listatarefas.repository.TarefaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TarefaViewModel(application: Application) : AndroidViewModel(application) {

    private val repositorio = TarefaRepository(application)

    val tarefas: StateFlow<List<Tarefa>> = repositorio.tarefas
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    private val _estado = MutableStateFlow<EstadoSync>(EstadoSync.Idle)
    val estado: StateFlow<EstadoSync> = _estado

    fun adicionar(titulo: String, descricao: String) {
        viewModelScope.launch {
            repositorio.inserir(Tarefa(titulo = titulo, descricao = descricao))
        }
    }

    fun sincronizar() {
        viewModelScope.launch {
            _estado.value = EstadoSync.Loading
            try {
                repositorio.sincronizar()
                _estado.value = EstadoSync.Idle
            } catch (e: Exception) {
                _estado.value = EstadoSync.Error("Erro ao sincronizar, sem internet?")
            }
        }
    }
}
