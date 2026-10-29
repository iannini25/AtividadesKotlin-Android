package com.bernardo.multiverseradar.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.bernardo.multiverseradar.model.PersonagemEntity
import com.bernardo.multiverseradar.repository.PersonagemRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class PersonagemViewModel(application: Application) : AndroidViewModel(application) {

    private val repositorio = PersonagemRepository(application)

    val personagens: StateFlow<List<PersonagemEntity>> = repositorio.personagens
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    private val _estado = MutableStateFlow<EstadoSync>(EstadoSync.Idle)
    val estado: StateFlow<EstadoSync> = _estado

    fun sincronizar() {
        viewModelScope.launch {
            _estado.value = EstadoSync.Loading
            try {
                repositorio.syncCharacters()
                _estado.value = EstadoSync.Success
            } catch (e: Exception) {
                _estado.value = EstadoSync.Error("Sem conexao! nao deu pra sincronizar")
            }
        }
    }
}
