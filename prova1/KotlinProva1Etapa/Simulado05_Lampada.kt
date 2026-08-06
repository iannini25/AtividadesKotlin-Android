// Simulado: Lampada Inteligente
// Classe Lampada com modelo (val). Atributo privado bateria (Int) inicia em 0. Maximo 100%.
// Metodo carregar(qtd: Int) - aumenta bateria, limite 100, sem negativos.
// Metodo acender(modo: Int): String - 1 = fraca (gasta 10), 2 = forte (gasta 30).
// Retorna "Lampada acesa!" ou "Bateria insuficiente ou opcao invalida".

class Lampada(val modelo: String) {

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
            println("Carregada. Bateria atual: $bateria%")
        }
    }

    fun acender(modo: Int): String {
        var gasto = 0
        if (modo == 1) {
            gasto = 10
        } else if (modo == 2) {
            gasto = 30
        } else {
            return "Bateria insuficiente ou opcao invalida"
        }

        if (bateria >= gasto) {
            bateria -= gasto
            return "Lampada acesa!"
        } else {
            return "Bateria insuficiente ou opcao invalida"
        }
    }
}

fun main() {
    val lampada = Lampada("Philips")
    var opcao = 0

    do {
        println("\n--- MENU ---")
        println("1 - Carregar")
        println("2 - Acender Fraca")
        println("3 - Acender Forte")
        println("4 - Desligar")
        print("Escolha: ")
        opcao = readln().toInt()

        when (opcao) {
            1 -> {
                print("Quanto carregar: ")
                val qtd = readln().toInt()
                lampada.carregar(qtd)
            }
            2 -> println(lampada.acender(1))
            3 -> println(lampada.acender(2))
            4 -> println("Lampada desligada")
            else -> println("Opcao invalida")
        }
    } while (opcao != 4)
}
