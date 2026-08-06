// Simulado: Maquina de Refrigerante
// Classe MaquinaRefri com marca (val). Atributo privado refri (Int) inicia em 0. Maximo 2000ml.
// Metodo abastecer(qtd: Int) - adiciona refri, limite 2000, sem negativos.
// Metodo servirCopo(tamanho: Int): String - 1 = pequeno (200ml), 2 = grande (500ml).
// Retorna "Copo servido!" ou "Refrigerante insuficiente ou opcao invalida".

class MaquinaRefri(val marca: String) {

    private var refri: Int = 0

    fun abastecer(qtd: Int) {
        if (qtd < 0) {
            println("Valor invalido")
            return
        }
        refri += qtd
        if (refri > 2000) {
            refri = 2000
            println("Maquina cheia (2000ml)")
        } else {
            println("Abastecida. Refrigerante atual: ${refri}ml")
        }
    }

    fun servirCopo(tamanho: Int): String {
        var gasto = 0
        if (tamanho == 1) {
            gasto = 200
        } else if (tamanho == 2) {
            gasto = 500
        } else {
            return "Refrigerante insuficiente ou opcao invalida"
        }

        if (refri >= gasto) {
            refri -= gasto
            return "Copo servido!"
        } else {
            return "Refrigerante insuficiente ou opcao invalida"
        }
    }
}

fun main() {
    val maquina = MaquinaRefri("Coca")
    var opcao = 0

    do {
        println("\n--- MENU ---")
        println("1 - Abastecer")
        println("2 - Copo Pequeno")
        println("3 - Copo Grande")
        println("4 - Desligar")
        print("Escolha: ")
        opcao = readln().toInt()

        when (opcao) {
            1 -> {
                print("Quantos ml: ")
                val qtd = readln().toInt()
                maquina.abastecer(qtd)
            }
            2 -> println(maquina.servirCopo(1))
            3 -> println(maquina.servirCopo(2))
            4 -> println("Maquina desligada")
            else -> println("Opcao invalida")
        }
    } while (opcao != 4)
}
