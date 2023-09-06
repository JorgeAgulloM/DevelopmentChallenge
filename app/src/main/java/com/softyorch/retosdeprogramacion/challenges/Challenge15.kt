package com.softyorch.retosdeprogramacion.challenges

/*
 * Crea una función que reciba un número decimal y lo trasforme a Octal
 * y Hexadecimal.
 * - No está permitido usar funciones propias del lenguaje de programación que
 * realicen esas operaciones directamente.
 */

fun octalAndHexadecimalConverter() {
    val dec = 500

    val octal = octalConverter(dec)
    println("Octal: $octal")

    val hexadecimal = hexadecimalConverter(dec)
    println("Hexadecimal: $hexadecimal")

    val binary = binaryConverter(dec)
    println("Binary: $binary")
}

private fun octalConverter(dec: Int) =
    calculate(dec, 8).replace(".", "").reversed().toInt()

private fun hexadecimalConverter(dec: Int): String {
    val hexaCollection = arrayListOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F")
    var rest = calculate(dec, 16)
    var result = ""
    val count = rest.count { char -> char.toString() == "."}

    for (i in 0..<count) {
        val numb = rest.split(".")[0]
        rest = rest.substringAfter("$numb.")
        result += hexaCollection[numb.toInt()]
    }

    return result.reversed()
}

private fun binaryConverter(dec: Int) =
    calculate(dec, 2).replace(".", "").reversed()

private fun calculate(dec: Int, divider: Int): String {
    var dividend = dec
    var buffer = ""

    while (true) {
        buffer += "${dividend % divider}."
        val result = dividend / divider
        dividend = result
        if (result < divider) {
            buffer += "${dividend % divider}."
            break
        }
    }

    return buffer
}