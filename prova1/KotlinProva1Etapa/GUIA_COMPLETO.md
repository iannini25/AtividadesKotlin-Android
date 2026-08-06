# 📚 GUIA COMPLETO — Prova de Kotlin / Android (IntelliJ)

> Esse guia foi feito pra você entender **tudo** que vai cair na prova.  
> Lê com calma, do início ao fim. Cada conceito tem explicação simples + exemplo + variação.

---

## 🎯 1. O QUE A PROVA PEDE (em essência)

Toda prova nesse formato pede a **MESMA coisa**, só muda o tema (cafeteira, geladeira, carro, etc.).

A estrutura é sempre:

1. Criar um **projeto novo** no IntelliJ com nome no padrão `SimuladoXXX`.
2. Criar **uma classe** com:
   - Construtor primário recebendo um atributo imutável (val).
   - Um atributo **privado** (var) que começa em 0.
3. Criar um método tipo **"abastecer/encher/depositar"** que adiciona ao atributo, com **limite máximo** e bloqueio de **valores negativos**.
4. Criar um método tipo **"usar/gastar/retirar"** que recebe um número (1 ou 2), define quanto gasta, verifica se tem o suficiente, e retorna uma `String`.
5. Criar a função `main()` com um **menu em loop** (`do-while`), capturando opção com `readln().toInt()` e usando `when` pra decidir.

**Se você entender esse padrão, você passa em qualquer variação.**

---

## 🛠️ 2. CRIANDO O PROJETO NO INTELLIJ

Passo a passo:

1. Abra o IntelliJ IDEA.
2. Clique em **"New Project"**.
3. Em **Name**, coloque o nome pedido (ex: `Simulado3A05` se você é da turma A e número 5).
4. Em **Language**, selecione **Kotlin**.
5. Em **Build system**, deixe em **IntelliJ** (mais simples, sem Gradle).
6. Selecione um **JDK** (qualquer 17 ou 21 serve).
7. Clique em **Create**.

Depois de criado:

8. Vá na pasta `src` no painel esquerdo.
9. Clique com o botão direito → **New → Kotlin Class/File**.
10. Escolha **Class** e dê um nome (ex: `Cafeteira`).
11. Crie outro arquivo, agora do tipo **File**, com nome `Main` (vai ser onde fica a `fun main`).

> **Dica:** Você pode colocar a classe e o `main()` no mesmo arquivo se quiser. Funciona igual. Mas o enunciado pede arquivos separados, então faça separado.

---

## 🧱 3. CLASSES EM KOTLIN

### 3.1 O que é uma classe?

Classe é um **molde** pra criar objetos. Tipo uma "receita" que define o que o objeto sabe fazer e o que ele guarda.

### 3.2 Sintaxe básica

```kotlin
class NomeDaClasse(val parametro: Tipo) {
    // atributos
    // métodos
}
```

### 3.3 Construtor primário

Em Kotlin, o construtor já vem **junto com a declaração da classe**, dentro dos parênteses:

```kotlin
class Cafeteira(val marca: String) {
    // ...
}
```

Aqui o `val marca: String` significa:
- `val` → variável **imutável** (não pode ser alterada depois).
- `marca` → nome do atributo.
- `String` → tipo (texto).

> ⚠️ Se a prova disser **"imutável"**, use `val`. Se disser **"pode mudar"**, use `var`.

### 3.4 Atributo privado

Atributo privado é aquele que **só a própria classe pode mexer**. De fora, ninguém pode acessar.

```kotlin
class Cafeteira(val marca: String) {
    private var nivelAgua: Int = 0
}
```

- `private` → ninguém de fora vê esse atributo.
- `var` → variável que **pode mudar** (porque a água vai aumentar/diminuir).
- `nivelAgua` → nome.
- `Int` → tipo (número inteiro).
- `= 0` → valor inicial.

### 3.5 Criar (instanciar) um objeto

Pra usar a classe, você **cria um objeto** dela:

```kotlin
val cafeteira = Cafeteira("Nescafe")
```

Pronto. Agora `cafeteira` é um objeto e você pode chamar os métodos dele:

```kotlin
cafeteira.abastecerAgua(200)
```

---

## 🔧 4. MÉTODOS EM KOTLIN

### 4.1 Método sem retorno

Quando o método **só faz alguma coisa** (não devolve valor), use `fun` simples:

```kotlin
fun abastecerAgua(quantidade: Int) {
    nivelAgua += quantidade
}
```

### 4.2 Método com retorno

Quando o método **devolve algo**, declare o tipo depois dos `:`:

```kotlin
fun fazerCafe(tamanho: Int): String {
    return "Cafe pronto!"
}
```

- `: String` → vai retornar uma String.
- `return` → palavra que devolve o valor.

### 4.3 Parâmetros

Parâmetros são valores que o método recebe:

```kotlin
fun exemplo(nome: String, idade: Int) {
    // pode usar 'nome' e 'idade' aqui dentro
}
```

---

## 🚦 5. ESTRUTURAS DE DECISÃO

### 5.1 if / else if / else

```kotlin
if (idade >= 18) {
    println("Maior de idade")
} else if (idade >= 12) {
    println("Adolescente")
} else {
    println("Crianca")
}
```

### 5.2 Operadores de comparação

| Operador | Significado     |
|----------|-----------------|
| `==`     | igual a         |
| `!=`     | diferente de    |
| `>`      | maior que       |
| `<`      | menor que       |
| `>=`     | maior ou igual  |
| `<=`     | menor ou igual  |

### 5.3 Estrutura `when` (igual o switch de outras linguagens)

```kotlin
when (opcao) {
    1 -> println("Opcao 1")
    2 -> println("Opcao 2")
    3 -> println("Opcao 3")
    else -> println("Invalido")
}
```

- Cada `->` separa a condição da ação.
- `else` é o "padrão" (quando nenhuma das outras bate).

Se a ação tem **mais de uma linha**, use chaves `{}`:

```kotlin
when (opcao) {
    1 -> {
        print("Digite o valor: ")
        val v = readln().toInt()
        cafeteira.abastecerAgua(v)
    }
    2 -> println("Opcao 2")
    else -> println("Invalido")
}
```

---

## 🔁 6. ESTRUTURAS DE REPETIÇÃO

### 6.1 while

Verifica a condição **antes** de rodar:

```kotlin
var i = 0
while (i < 5) {
    println(i)
    i++
}
```

### 6.2 do-while

Roda **uma vez antes** de verificar a condição (ideal pra menus, porque sempre mostra o menu pelo menos 1 vez):

```kotlin
var opcao = 0
do {
    println("Menu...")
    opcao = readln().toInt()
} while (opcao != 4)
```

> 💡 **Pra menu de prova, sempre prefira `do-while`.** Garante que o menu apareça pelo menos uma vez.

---

## ⌨️ 7. LENDO ENTRADA DO USUÁRIO

### 7.1 Ler texto

```kotlin
val texto = readln()
```

### 7.2 Ler número inteiro

```kotlin
val numero = readln().toInt()
```

> O `.toInt()` converte o texto digitado em número.

### 7.3 Ler número decimal

```kotlin
val numero = readln().toDouble()
```

### 7.4 Imprimir na tela

```kotlin
println("Texto com quebra de linha")  // pula linha
print("Texto sem quebra")              // não pula
```

---

## 💬 8. STRINGS COM VARIÁVEIS DENTRO (template strings)

Pra colocar uma variável dentro de uma String, use **`$`**:

```kotlin
val nome = "Joao"
println("Ola, $nome!")   // Ola, Joao!
```

Se for **expressão composta** (com cálculo, atributo de objeto, etc.), use `${}`:

```kotlin
println("Nivel atual: ${nivelAgua}ml")
println("Soma: ${2 + 3}")
```

---

## 🧠 9. A LÓGICA DOS MÉTODOS DA PROVA (PADRÃO)

Aqui é o **coração** da prova. Decora esse padrão.

### 9.1 Método de "abastecer/adicionar"

**Regras típicas:**
- Adiciona valor ao atributo.
- Tem um limite máximo.
- Não aceita negativo.

**Esqueleto:**

```kotlin
fun abastecer(quantidade: Int) {
    if (quantidade < 0) {
        println("Valor invalido")
        return
    }
    atributo += quantidade
    if (atributo > LIMITE) {
        atributo = LIMITE
        println("Cheio (LIMITE)")
    } else {
        println("Abastecido. Atual: $atributo")
    }
}
```

> O `return` sozinho **sai do método sem retornar nada** (porque o método é `Unit`/sem retorno).

### 9.2 Método de "usar/gastar" com retorno String

**Regras típicas:**
- Recebe um número (1 ou 2) que representa o tipo da ação.
- Cada tipo gasta uma quantidade diferente.
- Verifica se tem o suficiente.
- Retorna mensagem de sucesso ou erro.

**Esqueleto:**

```kotlin
fun usar(tipo: Int): String {
    var gasto = 0
    if (tipo == 1) {
        gasto = VALOR1
    } else if (tipo == 2) {
        gasto = VALOR2
    } else {
        return "Recurso insuficiente ou opcao invalida"
    }

    if (atributo >= gasto) {
        atributo -= gasto
        return "Sucesso!"
    } else {
        return "Recurso insuficiente ou opcao invalida"
    }
}
```

> ⚠️ Cuidado: o enunciado da prova quer **EXATAMENTE** as mensagens que ele pediu. Não invente outra escrita. Se ele disser `"Café pronto!"`, escreve assim, com til, com exclamação, igualzinho.

---

## 📋 10. PADRÃO DA FUNÇÃO `main()`

```kotlin
fun main() {
    val objeto = MinhaClasse("Marca X")
    var opcao = 0

    do {
        println("\n--- MENU ---")
        println("1 - Acao A")
        println("2 - Acao B (tipo 1)")
        println("3 - Acao B (tipo 2)")
        println("4 - Sair")
        print("Escolha: ")
        opcao = readln().toInt()

        when (opcao) {
            1 -> {
                print("Digite o valor: ")
                val v = readln().toInt()
                objeto.metodoA(v)
            }
            2 -> println(objeto.metodoB(1))
            3 -> println(objeto.metodoB(2))
            4 -> println("Desligando...")
            else -> println("Opcao invalida")
        }
    } while (opcao != 4)
}
```

**Pontos importantes:**
- `var opcao = 0` → começa com 0 pra entrar no loop.
- `do { ... } while (opcao != 4)` → roda enquanto não escolher sair.
- No `when`, **só use chaves `{}` quando precisar de mais de uma linha**.
- Quando o método retorna String, use `println(objeto.metodo())` pra mostrar o retorno.

---

## 🔄 11. COMO ADAPTAR PRA QUALQUER TEMA

Olha a "fórmula mágica" pra qualquer simulado nesse formato:

| Elemento da prova                    | Onde fica no código              |
|--------------------------------------|----------------------------------|
| Nome da máquina/sistema              | Nome da classe                   |
| Identificador (marca, modelo, dono)  | `val` no construtor              |
| Coisa que enche/esvazia              | Atributo privado `var Int = 0`   |
| Limite máximo                        | Constante no método de adicionar |
| Tipo 1 / Tipo 2 (pequeno/grande)     | Parâmetro do segundo método      |
| Mensagens                            | Strings exatamente como pedido   |
| Opção pra sair                       | Última do menu (geralmente 4)    |

### Exemplo de adaptação rápida

Se o enunciado disser:
> "Crie uma classe `Microondas` com a marca. Atributo privado `tempo` (Int). O método `adicionarTempo` tem limite de 600 segundos. O método `aquecer(intensidade)` tem 1=baixa (gasta 60s) e 2=alta (gasta 180s)."

Você só **troca os nomes e os números**. A estrutura é IGUAL.

---

## 🎓 12. CHECKLIST FINAL DE PROVA

Antes de entregar, conferir:

- [ ] Criei o projeto com o nome no formato pedido (`Simulado3XNN`)?
- [ ] A classe tem o construtor primário com o `val` certinho?
- [ ] O atributo privado começa em 0 com `var`?
- [ ] O método de abastecer tem o limite máximo?
- [ ] O método de abastecer bloqueia valores negativos?
- [ ] O método de usar retorna `String`?
- [ ] As mensagens estão **escritas exatamente** como pedido (com pontuação, acento se for o caso)?
- [ ] O menu mostra todas as opções pedidas?
- [ ] Estou usando `readln().toInt()` pra capturar a opção?
- [ ] Estou usando `when` pra decidir a ação?
- [ ] O loop encerra na opção correta (geralmente 4)?
- [ ] Testei o código rodando? (Roda no IntelliJ apertando o ▶️ verde do lado do `fun main`)

---

## 🐛 13. ERROS COMUNS QUE TIRAM PONTO

### ❌ Erro 1: Esquecer `private` no atributo
```kotlin
var nivelAgua: Int = 0   // errado! falta private
```
✅ Correto:
```kotlin
private var nivelAgua: Int = 0
```

### ❌ Erro 2: Usar `var` no construtor quando pediu imutável
```kotlin
class Cafeteira(var marca: String)   // errado se pediu imutável
```
✅ Correto:
```kotlin
class Cafeteira(val marca: String)
```

### ❌ Erro 3: Não declarar tipo de retorno
```kotlin
fun fazerCafe(tamanho: Int) {        // errado! falta : String
    return "Cafe pronto!"            // dá erro de compilação
}
```
✅ Correto:
```kotlin
fun fazerCafe(tamanho: Int): String {
    return "Cafe pronto!"
}
```

### ❌ Erro 4: Esquecer o `else` no `when` com opção inválida
```kotlin
when (opcao) {
    1 -> ...
    2 -> ...
    // sem else → tudo bem compila, mas perde ponto se a prova pedir tratar invalido
}
```

### ❌ Erro 5: Usar `if` sem chaves quando tem mais de uma linha
```kotlin
if (qtd < 0)
    println("Erro")
    return                  // CUIDADO! esse return NÃO está dentro do if
```
✅ Correto:
```kotlin
if (qtd < 0) {
    println("Erro")
    return
}
```

### ❌ Erro 6: Confundir `print` com `println`
- `print` → não pula linha.
- `println` → pula linha.

### ❌ Erro 7: Tentar acessar atributo privado de fora
```kotlin
cafeteira.nivelAgua = 500   // ERRO! atributo é private
```

---

## 🔑 14. SINTAXE QUE VOCÊ PRECISA MEMORIZAR

```kotlin
// Declarar variável imutável (não muda)
val nome = "Joao"

// Declarar variável mutável (pode mudar)
var idade = 20

// Declarar com tipo explícito
val nome: String = "Joao"
var idade: Int = 20

// Classe com construtor e atributo privado
class Exemplo(val marca: String) {
    private var contador: Int = 0
}

// Método sem retorno
fun fazer(qtd: Int) {
    // ...
}

// Método com retorno
fun calcular(): Int {
    return 10
}

// Ler do teclado
val texto = readln()
val numero = readln().toInt()

// Imprimir
println("Texto")
println("Variavel: $variavel")
println("Calculo: ${2 + 2}")

// If
if (x > 10) { ... } else { ... }

// When
when (x) {
    1 -> println("Um")
    2 -> println("Dois")
    else -> println("Outro")
}

// Do-While
do {
    // codigo
} while (condicao)

// Instanciar objeto
val obj = MinhaClasse("parametro")
```

---

## 🧪 15. EXERCÍCIO MENTAL: ADAPTANDO PRA QUALQUER COISA

Imagine que cai na prova:

> "Crie uma classe `Impressora` com a marca. Atributo privado `papel` começando em 0. Limite 500 folhas. Método `colocarPapel(qtd)` adiciona, com limite. Método `imprimir(modo)`: 1 = simples (gasta 1 folha), 2 = duplex (gasta 2 folhas). Retorne 'Impresso!' ou 'Sem papel ou opcao invalida'."

Tente fazer **mentalmente** seguindo o padrão. Se conseguir adaptar, você está pronto.

---

## ✅ 16. RESUMO DO RESUMO

Se você só tiver 5 minutos pra revisar antes da prova, lembra disso:

1. **Classe** = `class Nome(val attr: String) { ... }`
2. **Atributo privado** = `private var x: Int = 0`
3. **Método sem retorno** = `fun nome(p: Int) { ... }`
4. **Método com retorno** = `fun nome(): String { return "x" }`
5. **Limite máximo** = `if (x > LIMITE) { x = LIMITE }`
6. **Bloqueia negativo** = `if (qtd < 0) { ...; return }`
7. **Menu** = `do { ... } while (opcao != 4)`
8. **Capturar opção** = `readln().toInt()`
9. **Decidir ação** = `when (opcao) { 1 -> ... }`
10. **Imprimir retorno do método** = `println(obj.metodo())`

---

**🎯 Boa prova! Se você fizer igual aos 11 simulados que estão aqui, tira nota cheia.**
