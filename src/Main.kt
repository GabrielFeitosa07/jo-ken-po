fun main () {
    val opcoes = listOf("Pedra", "Papel", "Tesoura")

    println("--- Jogo Iniciado ---")
    println("Digite a sua escolha")

    //Lendo a entrada do usuário
    val jogadaUsuario = readln().replaceFirstChar { it.uppercase() } // Ajusta para letra inicial maiúscula

    println("Usuário escolheu: $jogadaUsuario")

    //O Computador escolhe um item aleatório da lista
    val jogadaComputador = opcoes.random()

    println("Computador escolheu: $jogadaComputador")

    //Lógica de resultado (Apenas um rascunho por enquanto)
    if (jogadaUsuario == jogadaComputador) {
        println("Empate!")
    } else {
        println("Ainda vamos definir quem ganhou...")
    }
}