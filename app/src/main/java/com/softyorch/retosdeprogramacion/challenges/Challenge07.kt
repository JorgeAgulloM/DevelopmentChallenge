package com.softyorch.retosdeprogramacion.challenges

/*
 * Crea un programa que calcule quien gana más partidas al piedra,
 * papel, tijera, lagarto, spock.
 * - El resultado puede ser: "Player 1", "Player 2", "Tie" (empate)
 * - La función recibe un listado que contiene pares, representando cada jugada.
 * - El par puede contener combinaciones de "🗿" (piedra), "📄" (papel),
 *   "✂️" (tijera), "🦎" (lagarto) o "🖖" (spock).
 * - Ejemplo. Entrada: [("🗿","✂️"), ("✂️","🗿"), ("📄","✂️")]. Resultado: "Player 2".
 * - Debes buscar información sobre cómo se juega con estas 5 posibilidades.
 */

fun rocPaperScissorsLizardSpock() {
    var pointsP1 = 0
    var pointsP2 = 0
    while (pointsP1 < 2 && pointsP2 < 2) {
        val moveP1 = moves.elementAt((0..<moves.size).random())
        val moveP2 = moves.elementAt((0..<moves.size).random())

        val winner = possibleResults[playerWin(moveP1, moveP2)]
        if (winner == possibleResults[1])
            pointsP1++
        else if (winner == possibleResults[2])
            pointsP2++

        println(winner)

        val haveWinner = haveWinner(pointsP1, pointsP2)
        if (haveWinner > 0) {
            println("The winner is: ${possibleResults[haveWinner]}")
            return
        }
    }
}

private fun playerWin(moveP1: String, moveP2: String): Int {
    if (moveP1 == moveP2) return 0
    return when (moveP1) {
        "🗿" -> if (moveP2 in winRock) 2 else 1
        "📄" -> if (moveP2 in winPaper) 2 else 1
        "✂️" -> if (moveP2 in winScissors) 2 else 1
        "🦎" -> if (moveP2 in winLizard) 2 else 1
        "🖖" -> if (moveP2 in winSpock) 2 else 1
        else -> 0
    }
}

private fun haveWinner(player1: Int, player2: Int): Int =
    if (player1 >= 2) 1 else if (player2 >= 2) 2 else 0

private val moves = arrayListOf("🗿", "📄", "✂️", "🦎", "🖖")
private val winRock = arrayListOf("✂️", "🦎")
private val winPaper = arrayListOf("🗿", "🖖")
private val winScissors = arrayListOf("📄", "🦎")
private val winLizard = arrayListOf("🖖", "📄")
private val winSpock = arrayListOf("✂️", "🗿")
private val possibleResults = arrayListOf("Tie", "Player 1", "Player 2")