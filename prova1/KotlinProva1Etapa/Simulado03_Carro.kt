// Simulado: Carro
// Classe Carro com modelo (val). Atributo privado tanque (Int) inicia em 0. Maximo 60 litros.
// Metodo abastecer(litros: Int) - adiciona, limite 60, sem negativos.
// Metodo andar(distancia: Int): String - 1 = curta (gasta 5L), 2 = longa (gasta 15L).
// Retorna "Viagem feita!" ou "Combustivel insuficiente ou opcao invalida".

class Carro(val modelo: String) {

    private var tanque: Int = 0

    fun abastecer(litros: Int) {
        if (litros < 0) {
            println("Valor invalido")
            return
        }
        tanque += litros
        if (tanque > 60) {
            tanque = 60
            println("Tanque cheio (60L)")
        } else {
            println("Abastecido. Tanque atual: ${tanque}L")
        }
    }

    fun andar(distancia: Int): String {
        var gasto = 0
        if (distancia == 1) {
            gasto = 5
        } else if (distancia == 2) {
            gasto = 15
        } else {
            return "Combustivel insuficiente ou opcao invalida"
        }

        if (tanque >= gasto) {
            tanque -= gasto
            return "Viagem feita!"
        } else {
            return "Combustivel insuficiente ou opcao invalida"
        }
    }
}

fun main() {
    val carro = Carro("Fiat Uno")
    var opcao = 0

    do {
        println("\n--- MENU ---")
        println("1 - Abastecer")
        println("2 - Viagem Curta")
        println("3 - Viagem Longa")
        println("4 - Desligar")
        print("Escolha: ")
        opcao = readln().toInt()

        when (opcao) {
            1 -> {
                print("Quantos litros: ")
                val litros = readln().toInt()
                carro.abastecer(litros)
            }
            2 -> println(carro.andar(1))
            3 -> println(carro.andar(2))
            4 -> println("Carro desligado")
            else -> println("Opcao invalida")
        }
    } while (opcao != 4)
}
