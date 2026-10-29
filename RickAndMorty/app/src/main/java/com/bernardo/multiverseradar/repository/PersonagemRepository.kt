package com.bernardo.multiverseradar.repository

import android.content.Context
import com.bernardo.multiverseradar.data.BancoDados
import com.bernardo.multiverseradar.model.PersonagemEntity
import com.bernardo.multiverseradar.model.paraEntity
import com.bernardo.multiverseradar.network.RetrofitCliente
import kotlinx.coroutines.flow.Flow

class PersonagemRepository(context: Context) {

    private val dao = BancoDados.pegarBanco(context).personagemDao()

    // a viewmodel so pega os dados daqui, que vem do room
    val personagens: Flow<List<PersonagemEntity>> = dao.pegarTodos()

    // busca na api e salva direto no room
    suspend fun syncCharacters() {
        val resposta = RetrofitCliente.api.buscarPersonagens()
        val lista = resposta.resultados.map { it.paraEntity() }
        dao.salvarTodos(lista)
    }
}
