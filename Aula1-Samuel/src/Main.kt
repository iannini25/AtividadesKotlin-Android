//implenmentar depois de saudacoes e regras
fun saudacaoRegras(tamanho:Int, max:Int, exemplo:String){
    println("Voce deve acertar a palavra que tem $tamanho letras e voce vai ter $max tentativas.")
}

//gerar aleatorio o segredo depois
fun gerarSegredo():String{
    return "ABCD"
}

fun respostaSegura():String = readlnOrNull() ?: error("Sua resposta é inapropriada")

fun acertou(segredo:String, chute:String):Boolean {
    if (segredo == chute){
        return true
    }
    else {
        return false
    }
}

fun playGames(segredo: String, max: Int, tamanho: Int) {
    var chute: String
    var tentativas = 0

    do {
        println("Tentativa ${tentativas + 1} de $max. Insira seu chute ($tamanho letras):")
        chute = respostaSegura().uppercase()

        if (acertou(segredo, chute)) {
            println("Boa! Você acertou a palavra: $segredo")
        } else {
            tentativas++
            println("Errado! Tente novamente.")
        }

    } while (!acertou(segredo, chute) && tentativas < max)

    if (tentativas == max && !acertou(segredo, chute)) {
        println("Game Over! O segredo era: $segredo")
    }
}

fun main(){
    val tamanhoPalavra:Int = 4
    val maxTentativas:Int = 4
    val exemploSegredo:String = "VACA"
    saudacaoRegras(tamanhoPalavra, maxTentativas, exemploSegredo)
    playGames(gerarSegredo(), maxTentativas, tamanhoPalavra)
}