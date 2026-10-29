package com.bernardo.listatarefas.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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
import com.bernardo.listatarefas.model.Tarefa

@Composable
fun TelaTarefas(tarefas: List<Tarefa>, onSalvar: (String, String) -> Unit) {
    var titulo by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Minhas Tarefas", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = titulo,
            onValueChange = { titulo = it },
            label = { Text("Titulo") },
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
                onSalvar(titulo, descricao)
                titulo = ""
                descricao = ""
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Salvar")
        }
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(tarefas) { tarefa ->
                Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(text = tarefa.titulo, fontSize = 18.sp)
                        Text(text = tarefa.descricao)
                    }
                }
            }
        }
    }
}
