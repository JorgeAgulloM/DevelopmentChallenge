package com.softyorch.retosdeprogramacion.challenges

/*
 * Escribe un programa que muestre cómo transcurre un juego de tenis y quién lo ha ganado.
 * El programa recibirá una secuencia formada por "P1" (Player 1) o "P2" (Player 2), según quien
 * gane cada punto del juego.
 *
 * - Las puntuaciones de un juego son "Love" (cero), 15, 30, 40, "Deuce" (empate), ventaja.
 * - Ante la secuencia [P1, P1, P2, P2, P1, P2, P1, P1], el programa mostraría lo siguiente:
 *   15 - Love
 *   30 - Love
 *   30 - 15
 *   30 - 30
 *   40 - 30
 *   Deuce
 *   Ventaja P1
 *   Ha ganado el P1
 * - Si quieres, puedes controlar errores en la entrada de datos.
 * - Consulta las reglas del juego si tienes dudas sobre el sistema de puntos.
 */


fun tennisMatch() {

    var p1 = 0
    var p2 = 0

    while (true) {
        val set = (1..2).random() //Evito la entrada de datos
        if (set == 1)
            if (p1 == 3 && p2 == 4) p2-- else p1++
         else
            if (p1 == 4 && p2 == 3) p1-- else p2++

        if (p1 == 5 || p2 == 5) {
            println("Ha ganado el ${upperPlayer(p1, p2)}")
            return
        } else if (p1 == 4 || p2 == 4)
            println("Ventaja para ${upperPlayer(p1, p2)}")
        else
            if (p1 == 3 && p2 == 3)
                println("Deuce")
            else
                println("${values.elementAt(p1)} - ${values.elementAt(p2)}")

    }

}

fun upperPlayer(p1: Int, p2: Int) = if (p1 > p2) "P1" else "P2"

val values = arrayListOf("Love", "15", "30", "40")