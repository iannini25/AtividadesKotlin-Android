// Simulado: Aquario
// Classe Aquario com nome (val). Atributo privado agua (Int) inicia em 0. Maximo 200 litros.
// Metodo encherAgua(litros: Int) - adiciona, limite 200, sem negativos.
// Metodo trocarAgua(tipo: Int): String - 1 = troca parcial (gasta 30L), 2 = troca total (gasta 100L).
// Retorna "Troca feita!" ou "Agua insuficiente ou opcao invalida".

class Aquario(val nome: String) {

    private var agua: Int = 0

    fun encherAgua(litros: Int) {
        if (litros < 0) {
            println("Valor invalido")
            return
        }
        agua += litros
        if (agua > 200) {
            agua = 200
            println("Aquario cheio (200L)")
        } else {
            println("Agua adicionada. Total: ${agua}L")
        }
    }

    fun trocarAgua(tipo: Int): String {
        var gasto = 0
        if (tipo == 1) {
            gasto = 30
        } else if (tipo == 2) {
            gasto = 100
        } else {
            return "Agua insuficiente ou opcao invalida"
        }

        if (agua >= gasto) {
            agua -= gasto
            return "Troca feita!"
        } else {
            return "Agua insuficiente ou opcao invalida"
        }
    }
}

fun main() {
    val aquario = Aquario("Nemo")
    var opcao = 0

    do {
        println("\n--- MENU ---")
        println("1 - Encher Agua")
        println("2 - Troca Parcial")
        println("3 - Troca Total")
        println("4 - Sair")
        print("Escolha: ")
        opcao = readln().toInt()

        when (opcao) {
            1 -> {
                print("Quantos litros: ")
                val litros = readln().toInt()
                aquario.encherAgua(litros)
            }
            2 -> println(aquario.trocarAgua(1))
            3 -> println(aquario.trocarAgua(2))
            4 -> println("Saindo...")
            else -> println("Opcao invalida")
        }
    } while (opcao != 4)
}
