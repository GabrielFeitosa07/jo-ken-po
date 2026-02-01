fun main () {
    val opcoes = listOf("Pedra", "Papel", "Tesoura")

    println("--- DESAFIO: PEDRA, PAPEL E TESOURA ---")
    println("Digite a sua escolha: ")

    //Lê a entrada do usuário e garante que a primeira letra seja maiúscula
    val jogadaUsuario = readln().replaceFirstChar { it.uppercase() }

    //O Computador sorteia um item da lista
    val jogadaComputador = opcoes.random()

    // Verificamos se a jogada do usuário é válida
    if (jogadaUsuario !in opcoes) {
        println("Jogada inválida! Escolha entre Pedra, Papel ou Tesoura.")
    } else {
        println("Você: $jogadaUsuario Vs $jogadaComputador")

        //Início da Lógica de resultado
        if (jogadaUsuario == jogadaComputador) {
            println("Resultado: Empate!")
        }
        else if ((jogadaUsuario == "Pedra" && jogadaComputador == "Tesoura") ||
                (jogadaUsuario == "Papel" && jogadaComputador == "Pedra") ||
                (jogadaUsuario == "Tesoura" && jogadaComputador == "Papel")) {
            println("RESULTADO: Parabéns, você venceu! 🎉")
        }
        else {
            println("RESULTADO: Não foi dessa vez, o computador venceu.")
        }
    }
}