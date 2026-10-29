package com.bernardo.diariotreinos.navegacao

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bernardo.diariotreinos.ui.TelaLogin
import com.bernardo.diariotreinos.ui.TelaPainel
import com.bernardo.diariotreinos.ui.TelaSplash
import com.bernardo.diariotreinos.viewmodel.TreinoViewModel

@Composable
fun AppNavegacao() {
    // o viewmodel e criado so aqui e passado pras telas
    val vm: TreinoViewModel = viewModel()
    val nav = rememberNavController()

    NavHost(navController = nav, startDestination = Rota.Splash) {

        composable<Rota.Splash> {
            TelaSplash(onTerminou = {
                // quem decide pra onde vai e aqui, nao a splash
                if (vm.logado) {
                    nav.navigate(Rota.Painel) {
                        popUpTo(Rota.Splash) { inclusive = true }
                    }
                } else {
                    nav.navigate(Rota.Login) {
                        popUpTo(Rota.Splash) { inclusive = true }
                    }
                }
            })
        }

        composable<Rota.Login> {
            TelaLogin(vm, onEntrou = {
                nav.navigate(Rota.Painel) {
                    popUpTo(Rota.Login) { inclusive = true }
                }
            })
        }

        composable<Rota.Painel> {
            TelaPainel(vm, onSair = {
                nav.navigate(Rota.Login) {
                    popUpTo(Rota.Painel) { inclusive = true }
                }
            })
        }
    }
}
