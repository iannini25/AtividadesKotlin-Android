# Diario de Treinos

App android em Kotlin com Jetpack Compose e Navigation Compose, feito igual a estrutura do HabitTracker da aula mas com outro tema.

## Tema escolhido

Diario de Treinos

## Telas

- Splash: aparece por 2 segundos e vai sozinha pra outra tela. Quem decide se vai pro Login ou pro Painel e o NavHost (AppNavegacao), olhando se o usuario ja esta logado
- Login: usuario e senha, ao entrar vai pro Painel (fica salvo que esta logado)
- Painel com bottom navigation de 3 abas:
  - Inicio: mostra o usuario e um formulario pra adicionar treino
  - Treinos: lista dos treinos (se nao tiver nenhum mostra mensagem de lista vazia)
  - Perfil: botao pra apagar todos os treinos e botao de sair
- Detalhe: abre quando clica num treino da lista, recebe o id pela rota Rota.Detalhe(id) e le com toRoute()

## Como foi feito

- Todas as rotas estao no sealed interface Rota com @Serializable (nenhuma rota em String)
- Bottom navigation usa saveState, restoreState e launchSingleTop, entao a rolagem da lista nao reseta ao trocar de aba
- Um unico TreinoViewModel criado no AppNavegacao e passado como parametro pra todas as telas
- Cores do app no ui/theme (Cores.kt e Tema.kt com lightColorScheme), nenhuma tela usa Color direto
- Todos os icones tem contentDescription

## Como rodar

1. Abrir a pasta NavegacaoAndroid no Android Studio
2. Esperar o gradle sincronizar
3. Rodar no emulador ou no celular
