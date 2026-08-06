// Simulado: Geladeira Inteligente
// Crie uma classe Geladeira com a marca (val) no construtor.
// Atributo privado: itens (Int) iniciando em 0. Capacidade maxima 50 itens.
// Metodo guardarItem(qtd: Int) - adiciona itens, nao passa de 50, sem negativos.
// Metodo retirarItem(tipo: Int): String - 1 retira 1 item, 2 retira 5 itens.
// Verifica se tem itens suficientes. Retorna "Item retirado!" ou "Sem itens ou opcao invalida".
// Menu: 1-Guardar 2-Retirar 1 item 3-Retirar 5 itens 4-Desligar

class Geladeira(val marca: String) {

    private var itens: Int = 0

    fun guardarItem(qtd: Int) {
        if (qtd < 0) {
            println("Valor invalido")
            return
        }
        itens += qtd
        if (itens > 50) {
            itens = 50
            println("Geladeira cheia (50 itens)")
        } else {
            println("Itens guardados. Total atual: $itens")
        }
    }

    fun retirarItem(tipo: Int): String {
        var gasto = 0
        if (tipo == 1) {
            gasto = 1
        } else if (tipo == 2) {
            gasto = 5
        } else {
            return "Sem itens ou opcao invalida"
        }

        if (itens >= gasto) {
            itens -= gasto
            return "Item retirado!"
        } else {
            return "Sem itens ou opcao invalida"
        }
    }
}

fun main() {
    val geladeira = Geladeira("Brastemp")
    var opcao = 0

    do {
        println("\n--- MENU ---")
        println("1 - Guardar Itens")
        println("2 - Retirar 1 Item")
        println("3 - Retirar 5 Itens")
        println("4 - Desligar")
        print("Escolha: ")
        opcao = readln().toInt()

        when (opcao) {
            1 -> {
                print("Quantos itens guardar: ")
                val qtd = readln().toInt()
                geladeira.guardarItem(qtd)
            }
            2 -> println(geladeira.retirarItem(1))
            3 -> println(geladeira.retirarItem(2))
            4 -> println("Geladeira desligada")
            else -> println("Opcao invalida")
        }
    } while (opcao != 4)
}
