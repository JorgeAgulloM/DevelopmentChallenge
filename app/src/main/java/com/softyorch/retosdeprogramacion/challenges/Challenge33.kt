package com.softyorch.retosdeprogramacion.challenges

/*
 * Crea un programa capaz de gestionar una pieza de Tetris.
 * - La pantalla de juego tiene 10 filas y 10 columnas representadas por símbolos 🔲
 * - La pieza de tetris a manejar será la siguiente (si quieres, puedes elegir otra):
 *   🔳
 *   🔳🔳🔳
 * - La pieza aparecerá por primera vez en la parte superior izquierda de la pantalla de juego.
 *   🔳🔲🔲🔲🔲🔲🔲🔲🔲🔲
 *   🔳🔳🔳🔲🔲🔲🔲🔲🔲🔲
 *   🔲🔲🔲🔲🔲🔲🔲🔲🔲🔲
 *   🔲🔲🔲🔲🔲🔲🔲🔲🔲🔲
 *   🔲🔲🔲🔲🔲🔲🔲🔲🔲🔲
 *   🔲🔲🔲🔲🔲🔲🔲🔲🔲🔲
 *   🔲🔲🔲🔲🔲🔲🔲🔲🔲🔲
 *   🔲🔲🔲🔲🔲🔲🔲🔲🔲🔲
 *   🔲🔲🔲🔲🔲🔲🔲🔲🔲🔲
 *   🔲🔲🔲🔲🔲🔲🔲🔲🔲🔲
 *
 *   🔲🔳🔳🔲🔲🔲🔲🔲🔲🔲
 *   🔲🔳🔲🔲🔲🔲🔲🔲🔲🔲
 *   🔲🔳🔲🔲🔲🔲🔲🔲🔲🔲
 *   🔲🔲🔲🔲🔲🔲🔲🔲🔲🔲
 *   🔲🔲🔲🔲🔲🔲🔲🔲🔲🔲
 *   🔲🔲🔲🔲🔲🔲🔲🔲🔲🔲
 *   🔲🔲🔲🔲🔲🔲🔲🔲🔲🔲
 *   🔲🔲🔲🔲🔲🔲🔲🔲🔲🔲
 *   🔲🔲🔲🔲🔲🔲🔲🔲🔲🔲
 *   🔲🔲🔲🔲🔲🔲🔲🔲🔲🔲
 * - Debes desarrollar una función capaz de desplazar y rotar la pieza en el tablero,
 *   recibiendo una acción cada vez que se llame, mostrando cómo se visualiza en la pantalla de juego.
 * - Las acciones que se pueden aplicar a la pieza son: derecha, izquierda, abajo, rotar.
 * - Debes tener en cuenta los límites de la pantalla de juego.
 */

fun tetrisGame() {
    println("Challenge33. Tetris")
    println("Tus controles son $KEY_CONTROLS")
    println("La pieza bajará con cada movimiento que realices")
    println("El juego termina una vez que la pieza llega abajo del todo")
    updateDisplay()
    start()
    println("¡Gracias por jugar!")

}

private fun start() {
    var endGame = false
    while (!endGame) {
        println("Selecciona un control y pulsa Intro: $KEY_CONTROLS")

        val control = readln()
        val move = userControl(control)
        if (move.msg != null) {
            println(move.msg)
            continue
        }
        val isLimit = movePiece(move)

        endGame = isLimit.endGame
        println(isLimit.msg)
        updateDisplay()
    }
}

private fun updateDisplay() {
    checkPiece()
    showDisplay()
}

private fun userControl(control: String): Move = when (control) {
    controls[0] -> Move.Left
    controls[1] -> Move.Down
    controls[2] -> Move.Right
    controls[3] -> Move.Rotate
    else -> Move.Error
}

private fun movePiece(move: Move): DisplayLimits {
    return when (val limit = displayLimits(move)) {
        DisplayLimits.Rotate -> {
            updatePieceRotation()
            displayLimits(Move.Down)
        }
        DisplayLimits.Ok -> updatePiecePosition(move).let { limit }
        DisplayLimits.Down -> updatePiecePosition(move).let { limit }
        else -> limit
    }
}

private fun updatePiecePosition(move: Move) {
    val newPiece = arrayListOf<Pair<Int, Int>>()
    piece.forEach { p ->
        val y = p.first + move.move.first
        val x = p.second + move.move.second
        newPiece.add(Pair(y, x))
    }
    piece = newPiece
}

private fun updatePieceRotation() {
    rotationsState = when (rotationsState) {
        Rotation.First -> rotatePiece(Rotation.Second).let { Rotation.Second }
        Rotation.Second -> rotatePiece(Rotation.Third).let { Rotation.Third }
        Rotation.Third -> rotatePiece(Rotation.Fourth).let { Rotation.Fourth }
        Rotation.Fourth -> rotatePiece(Rotation.First).let { Rotation.First }
    }
}

private fun rotatePiece(rotation: Rotation) {
    val newPiece = arrayListOf<Pair<Int, Int>>()

    piece.forEachIndexed { i, p ->
        val y = p.first + rotation.dataRotate[i].first
        val x = p.second + rotation.dataRotate[i].second
        newPiece.add(Pair(y, x))
    }
    piece = newPiece
}

private fun displayLimits(move: Move): DisplayLimits {
    val limitLeft = 0
    val limitRight = controlDisplay[0].size - 1
    val limitDown = controlDisplay.size - 1

    piece.forEachIndexed { _, point ->
        if (point.second == limitLeft && move == Move.Left)
            return DisplayLimits.Left
        else if (point.second == limitRight && move == Move.Right)
            return DisplayLimits.Right
        else if (point.first + 1 == limitDown)
            return DisplayLimits.Down
        else if (move == Move.Rotate) return DisplayLimits.Rotate
    }

    return DisplayLimits.Ok
}

private fun checkPiece() {
    resetDisplay()
    piece.forEach { p ->
        controlDisplay[p.first][p.second] = true
    }
}

private fun resetDisplay() {
    controlDisplay.forEachIndexed { _, line ->
        line.forEachIndexed { indexPoint, _ ->
            line[indexPoint] = false
        }
    }
}

private fun showDisplay() {
    controlDisplay.forEach { l ->
        var line = ""
        l.forEach { p ->
            line += if (p) EMPTY_PIECE else FULL_PIECE
        }
        println(line)
    }
}

private const val KEY_CONTROLS = "(<- a) (↓ s) (d ->) (r ↺)"
private var rotationsState: Rotation = Rotation.First
private val controls = arrayListOf("a", "s", "d", "r")
private const val EMPTY_PIECE = "\uD83D\uDD33"
private const val FULL_PIECE = "\uD83D\uDD32"
private var piece = arrayListOf(Pair(0, 0), Pair(1, 0), Pair(1, 1), Pair(1, 2))
private val controlDisplay = arrayListOf(
    arrayListOf(false, false, false, false, false, false, false, false, false, false),
    arrayListOf(false, false, false, false, false, false, false, false, false, false),
    arrayListOf(false, false, false, false, false, false, false, false, false, false),
    arrayListOf(false, false, false, false, false, false, false, false, false, false),
    arrayListOf(false, false, false, false, false, false, false, false, false, false),
    arrayListOf(false, false, false, false, false, false, false, false, false, false),
    arrayListOf(false, false, false, false, false, false, false, false, false, false),
    arrayListOf(false, false, false, false, false, false, false, false, false, false),
    arrayListOf(false, false, false, false, false, false, false, false, false, false),
    arrayListOf(false, false, false, false, false, false, false, false, false, false)
)

sealed class Move(val move: Pair<Int, Int>, val msg: String? = null) {
    data object Left : Move(move = Pair(0, -1))
    data object Right : Move(move = Pair(0, 1))
    data object Down : Move(move = Pair(1, 0))
    data object Rotate : Move(move = Pair(0, 0))
    data object Error : Move(move = Pair(0, 0), msg = "ERROR: El control seleccionado no existe!!")
}

sealed class Rotation(val dataRotate: ArrayList<Pair<Int, Int>>) {
    data object First :
        Rotation(dataRotate = arrayListOf(Pair(-2, 0), Pair(-1, -1), Pair(0, 0), Pair(1, 1)))

    data object Second :
        Rotation(dataRotate = arrayListOf(Pair(0, 2), Pair(-1, 1), Pair(0, 0), Pair(1, -1)))

    data object Third :
        Rotation(dataRotate = arrayListOf(Pair(2, 0), Pair(1, 1), Pair(0, 0), Pair(-1, -1)))

    data object Fourth :
        Rotation(dataRotate = arrayListOf(Pair(0, -2), Pair(1, -1), Pair(0, 0), Pair(-1, 1)))
}

sealed class DisplayLimits(val msg: String, val endGame: Boolean) {
    data object Rotate : DisplayLimits(msg = "Rotando", endGame = false)
    data object Ok : DisplayLimits(msg = "Mueve otra vez", endGame = false)
    data object Left : DisplayLimits(msg = "No puedes mover más a la izquierda", endGame = false)
    data object Right : DisplayLimits(msg = "No puedes mover más a la derecha", endGame = false)
    data object Down : DisplayLimits(msg = "¡Fin del Juego!", endGame = true)
}
