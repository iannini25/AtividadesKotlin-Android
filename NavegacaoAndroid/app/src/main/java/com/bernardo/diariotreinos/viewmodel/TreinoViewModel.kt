package com.bernardo.diariotreinos.viewmodel

import android.app.Application
import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.bernardo.diariotreinos.model.Treino

class TreinoViewModel(application: Application) : AndroidViewModel(application) {

    private val prefs = application.getSharedPreferences("dados", Context.MODE_PRIVATE)

    var logado by mutableStateOf(prefs.getBoolean("logado", false))
        private set

    var nomeUsuario by mutableStateOf(prefs.getString("usuario", "") ?: "")
        private set

    val treinos = mutableStateListOf<Treino>()

    private var proximoId = 1

    init {
        // uns treinos pra lista nao comecar vazia
        val nomes = listOf(
            "Peito", "Costas", "Perna", "Ombro", "Biceps", "Triceps", "Abdomen",
            "Corrida", "Bicicleta", "Natacao", "Alongamento", "Funcional",
            "Gluteo", "Panturrilha", "Cardio"
        )
        for (nome in nomes) {
            adicionar(nome, "Treino de " + nome + ", 3 series de 12")
        }
    }

    fun entrar(usuario: String) {
        logado = true
        nomeUsuario = usuario
        prefs.edit().putBoolean("logado", true).putString("usuario", usuario).apply()
    }

    fun sair() {
        logado = false
        nomeUsuario = ""
        prefs.edit().putBoolean("logado", false).putString("usuario", "").apply()
    }

    fun adicionar(nome: String, descricao: String) {
        treinos.add(Treino(proximoId, nome, descricao))
        proximoId++
    }

    fun apagarTodos() {
        treinos.clear()
    }

    fun pegarTreino(id: Int): Treino? {
        return treinos.find { it.id == id }
    }
}
