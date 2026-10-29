package com.bernardo.buscacep.viewmodel

import com.bernardo.buscacep.model.Endereco

sealed interface CepUiState {
    object Inicio : CepUiState
    object Carregando : CepUiState
    data class Sucesso(val endereco: Endereco) : CepUiState
    data class Erro(val mensagem: String) : CepUiState
}
