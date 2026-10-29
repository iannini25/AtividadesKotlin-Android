package com.bernardo.buscacep

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bernardo.buscacep.ui.TelaCep
import com.bernardo.buscacep.viewmodel.CepViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    val vm: CepViewModel = viewModel()
                    TelaCep(estado = vm.estado, onBuscar = { cep -> vm.buscar(cep) })
                }
            }
        }
    }
}
