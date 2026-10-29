package com.bernardo.multiverseradar.viewmodel

sealed interface EstadoSync {
    object Idle : EstadoSync
    object Loading : EstadoSync
    object Success : EstadoSync
    data class Error(val mensagem: String) : EstadoSync
}
