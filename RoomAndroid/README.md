# Lista de Tarefas (Room + API)

App android em Kotlin com Jetpack Compose pra cadastrar e listar tarefas.
Essa e a continuacao da atividade de SQLite: o SQLiteOpenHelper foi trocado pelo Room e o app agora tambem busca tarefas da internet.

## Tema escolhido

Lista de Tarefas

## Telas / funcionalidades

- Tela unica com formulario (titulo e descricao) e botao Salvar
- Botao Sincronizar com a API
- Lista (LazyColumn) com as tarefas salvas no banco
- Fechando e abrindo o app as tarefas continuam la

## Pacotes

- model: Tarefa (@Entity do room) e Todo (o json da api)
- database: TarefaDao (@Dao) e BancoDados (@Database)
- network: TodoApi (interface do retrofit) e RetrofitCliente
- repository: TarefaRepository
- viewmodel: TarefaViewModel (AndroidViewModel) e EstadoSync
- ui: TelaTarefas em compose

## API usada e sincronizacao com o Room

API: JSONPlaceholder /todos - https://jsonplaceholder.typicode.com/todos (gratis e sem chave)

Como funciona (offline-first):

- A tela nunca le da API. Ela so mostra o que esta no Room.
- O TarefaRepository tem duas coisas:
  - `tarefas`: um Flow que observa a tabela do Room
  - `sincronizar()`: funcao suspend que busca os todos na API e grava no Room (com REPLACE)
- O TarefaViewModel e um AndroidViewModel e transforma o Flow do repository em StateFlow com stateIn
- O estado da sincronizacao fica separado da lista, num sealed interface EstadoSync (Idle, Loading, Error)
- Quando a API vem o titulo vira o titulo da tarefa e o "completed" vira "feita" ou "pendente" na descricao
- O id da api ganha +1000000 pra nao bater com as tarefas que a pessoa cadastra na mao
- Se der erro de internet aparece um aviso, mas a lista que ja estava salva continua na tela
- Sincronizou uma vez e colocou em modo aviao: os dados continuam aparecendo

## Como rodar

1. Abrir a pasta RoomAndroid no Android Studio
2. Esperar o gradle sincronizar
3. Rodar no emulador ou no celular
