# Multiverse Radar

App android em Kotlin com Jetpack Compose que mostra os personagens de Rick and Morty.
Funciona offline-first: os personagens vem da API, sao salvos no Room e a tela so le do Room.
Se a internet cair os personagens que ja foram salvos continuam aparecendo.

## API

The Rick and Morty API - GET https://rickandmortyapi.com/api/character

## Como funciona

- model: PersonagemApi e RespostaApi (json da api), PersonagemEntity (tabela do room) e a funcao paraEntity() que converte um no outro
- data: PersonagemDao (Flow com todos os personagens e @Upsert pra salvar a lista) e BancoDados (@Database)
- network: RickApi (retrofit) e RetrofitCliente (com Gson)
- repository: PersonagemRepository com o Flow que vem do room e a funcao syncCharacters() que busca na api e salva no room
- viewmodel: PersonagemViewModel (StateFlow) e EstadoSync (Idle, Loading, Success, Error)
- ui: TelaPersonagens com TopAppBar, botao de sincronizar, carregando, mensagem de erro e LazyColumn com Cards (imagem com Coil, nome e especie)

## Testes

- Sincronizar uma vez, ligar o modo aviao, fechar e abrir o app: a lista continua la
- Com modo aviao clicar em sincronizar: aparece aviso de erro e a lista nao some

## Como rodar

1. Abrir a pasta RickAndMorty no Android Studio
2. Esperar o gradle sincronizar
3. Rodar no emulador ou no celular e clicar no botao de sincronizar (icone no canto de cima)
