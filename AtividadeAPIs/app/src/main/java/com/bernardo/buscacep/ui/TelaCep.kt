package com.bernardo.buscacep.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bernardo.buscacep.viewmodel.CepUiState

@Composable
fun TelaCep(estado: CepUiState, onBuscar: (String) -> Unit) {
    var cepDigitado by rememberSaveable { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
        Text(text = "Busca CEP", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = cepDigitado,
            onValueChange = { cepDigitado = it },
            label = { Text("Digite o CEP") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { onBuscar(cepDigitado) }, modifier = Modifier.fillMaxWidth()) {
            Text("Buscar")
        }
        Spacer(modifier = Modifier.height(24.dp))

        when (estado) {
            is CepUiState.Inicio -> Text("Digite um cep e clique em buscar")
            is CepUiState.Carregando -> CircularProgressIndicator()
            is CepUiState.Erro -> Text(estado.mensagem)
            is CepUiState.Sucesso -> {
                Text("CEP: " + estado.endereco.cep)
                Text("Rua: " + estado.endereco.rua)
                Text("Complemento: " + estado.endereco.complemento)
                Text("Bairro: " + estado.endereco.bairro)
                Text("Cidade: " + estado.endereco.cidade + " - " + estado.endereco.uf)
                Text("DDD: " + estado.endereco.ddd)
            }
        }
    }
}
