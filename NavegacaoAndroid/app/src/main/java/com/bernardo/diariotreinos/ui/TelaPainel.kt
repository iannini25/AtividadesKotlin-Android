package com.bernardo.diariotreinos.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.bernardo.diariotreinos.navegacao.Rota
import com.bernardo.diariotreinos.viewmodel.TreinoViewModel

data class Aba(val nome: String, val rota: Rota, val icone: ImageVector)

@Composable
fun TelaPainel(vm: TreinoViewModel, onSair: () -> Unit) {
    val navAbas = rememberNavController()

    val abas = listOf(
        Aba("Inicio", Rota.Inicio, Icons.Filled.Home),
        Aba("Treinos", Rota.Treinos, Icons.AutoMirrored.Filled.List),
        Aba("Perfil", Rota.Perfil, Icons.Filled.Person)
    )

    val entradaAtual by navAbas.currentBackStackEntryAsState()
    val destinoAtual = entradaAtual?.destination

    Scaffold(
        bottomBar = {
            NavigationBar {
                for (aba in abas) {
                    val selecionada = destinoAtual?.hierarchy?.any { it.hasRoute(aba.rota::class) } == true
                    NavigationBarItem(
                        selected = selecionada,
                        onClick = {
                            navAbas.navigate(aba.rota) {
                                popUpTo(navAbas.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(aba.icone, contentDescription = "Ir para " + aba.nome) },
                        label = { Text(aba.nome) }
                    )
                }
            }
        }
    ) { padding ->
        NavHost(
            navController = navAbas,
            startDestination = Rota.Inicio,
            modifier = Modifier.padding(padding)
        ) {
            composable<Rota.Inicio> {
                TelaInicio(vm)
            }
            composable<Rota.Treinos> {
                TelaTreinos(vm, onClicarTreino = { id -> navAbas.navigate(Rota.Detalhe(id)) })
            }
            composable<Rota.Perfil> {
                TelaPerfil(vm, onSair = onSair)
            }
            composable<Rota.Detalhe> { entrada ->
                val rota = entrada.toRoute<Rota.Detalhe>()
                TelaDetalhe(vm, rota.id, onVoltar = { navAbas.popBackStack() })
            }
        }
    }
}
