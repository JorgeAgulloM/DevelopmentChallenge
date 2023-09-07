package com.softyorch.retosdeprogramacion.challenges

/*
 * Crea una función que dibuje una espiral como la del ejemplo.
 * - Únicamente se indica de forma dinámica el tamaño del lado.
 * - Símbolos permitidos: ═ ║ ╗ ╔ ╝ ╚
 *
 * Ejemplo espiral de lado 5 (5 filas y 5 columnas):
 * ════╗
 * ╔══╗║
 * ║╔╗║║
 * ║╚═╝║
 * ╚═══╝
 */

private const val HORIZONTAL = "═"
private const val VERTICAL = "║"
private const val CORNER_UP_R = "╗"
private const val CORNER_UP_L = "╔"
private const val CORNER_DOWN_R = "╝"
private const val CORNER_DOWN_L = "╚"

private enum class Directions { RIGHT, DOWN, LEFT, UP }

fun spiral() {
    createSpiral(10)
}

private fun createSpiral(turns: Int) {
    val spiral = arrayListOf<ArrayList<String>>()

    for (y in 0..<turns) {
        val line = arrayListOf<String>()
        for (x in 0..<turns) {
            line.add(" ")
        }
        spiral.add(line)
    }

    //    0   1   2   3   4  x
    // 0{"", "", "", "", ""}
    // 1{"", "", "", "", ""}
    // 2{"", "", "", "", ""}
    // 3{"", "", "", "", ""}
    // 4{"", "", "", "", ""}
    // y

    var x = 0
    var y = 0
    var maxX = turns - 1
    var maxY = turns - 1
    var minX = 0
    var minY = 0
    var direction = Directions.RIGHT

    val countRedux = spiral[0].size * spiral.size
    for (p in 0..<countRedux) {
        if (p == 0) {
            spiral[0][0] = HORIZONTAL
            continue
        }

        when (direction) {
            Directions.RIGHT -> x++
            Directions.DOWN -> y++
            Directions.LEFT -> x--
            Directions.UP -> y--
        }

        when (direction) {
            Directions.RIGHT -> spiral[y][x] = if (x == maxX) CORNER_UP_R else HORIZONTAL
            Directions.DOWN -> spiral[y][x] = if (y == maxY) CORNER_DOWN_R else VERTICAL
            Directions.LEFT -> spiral[y][x] = if (x == minX) CORNER_DOWN_L else HORIZONTAL
            Directions.UP -> spiral[y][x] = if (y == minY) CORNER_UP_L else VERTICAL
        }

        direction = if (x == maxX && y == minY && direction == Directions.RIGHT)
            Directions.DOWN
        else if (x == maxX && y == maxY && direction == Directions.DOWN)
            Directions.LEFT
        else if (x == minX && y == maxY && direction == Directions.LEFT) {
            maxY--
            minY++
            Directions.UP
        } else if (x == minX && y == minY && direction == Directions.UP) {
            maxX--
            minX++
            Directions.RIGHT
        } else
            continue

    }

    for (a in 0..<turns) {
        var line = ""
        for (b in 0..<turns) {
            line += spiral[a][b]
        }
        println(line)
    }

}
