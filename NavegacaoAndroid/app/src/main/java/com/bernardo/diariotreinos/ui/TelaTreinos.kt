package com.bernardo.diariotreinos.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bernardo.diariotreinos.viewmodel.TreinoViewModel

@Composable
fun TelaTreinos(vm: TreinoViewModel, onClicarTreino: (Int) -> Unit) {
    if (vm.treinos.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Nenhum treino cadastrado ainda")
        }
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(vm.treinos) { treino ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable { onClicarTreino(treino.id) }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(treino.nome, fontSize = 20.sp)
                        Text("id: " + treino.id)
                    }
                }
            }
        }
    }
}
