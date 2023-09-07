package com.softyorch.retosdeprogramacion.challenges

/*
 * Crea un programa que realize el cifrado César de un texto y lo imprima.
 * También debe ser capaz de descifrarlo cuando así se lo indiquemos.
 *
 * Te recomiendo que busques información para conocer en profundidad cómo
 * realizar el cifrado. Esto también forma parte del reto.
 */

private val abc = ('a'..'z').toList().toTypedArray()
private const val CAESAR_CODE = 4

fun caesarEncryption() {
    val text = "Hola, soy jorge y soy desarrollador Android nativo."
    //val text = "abcdefghijklmnopqrstuvwxyz"

    val encrypted = abcToCaesar(text, true)
    println("Texto encriptado: $encrypted")

    val decrypted = abcToCaesar(encrypted)
    println("Texto desencriptado: $decrypted")
}

private fun abcToCaesar(text: String, isEncrypt: Boolean = false): String {
    var textEncrypted = ""

    text.lowercase().forEachIndexed { _, char ->

        if (char.isLetter()) {
            var index = abc.indexOf(char)

            index = if (isEncrypt) encrypt(index) - 1 else decrypt(index + 1)

            textEncrypted += abc[index]
        } else {
            textEncrypted += char
        }

    }
    return textEncrypted
}

private fun encrypt(index: Int) = if (index + CAESAR_CODE > (abc.size))
    (index + CAESAR_CODE) - (abc.size)
else
    index + CAESAR_CODE

private fun decrypt(index: Int) = if (index - CAESAR_CODE < 0)
    abc.size + (index - CAESAR_CODE)
else
    index - CAESAR_CODE
