class Cafeteira(val marca: String) {

    private var nivelAgua: Int = 0

    fun abastecerAgua(quantidade: Int) {
        if (quantidade < 0) {
            println("Valor invalido")
            return
        }
        nivelAgua += quantidade
        if (nivelAgua > 1000) {
            nivelAgua = 1000
            println("Cafeteira cheia (1000ml)")
        } else {
            println("Abastecimento realizado. Nivel atual: ${nivelAgua}ml")
        }
    }

    fun fazerCafe(tamanho: Int): String {
        var gasto = 0
        if (tamanho == 1) {
            gasto = 50
        } else if (tamanho == 2) {
            gasto = 100
        } else {
            return "Agua insuficiente ou opcao invalida"
        }

        if (nivelAgua >= gasto) {
            nivelAgua -= gasto
            return "Cafe pronto!"
        } else {
            return "Agua insuficiente ou opcao invalida"
        }
    }
}

fun main() {
    val cafeteira = Cafeteira("Nescafe")
    var opcao = 0

    do {
        println("\n--- MENU ---")
        println("1 - Abastecer Agua")
        println("2 - Fazer Cafe Pequeno")
        println("3 - Fazer Cafe Grande")
        println("4 - Desligar")
        print("Escolha: ")
        opcao = readln().toInt()

        when (opcao) {
            1 -> {
                print("Quantidade de agua: ")
                val qtd = readln().toInt()
                cafeteira.abastecerAgua(qtd)
            }
            2 -> println(cafeteira.fazerCafe(1))
            3 -> println(cafeteira.fazerCafe(2))
            4 -> println("Cafeteira desligada")
            else -> println("Opcao invalida")
        }
    } while (opcao != 4)
}
