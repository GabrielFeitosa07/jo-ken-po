fun main () {
    println("--- DESAFIO: PEDRA, PAPEL E TESOURA ---")
    println("Digite 'Sair' a qualquer momento para encerrar")

    val opcoes = listOf("Pedra", "Papel", "Tesoura", "Sair")
    var continuarJogando = true // Uma variável que controla se o jogo deve continuar

    while (continuarJogando) {
        print("\nSua Jogada: ")
        val entrada = readln()

        //Verificamos primeiro se o usuário quer sair
        if (entrada.lowercase() == "sair") {
            continuarJogando = false
            println("Obrigado por jogar! até a próxima.")
        } else {
            //Ajustamos a entrada para comparar com a lista (Ex: "pedra" vira "Pedra")
            val jogadaUsuario = entrada.lowercase().replaceFirstChar {it.uppercase()}

            //Verificamos se a jogada do usuário é válida
            if (jogadaUsuario !in opcoes) {
                println("Jogada inválida! Tente: Pedra, Papel, Tesoura ou Sair.")
            } else {
                val jogadaComputador = opcoes.random()
                    println("O Computador escolheu $jogadaComputador 🤖")

                //Início da Lógica de resultado
                if (jogadaUsuario == jogadaComputador) {
                    println("Resultado: Empate!")
                } else if ((jogadaUsuario == "Pedra" && jogadaComputador == "Tesoura") ||
                    (jogadaUsuario == "Papel" && jogadaComputador == "Pedra") ||
                    (jogadaUsuario == "Tesoura" && jogadaComputador == "Papel")) {
                    println("Parabéns, você venceu! 🎉")
                } else {
                    println("Não foi dessa vez, o computador venceu. 🤖")
                }
            }
        }
    }
}