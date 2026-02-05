fun main () {

    val opcoes = listOf("Pedra", "Papel", "Tesoura")
    var continuarJogando = true // Uma variável que controla se o jogo deve continuar

    // O PLACAR
    var placarUsuario = 0
    var placarComputador = 0

    println("--- DESAFIO: PEDRA, PAPEL E TESOURA. ---")
    println("Digite 'Sair' para encerrar")

    while (continuarJogando) {
        print("\nSua Jogada: ")
        val entrada = readln()

        // Verificamos se quer sair
        if (entrada.lowercase() == "sair") {
            continuarJogando = false
        } else {
            // Tratamento da entrada
            val jogadaUsuario = entrada.lowercase().replaceFirstChar {it.uppercase()}

            // Validação
            if (jogadaUsuario !in opcoes) {
                println("Jogada inválida! Tente: Pedra, Papel, Tesoura ou Sair.")
            } else {
                val jogadaComputador = opcoes.random()
                    println("O Computador escolheu $jogadaComputador 🤖")

                // Lógica de resultado
                    when {
                        jogadaUsuario == jogadaComputador -> {
                            println("Resultado: Empate!")
                        }
                        (jogadaUsuario == "Pedra" && jogadaComputador == "Tesoura") ||
                        (jogadaUsuario == "Papel" && jogadaComputador == "Pedra") ||
                        (jogadaUsuario == "Tesoura" && jogadaComputador == "Papel") -> {
                        println("Parabéns, você venceu! 🎉")
                        placarUsuario++ // Atualiza o placar do Jogador

                    }
                    else -> {
                        println("Não foi dessa vez, o computador venceu. 🤖")
                        placarComputador++ // Atualiza o placar do Computador
                    }
                }
                println(">>> PLACAR ATUAL: Você $placarUsuario x $placarComputador Computador <<<")
            }
        }
    }
    // Pós-jogo: Resultado final
    println("\n=== FIM DE JOGO ===")
    println("Placar Final: Você $placarUsuario x $placarComputador Computador")

    // Lógica do grande campeão
    when {
        placarUsuario > placarComputador -> println("🏆 Parabéns, você é o grande campeão!")
        placarUsuario < placarComputador -> println("🤖 O computador levou a melhor hoje. Tente novamente!")
        else -> println("Foi uma disputa acirrada. Terminou empatado!")
    }
}