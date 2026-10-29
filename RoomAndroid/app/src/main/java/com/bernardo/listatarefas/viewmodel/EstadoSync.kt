package com.bernardo.listatarefas.viewmodel

// so o estado da sincronizacao, a lista fica separada
sealed interface EstadoSync {
    object Idle : EstadoSync
    object Loading : EstadoSync
    data class Error(val mensagem: String) : EstadoSync
}
