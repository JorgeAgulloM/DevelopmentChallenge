package com.softyorch.retosdeprogramacion.challenges

/*
 * Crea una función que reciba dos cadenas de texto casi iguales,
 * a excepción de uno o varios caracteres.
 * La función debe encontrarlos y retornarlos en formato lista/array.
 * - Ambas cadenas de texto deben ser iguales en longitud.
 * - Las cadenas de texto son iguales elemento a elemento.
 * - No se pueden utilizar operaciones propias del lenguaje
 *   que lo resuelvan directamente.
 *
 * Ejemplos:
 * - Me llamo mouredev / Me llemo mouredov -> ["e", "o"]
 * - Me llamo.Brais Moure / Me llamo brais moure -> [" ", "b", "m"]
 */

fun equalStrings() {
    val correctString = "Hola, me llamo Jorge"
    val sabotageString = "Holi. ma Llamo Yorgi"
    println(searchCharInsider(correctString, sabotageString))
}

private fun searchCharInsider(stringOne: String, stringTwo: String): String {
    val charInsiders = arrayListOf<String>()

    stringTwo.forEachIndexed { i, char ->
        if (stringOne[i] != char) {
            charInsiders.add(char.toString())
        }
    }

    return "$stringOne / $stringTwo -> $charInsiders"
}