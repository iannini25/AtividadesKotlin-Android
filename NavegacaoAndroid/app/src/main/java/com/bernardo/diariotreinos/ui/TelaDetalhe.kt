package com.bernardo.diariotreinos.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bernardo.diariotreinos.viewmodel.TreinoViewModel

@Composable
fun TelaDetalhe(vm: TreinoViewModel, id: Int, onVoltar: () -> Unit) {
    val treino = vm.pegarTreino(id)

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        IconButton(onClick = { onVoltar() }) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar para a lista")
        }
        Spacer(modifier = Modifier.height(16.dp))
        if (treino == null) {
            Text("Treino nao encontrado")
        } else {
            Text(treino.nome, fontSize = 26.sp)
            Text("id: " + treino.id)
            Spacer(modifier = Modifier.height(8.dp))
            Text(treino.descricao)
        }
    }
}
