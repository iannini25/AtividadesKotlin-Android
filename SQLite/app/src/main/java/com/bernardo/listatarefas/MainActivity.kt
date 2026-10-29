package com.bernardo.listatarefas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
                    TelaTarefas(
                        tarefas = vm.tarefas,
                        onSalvar = { titulo, descricao -> vm.adicionar(titulo, descricao) }
                    )
                }
            }
        }
    }
}
