// Simulado: Conta Bancaria
// Classe ContaBancaria com titular (val). Atributo privado saldo (Int) inicia em 0. Limite 10000.
// Metodo depositar(valor: Int) - adiciona ao saldo, limite 10000, sem negativos.
// Metodo sacar(tipo: Int): String - 1 = saque pequeno (100), 2 = saque grande (500).
// Retorna "Saque realizado!" ou "Saldo insuficiente ou opcao invalida".

class ContaBancaria(val titular: String) {

    private var saldo: Int = 0

    fun depositar(valor: Int) {
        if (valor < 0) {
            println("Valor invalido")
            return
        }
        saldo += valor
        if (saldo > 10000) {
            saldo = 10000
            println("Saldo no limite (R$10000)")
        } else {
            println("Deposito feito. Saldo atual: R$$saldo")
        }
    }

    fun sacar(tipo: Int): String {
        var gasto = 0
        if (tipo == 1) {
            gasto = 100
        } else if (tipo == 2) {
            gasto = 500
        } else {
            return "Saldo insuficiente ou opcao invalida"
        }

        if (saldo >= gasto) {
            saldo -= gasto
            return "Saque realizado!"
        } else {
            return "Saldo insuficiente ou opcao invalida"
        }
    }
}

fun main() {
    val conta = ContaBancaria("Joao")
    var opcao = 0

    do {
        println("\n--- MENU ---")
        println("1 - Depositar")
        println("2 - Saque Pequeno (R$100)")
        println("3 - Saque Grande (R$500)")
        println("4 - Sair")
        print("Escolha: ")
        opcao = readln().toInt()

        when (opcao) {
            1 -> {
                print("Valor do deposito: ")
                val valor = readln().toInt()
                conta.depositar(valor)
            }
            2 -> println(conta.sacar(1))
            3 -> println(conta.sacar(2))
            4 -> println("Saindo...")
            else -> println("Opcao invalida")
        }
    } while (opcao != 4)
}
