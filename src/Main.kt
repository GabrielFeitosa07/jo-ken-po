import kotlin.text.compareTo

fun main() {
    println("\n=================================")
    println("   PEDRA, PAPEL E TESOURA PRO    ")
    println("=================================")
    println("1. Jogar contra o Computador (Single Player)")
    println("2. Jogar Multiplayer (2 Jogadores)")
    println("3. Sair")
    print("Escolha uma opção: ")

    when (readln().trim()) {
        "1" -> setDifficulty()
        "2" -> multiplayer()
        "3" -> {
            println("Saindo... Até mais!")
            return
        }
        else -> println("Opção inválida!")
    }
}
// difficult levels
fun setDifficulty() {
    println("\n--- ESCOLHA A DIFICULDADE ---")
    println("1. Fácil (Computador aleatório)")
    println("2. Médio (Computador erra as vezes)")
    println("3. Difícil (IA com memória)")
    print("Opção: ")

    val difficulty = when (readln().trim()) {
        "1" -> "Fácil"
        "2" -> "Médio"
        "3" -> "Difícil"
        else -> "Difícil"
    }
    println("Iniciando modo Single Player no nível: $difficulty")
    singlePlayer(difficulty)
}
// Player Vs Machine
fun singlePlayer(difficulty: String) {
    val options = listOf("Pedra", "Papel", "Tesoura")
    val p1History = mutableListOf<String>()
    var continuePlaying = true
    var p1Score = 0
    var pcScore = 0

    println("Digite 'Sair' para encerrar")

    while (continuePlaying) {
        print("\nSua Jogada: ")
        val entrada = readln().trim()

        if (entrada.lowercase() == "sair") {
            continuePlaying = false
        } else {
            val p1Option = entrada.lowercase().replaceFirstChar { it.uppercase() }

            if (p1Option !in options) {
                println("Jogada inválida! Tente: Pedra, Papel, Tesoura ou Sair.")
            } else {
                p1History.add(p1Option)

                val pcOption = pcChoice(p1History, difficulty)

                println("O Computador escolheu $pcOption 🤖")

                when {
                    p1Option == pcOption -> println("Resultado: Empate!")
                    p1Option == "Pedra" && pcOption == "Tesoura" ||
                    p1Option == "Papel" && pcOption == "Pedra" ||
                    p1Option == "Tesoura" && pcOption == "Papel" -> {
                        println("🎉 Parabéns, você venceu!")
                        p1Score++
                    }
                    else -> {
                        println("🤖 Não foi dessa vez, o Computador venceu.")
                        pcScore++
                    }
                }
                println(">>> PLACAR ATUAL: Você $p1Score x $pcScore Computador <<<")
            }
        }
    }
    println("\n=== FIM DE JOGO ===")
    println("Placar Final: Você $p1Score x $pcScore Computador")

    when {
        p1Score > pcScore -> println("🏆 Parabéns, você é o grande campeão!")
        p1Score < pcScore -> println("🤖 O Computador levou a melhor hoje. Tente novamente!")
        else -> println("🤝 Foi uma disputa acirrada. Terminou empatado!")
    }
}
// multiplayer mode
fun multiplayer() {
    val options = listOf("Pedra", "Papel", "Tesoura")
    var p1Score = 0
    var p2Score = 0

    println("Digite 'Sair' para encerrar: ")

    while (true) {
        println("JOGADOR 1: ")
        val p1 = readln().lowercase().replaceFirstChar { it.uppercase() }
        if (p1 == "Sair") {
            break
        }

        repeat (50) {println("\n")}

        println("JOGADOR 2: ")
        val p2 = readln().lowercase().replaceFirstChar { it.uppercase() }
        if (p2 == "Sair") {
            break
        }

        println("P1 $p1 VS $p2 P2")

        when {
            p1 == p2 -> println("Empate!")
            p1 == "Pedra" && p2 == "Tesoura" ||
            p1 == "Papel" && p2 == "Pedra" ||
            p1 == "Tesoura" && p2 == "Papel" -> {
                println("Jogador 1 venceu!")
                p1Score++
            }

            else -> {
                println("Jogador 2 venceu!")
                p2Score++
            }
        }
        println("PLACAR ATUAL: (Jogador01) $p1Score x $p2Score (Jogador02)")
    }
    println("==== FIM DE JOGO ====")
    println("PLACAR FINAL: Jogador 1 $p1Score x $p2Score Jogador 2")

    when {
        p1Score > p2Score -> println("\n🏆Parabéns Jogador 1, você é o grande campeão!\n")
        p1Score < p2Score -> println("\n🏆Parabéns Jogador 2, você é o grande campeão!\n")
        else -> { println("\n🤝 Foi uma disputa acirrada. Terminou empatado!\n") }
    }
}
//opponent's choice
fun pcChoice(p1History: List<String>, difficulty: String): String {
    val options = listOf("Pedra", "Papel", "Tesoura")

    return when (difficulty) {
        "Fácil" -> options.random()
        "Médio" -> {
            if ((1..10).random() > 5) {
            pcBestPlay(p1History)
            } else {
                options.random()
            }
        }
        "Difícil" -> pcBestPlay(p1History)
        else -> options.random()
    }
}
// memory and statistical analysis  (Difficult mode)
fun pcBestPlay(p1History: List<String>): String {
    val options = listOf("Pedra", "Papel", "Tesoura")

    if (p1History.size < 3) return options.random()

    val qtdPedra = p1History.count { it == "Pedra" }
    val qtdPapel = p1History.count { it == "Papel" }
    val qtdTesoura = p1History.count { it == "Tesoura" }

    return when {
         (qtdPedra > qtdPapel && qtdPedra > qtdTesoura) -> { "Papel" }
         (qtdPapel > qtdPedra && qtdPapel > qtdTesoura) -> { "Tesoura" }
         (qtdTesoura > qtdPedra && qtdTesoura > qtdPapel) -> { "Pedra" }
         else -> options.random()
    }
}

