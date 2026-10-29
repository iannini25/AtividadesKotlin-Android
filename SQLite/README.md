# Lista de Tarefas (SQLite nativo)

App android em Kotlin com Jetpack Compose pra cadastrar e listar tarefas.
Os dados ficam salvos no celular usando SQLite nativo (SQLiteOpenHelper, ContentValues e Cursor), sem Room nem outra biblioteca.

## Tema escolhido

Lista de Tarefas

## Telas / funcionalidades

- Tela unica com formulario (titulo e descricao) e botao Salvar
- Lista (LazyColumn) com as tarefas salvas
- Fechando e abrindo o app as tarefas continuam la

## Pacotes

- model: data class Tarefa
- database: BancoHelper (extende SQLiteOpenHelper, cria a tabela no onCreate e tem o onUpgrade)
- repository: TarefaRepository, unica classe que usa ContentValues e Cursor. Tudo roda em Dispatchers.IO dentro de funcoes suspend
- viewmodel: TarefaViewModel
- ui: TelaTarefas em compose

## Como rodar

1. Abrir a pasta SQLite no Android Studio
2. Esperar o gradle sincronizar
3. Rodar no emulador ou no celular
