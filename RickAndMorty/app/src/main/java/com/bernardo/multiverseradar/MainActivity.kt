package com.bernardo.multiverseradar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bernardo.multiverseradar.ui.TelaPersonagens
import com.bernardo.multiverseradar.viewmodel.PersonagemViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val vm: PersonagemViewModel = viewModel()
                val personagens by vm.personagens.collectAsState()
                val estado by vm.estado.collectAsState()
                TelaPersonagens(
                    personagens = personagens,
                    estado = estado,
                    onSincronizar = { vm.sincronizar() }
                )
            }
        }
    }
}
