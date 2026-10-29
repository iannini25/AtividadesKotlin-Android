package com.bernardo.diariotreinos.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bernardo.diariotreinos.viewmodel.TreinoViewModel

@Composable
fun TelaInicio(vm: TreinoViewModel) {
    var nome by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Ola " + vm.nomeUsuario, fontSize = 24.sp)
        Text("Voce tem " + vm.treinos.size + " treinos")
        Spacer(modifier = Modifier.height(24.dp))

        Text("Novo treino", fontSize = 18.sp)
        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = descricao,
            onValueChange = { descricao = it },
            label = { Text("Descricao") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                vm.adicionar(nome, descricao)
                nome = ""
                descricao = ""
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Adicionar")
        }
    }
}
