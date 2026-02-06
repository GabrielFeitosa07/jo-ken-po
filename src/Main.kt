fun main () {

    // VARIÁVEIS DE ESTADO
    val options = listOf("Pedra", "Papel", "Tesoura")
    val playerHistory = mutableListOf<String>()
    var continuePlaying = true // Uma variável que controla se o jogo deve continuar
    var playerScore = 0
    var pcScore = 0

    println("--- DESAFIO: PEDRA, PAPEL E TESOURA. ---")
    println("Digite 'Sair' para encerrar")

    while (continuePlaying) {
        print("\nSua Jogada: ")
        val entrada = readln()

        if (entrada.lowercase() == "sair") {
            continuePlaying = false
        } else {
            // Tratamento da entrada
            val playerOption = entrada.lowercase().replaceFirstChar {it.uppercase()}

            // Validação
            if (playerOption !in options) {
                println("Jogada inválida! Tente: Pedra, Papel, Tesoura ou Sair.")
            } else {
                // Guardar na memória
                // Adiciona a escolha do jogador no histórico
                playerHistory.add(playerOption)

                //O Cérebro da IA
                val pcOption = if (playerHistory.size < 3) {
                    //Se tiver menos de 3 jogadas, ele ainda não tem dados suficientes
                    // Então joga aleatoriamente para sondar o Jogador
                    options.random()
                } else {
                    // Contamos o que você jogou mais até agora
                    val qtdPedra = playerHistory.count{ it == "Pedra" }
                    val qtdPapel = playerHistory.count{ it == "Papel" }
                    val qtdTesoura = playerHistory.count{ it == "Tesoura" }

                    println("\n(Oponente pensando: Você jogou Pedra $qtdPedra vezes, Papel $qtdPapel vezes, Tesoura $qtdTesoura vezes...)\n")

                    // Lógica de Contra-ataque
                    when {
                        (qtdPedra > qtdPapel && qtdPedra > qtdTesoura) -> {"Papel"}
                        (qtdPapel > qtdPedra && qtdPapel > qtdTesoura) -> {"Tesoura"}
                        (qtdTesoura > qtdPedra && qtdTesoura > qtdPapel) -> {"Pedra"}
                        else -> {options.random()}
                    }
                }

                println("A IA escolheu $pcOption 🤖")

                // Lógica de resultado
                when {
                    playerOption == pcOption -> {
                        println("Resultado: Empate!")
                    }
                    (playerOption == "Pedra" && pcOption == "Tesoura") ||
                    (playerOption == "Papel" && pcOption == "Pedra") ||
                    (playerOption == "Tesoura" && pcOption == "Papel") -> {
                        println("Parabéns, você venceu! 🎉")
                        playerScore++ // Atualiza o placar do Jogador
                    }
                    else -> {
                        println("Não foi dessa vez, a IA venceu. 🤖")
                        pcScore++ // Atualiza o placar da IA
                    }
                }
                println(">>> PLACAR ATUAL: Você $playerScore x $pcScore IA <<<")
            }
        }
    }
    // Pós-jogo: Resultado final
    println("\n=== FIM DE JOGO ===")
    println("Placar Final: Você $playerScore x $pcScore IA")

    // Lógica do grande campeão
    when {
        playerScore > pcScore -> println("🏆 Parabéns, você é o grande campeão!")
        playerScore < pcScore -> println("🤖 A IA levou a melhor hoje. Tente novamente!")
        else -> println("Foi uma disputa acirrada. Terminou empatado!")
    }
}