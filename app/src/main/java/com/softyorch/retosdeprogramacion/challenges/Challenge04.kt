package com.softyorch.retosdeprogramacion.challenges

/*
 * Escribe un programa que sea capaz de generar contraseñas de forma aleatoria.
 * Podrás configurar generar contraseñas con los siguientes parámetros:
 * - Longitud: Entre 8 y 16.
 * - Con o sin letras mayúsculas.
 * - Con o sin números.
 * - Con o sin símbolos.
 * (Pudiendo combinar todos estos parámetros entre ellos)
 */


fun passGenerator() {
    var passResult = ""
    val longPass = (8..16).random()

    for (char in 0..longPass) {
        passResult += nextChar()
    }
    println("Pass result: $passResult")
}

fun nextChar(): String {
    val possibilities = arrayListOf(alphabetLowerCase, symbols, numbersPass)

    possibilities.let { arrayList ->
        arrayList.elementAt((1..arrayList.size).random() - 1).let { array ->
            val char = array.elementAt((1..array.size).random() - 1).toString()
            val upperCase = (0..1).random()
            return if (array == alphabetLowerCase && upperCase == 1) char.uppercase() else char
        }
    }
}




private val alphabetLowerCase = arrayListOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z")
private val symbols = arrayListOf('.', ',', '!', '?', ':', ';', '(', ')', '@', '#')
private val numbersPass = arrayListOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "0")

