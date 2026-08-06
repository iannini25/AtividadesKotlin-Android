// Simulado: Celular
// Classe Celular com modelo (val). Atributo privado bateria (Int) inicia em 0. Maximo 100%.
// Metodo carregarBateria(qtd: Int) - aumenta bateria, limite 100, sem negativos.
// Metodo usarApp(tipo: Int): String - 1 = leve (gasta 5%), 2 = pesado (gasta 20%).
// Retorna "App usado!" ou "Bateria insuficiente ou opcao invalida".

class Celular(val modelo: String) {

    private var bateria: Int = 0

    fun carregarBateria(qtd: Int) {
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

    fun usarApp(tipo: Int): String {
        var gasto = 0
        if (tipo == 1) {
            gasto = 5
        } else if (tipo == 2) {
            gasto = 20
        } else {
            return "Bateria insuficiente ou opcao invalida"
        }

        if (bateria >= gasto) {
            bateria -= gasto
            return "App usado!"
        } else {
            return "Bateria insuficiente ou opcao invalida"
        }
    }
}

fun main() {
    val celular = Celular("Samsung")
    var opcao = 0

    do {
        println("\n--- MENU ---")
        println("1 - Carregar")
        println("2 - Usar App Leve")
        println("3 - Usar App Pesado")
        println("4 - Desligar")
        print("Escolha: ")
        opcao = readln().toInt()

        when (opcao) {
            1 -> {
                print("Quanto carregar: ")
                val qtd = readln().toInt()
                celular.carregarBateria(qtd)
            }
            2 -> println(celular.usarApp(1))
            3 -> println(celular.usarApp(2))
            4 -> println("Celular desligado")
            else -> println("Opcao invalida")
        }
    } while (opcao != 4)
}
