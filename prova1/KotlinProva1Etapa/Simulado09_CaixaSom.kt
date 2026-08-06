// Simulado: Caixa de Som Bluetooth
// Classe CaixaSom com marca (val). Atributo privado bateria (Int) inicia em 0. Maximo 100%.
// Metodo carregar(qtd: Int) - aumenta bateria, limite 100, sem negativos.
// Metodo tocarMusica(volume: Int): String - 1 = baixo (gasta 5%), 2 = alto (gasta 25%).
// Retorna "Tocando musica!" ou "Bateria insuficiente ou opcao invalida".

class CaixaSom(val marca: String) {

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

    fun tocarMusica(volume: Int): String {
        var gasto = 0
        if (volume == 1) {
            gasto = 5
        } else if (volume == 2) {
            gasto = 25
        } else {
            return "Bateria insuficiente ou opcao invalida"
        }

        if (bateria >= gasto) {
            bateria -= gasto
            return "Tocando musica!"
        } else {
            return "Bateria insuficiente ou opcao invalida"
        }
    }
}

fun main() {
    val caixa = CaixaSom("JBL")
    var opcao = 0

    do {
        println("\n--- MENU ---")
        println("1 - Carregar")
        println("2 - Tocar Musica Baixo")
        println("3 - Tocar Musica Alto")
        println("4 - Desligar")
        print("Escolha: ")
        opcao = readln().toInt()

        when (opcao) {
            1 -> {
                print("Quanto carregar: ")
                val qtd = readln().toInt()
                caixa.carregar(qtd)
            }
            2 -> println(caixa.tocarMusica(1))
            3 -> println(caixa.tocarMusica(2))
            4 -> println("Caixa desligada")
            else -> println("Opcao invalida")
        }
    } while (opcao != 4)
}
