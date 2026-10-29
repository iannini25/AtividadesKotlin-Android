package com.bernardo.diariotreinos.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bernardo.diariotreinos.viewmodel.TreinoViewModel

@Composable
fun TelaPerfil(vm: TreinoViewModel, onSair: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Perfil", fontSize = 24.sp)
        Text("Usuario: " + vm.nomeUsuario)
        Spacer(modifier = Modifier.height(24.dp))

        OutlinedButton(onClick = { vm.apagarTodos() }, modifier = Modifier.fillMaxWidth()) {
            Text("Apagar todos os treinos")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                vm.sair()
                onSair()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sair")
        }
    }
}
