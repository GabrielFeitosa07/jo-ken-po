fun main () {

    val opcoes = listOf("Pedra", "Papel", "Tesoura", "Sair")
    var continuarJogando = true // Uma variável que controla se o jogo deve continuar

    // O PLACAR (Declarado fora do loop para não "zerar" a cada volta)
    var placarUsuario = 0
    var placarComputador = 0

    println("--- DESAFIO: PEDRA, PAPEL E TESOURA. ---")
    println("Digite 'Sair' para encerrar e ver o resultado final")

    while (continuarJogando) {
        print("\nSua Jogada: ")
        val entrada = readln()

        //Verificamos primeiro se o usuário quer sair
        if (entrada.lowercase() == "sair") {
            continuarJogando = false
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
                    placarUsuario++ // Atualiza o placar do Jogador

                } else {
                    println("Não foi dessa vez, o computador venceu. 🤖")
                    placarComputador++ // Atualiza o placar do Computador
                }

                //Mostra o placar atual
                println(">>> PLACAR ATUAL: Você $placarUsuario x $placarComputador Computador <<<")
            }
        }
    }

    // Mensagem final quando o jogador sai
    println("\n=== FIM DE JOGO ===")
    println("Placar Final: Você $placarUsuario x $placarComputador Computador")

    if (placarUsuario > placarComputador)
        println("Parabéns, você é o grande campeão! 🏆")
    else if (placarComputador > placarUsuario)
        println("O computador levou a melhor hoje. Tente novamente! 🤖")
    else
        println("Foi uma disputa acirrada. Terminou empatado!")
}