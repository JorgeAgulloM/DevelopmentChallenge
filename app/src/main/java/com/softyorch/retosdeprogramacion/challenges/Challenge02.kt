package com.softyorch.retosdeprogramacion.challenges

import java.util.Locale

/*
 * Escribe un programa que reciba un texto y transforme lenguaje natural a
 * "lenguaje hacker" (conocido realmente como "leet" o "1337"). Este lenguaje
 *  se caracteriza por sustituir caracteres alfanuméricos.
 * - Utiliza esta tabla (https://www.gamehouse.com/blog/leet-speak-cheat-sheet/)
 *   con el alfabeto y los números en "leet".
 *   (Usa la primera opción de cada transformación. Por ejemplo "4" para la "a")
 */

fun theHackerLanguage(text: String) {
    var textResult = ""
    text.forEach { char ->
        textResult += if (char.isDigit()) {
            searchNumber(char)
        } else if (char.isLetter()) {
            searchChar(char)
        } else {
            char
        }
    }
    printSolution("Texto original: $text")
    printSolution("Transformación a leet: $textResult")
}

private fun searchNumber(char: Char): String = leetNumbers.elementAt(numbers.indexOf(char.toString().uppercase(Locale.ROOT)))

private fun searchChar(char: Char): String = leetAlphabet.elementAt(alphabet.indexOf(char.lowercase(Locale.ROOT)))

private fun printSolution(value: String) = println(value)

private val alphabet = arrayListOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "á", "é", "í", "ó", "ú")

private val leetAlphabet = arrayListOf("4", "I3", "[", ")", "3", "|=", "&", "#", "1", ",_l", ">|", "1", """/\/\""", "^/", "0", "|*", "(_,)", "I2", "5", "7", "(_)", """\/""", """\/\/""", "><", "j", "2", "4", "3", "1", "0", "(_)")

private val numbers = arrayListOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "0")

private val leetNumbers = arrayListOf("L", "R", "E", "A", "S", "b", "T", "B", "g", "o")