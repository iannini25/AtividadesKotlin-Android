package com.bernardo.listatarefas.repository

import android.content.Context
import com.bernardo.listatarefas.database.BancoDados
import com.bernardo.listatarefas.model.Tarefa
import com.bernardo.listatarefas.network.RetrofitCliente
import kotlinx.coroutines.flow.Flow

class TarefaRepository(context: Context) {

    private val dao = BancoDados.pegarBanco(context).tarefaDao()

    // a tela so observa isso aqui (o banco)
    val tarefas: Flow<List<Tarefa>> = dao.listar()

    suspend fun inserir(tarefa: Tarefa) {
        dao.inserir(tarefa)
    }

    // busca na api e grava no room
    suspend fun sincronizar() {
        val todos = RetrofitCliente.api.buscarTodos()
        val lista = todos.map { todo ->
            var situacao = "pendente"
            if (todo.feita) {
                situacao = "feita"
            }
            // soma 1000000 no id pra nao bater com as tarefas cadastradas na mao
            Tarefa(id = todo.id + 1000000, titulo = todo.titulo, descricao = situacao)
        }
        dao.inserirVarias(lista)
    }
}
