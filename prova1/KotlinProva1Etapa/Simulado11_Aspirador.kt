// Simulado: Aspirador Robo
// Classe Aspirador com modelo (val). Atributo privado bateria (Int) inicia em 0. Maximo 100%.
// Metodo carregar(qtd: Int) - aumenta bateria, limite 100, sem negativos.
// Metodo limparArea(tipo: Int): String - 1 = sala (gasta 15%), 2 = casa toda (gasta 50%).
// Retorna "Limpeza concluida!" ou "Bateria insuficiente ou opcao invalida".

class Aspirador(val modelo: String) {

    private var bateria: Int = 0

    fun carregar(qtd: Int) {
        if (qtd < 0) {
            println("Valor invalido")
            return
        }
        bateria += qtd
        if (bateria > 100) {
            bateria = 100
            println("Bateria cheia (100%)")
        } else {
            println("Carregando. Bateria atual: $bateria%")
        }
    }

    fun limparArea(tipo: Int): String {
        var gasto = 0
        if (tipo == 1) {
            gasto = 15
        } else if (tipo == 2) {
            gasto = 50
        } else {
            return "Bateria insuficiente ou opcao invalida"
        }

        if (bateria >= gasto) {
            bateria -= gasto
            return "Limpeza concluida!"
        } else {
            return "Bateria insuficiente ou opcao invalida"
        }
    }
}

fun main() {
    val aspirador = Aspirador("Roomba")
    var opcao = 0

    do {
        println("\n--- MENU ---")
        println("1 - Carregar")
        println("2 - Limpar Sala")
        println("3 - Limpar Casa Toda")
        println("4 - Desligar")
        print("Escolha: ")
        opcao = readln().toInt()

        when (opcao) {
            1 -> {
                print("Quanto carregar: ")
                val qtd = readln().toInt()
                aspirador.carregar(qtd)
            }
            2 -> println(aspirador.limparArea(1))
            3 -> println(aspirador.limparArea(2))
            4 -> println("Aspirador desligado")
            else -> println("Opcao invalida")
        }
    } while (opcao != 4)
}
