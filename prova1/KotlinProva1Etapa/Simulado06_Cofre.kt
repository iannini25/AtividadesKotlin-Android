// Simulado: Cofre Digital
// Classe Cofre com dono (val). Atributo privado dinheiro (Int) inicia em 0. Maximo 5000.
// Metodo guardar(valor: Int) - adiciona, limite 5000, sem negativos.
// Metodo retirar(tipo: Int): String - 1 = pouco (50), 2 = muito (200).
// Retorna "Retirada feita!" ou "Dinheiro insuficiente ou opcao invalida".

class Cofre(val dono: String) {

    private var dinheiro: Int = 0

    fun guardar(valor: Int) {
        if (valor < 0) {
            println("Valor invalido")
            return
        }
        dinheiro += valor
        if (dinheiro > 5000) {
            dinheiro = 5000
            println("Cofre cheio (R$5000)")
        } else {
            println("Guardado. Dinheiro no cofre: R$$dinheiro")
        }
    }

    fun retirar(tipo: Int): String {
        var gasto = 0
        if (tipo == 1) {
            gasto = 50
        } else if (tipo == 2) {
            gasto = 200
        } else {
            return "Dinheiro insuficiente ou opcao invalida"
        }

        if (dinheiro >= gasto) {
            dinheiro -= gasto
            return "Retirada feita!"
        } else {
            return "Dinheiro insuficiente ou opcao invalida"
        }
    }
}

fun main() {
    val cofre = Cofre("Maria")
    var opcao = 0

    do {
        println("\n--- MENU ---")
        println("1 - Guardar Dinheiro")
        println("2 - Retirar Pouco (R$50)")
        println("3 - Retirar Muito (R$200)")
        println("4 - Fechar Cofre")
        print("Escolha: ")
        opcao = readln().toInt()

        when (opcao) {
            1 -> {
                print("Quanto guardar: ")
                val valor = readln().toInt()
                cofre.guardar(valor)
            }
            2 -> println(cofre.retirar(1))
            3 -> println(cofre.retirar(2))
            4 -> println("Cofre fechado")
            else -> println("Opcao invalida")
        }
    } while (opcao != 4)
}
