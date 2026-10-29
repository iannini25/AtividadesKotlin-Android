# Busca CEP

App android feito em Kotlin com Jetpack Compose que busca o endereco a partir de um CEP.
A pessoa digita o CEP, clica em buscar e o app mostra rua, bairro, cidade, estado e DDD.
Se o CEP nao existir ou a internet estiver desligada aparece uma mensagem de erro e o app nao fecha.
Foi feito usando a mesma arquitetura da pokedex feita em aula (MVVM + Retrofit + Coroutines).

## API escolhida

ViaCEP - https://viacep.com.br/ws/{cep}/json/

## Telas / funcionalidades

- Tela unica com campo pra digitar o CEP e botao de buscar
- Mostra carregando enquanto busca
- Mostra os dados do endereco quando acha
- Mostra mensagem de erro quando o CEP nao existe ou quando da erro de internet

## Pacotes

- model: data class Endereco (com @SerializedName)
- network: interface do retrofit (ViaCepApi) e o cliente (RetrofitCliente)
- viewmodel: CepViewModel e o sealed interface CepUiState (Inicio, Carregando, Sucesso, Erro)
- ui: TelaCep feita em compose

## Como rodar

1. Abrir a pasta AtividadeAPIs no Android Studio
2. Esperar o gradle sincronizar
3. Rodar no emulador ou celular (precisa de internet)
