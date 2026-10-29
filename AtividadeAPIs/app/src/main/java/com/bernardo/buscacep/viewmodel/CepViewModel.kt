package com.bernardo.buscacep.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bernardo.buscacep.network.RetrofitCliente
import kotlinx.coroutines.launch

class CepViewModel : ViewModel() {

    var estado: CepUiState by mutableStateOf(CepUiState.Inicio)
        private set

    fun buscar(cep: String) {
        viewModelScope.launch {
            estado = CepUiState.Carregando
            try {
                val endereco = RetrofitCliente.api.buscarCep(cep)
                if (endereco.erro != null) {
                    estado = CepUiState.Erro("CEP nao encontrado")
                } else {
                    estado = CepUiState.Sucesso(endereco)
                }
            } catch (e: Exception) {
                estado = CepUiState.Erro("Erro ao buscar o CEP, confere o numero ou a internet")
            }
        }
    }
}
