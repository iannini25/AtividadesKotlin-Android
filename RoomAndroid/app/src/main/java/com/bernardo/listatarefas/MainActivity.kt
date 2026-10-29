package com.bernardo.listatarefas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bernardo.listatarefas.ui.TelaTarefas
import com.bernardo.listatarefas.viewmodel.TarefaViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    val vm: TarefaViewModel = viewModel()
                    val tarefas by vm.tarefas.collectAsState()
                    val estado by vm.estado.collectAsState()
                    TelaTarefas(
                        tarefas = tarefas,
                        estado = estado,
                        onSalvar = { titulo, descricao -> vm.adicionar(titulo, descricao) },
                        onSincronizar = { vm.sincronizar() }
                    )
                }
            }
        }
    }
}
