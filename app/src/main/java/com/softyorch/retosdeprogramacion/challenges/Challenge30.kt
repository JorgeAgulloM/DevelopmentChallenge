package com.softyorch.retosdeprogramacion.challenges

/*
 * Los primeros dispositivos móviles tenían un teclado llamado T9
 * con el que se podía escribir texto utilizando únicamente su
 * teclado numérico (del 0 al 9).
 *
 * Crea una función que transforme las pulsaciones del T9 a su
 * representación con letras.
 * - Debes buscar cuál era su correspondencia original.
 * - Cada bloque de pulsaciones va separado por un guión.
 * - Si un bloque tiene más de un número, debe ser siempre el mismo.
 * - Ejemplo:
 *     Entrada: 6-666-88-777-33-3-33-888
 *     Salida: MOUREDEV
 */

fun t9Keyboard() {
    val blocks = "6-666-88-777-33-3-33-888"
    print(translateToT9(blocks))
}

private fun translateToT9(blocks: String): String {
    val isCorrect = isTheFormatCorrect(blocks)
    if (!isCorrect.first) return isCorrect.second

    val arrayIntBlocks = arrayListOf<Int>()
    val arrayStringBlocks = blocks.split("-")
    arrayStringBlocks.forEach { block ->
        if (block.length > 1) {
            if (block.count { it == block[0] } == block.length) {
                arrayIntBlocks.add(block.toInt())
            } else {
                return "Error: Los bloques de números deben contener el mismo número."
            }
        } else {
            arrayIntBlocks.add(block.toInt())
        }
    }

    var result = ""
    arrayIntBlocks.forEach { result += t9[it] }

    return result
}

private fun isTheFormatCorrect(blocks: String): Pair<Boolean, String> {
    val regex = """^[1-9\-]+$""".toRegex()

    if (!blocks.matches(regex))
        return Pair(
            false,
            "Error: Has introducido caracteres no validos. Solo puedes usar números en bloque separados por -"
        )

    if (blocks[0].toString() == "-" || blocks[blocks.length - 1].toString() == "")
        return Pair(false, "Error: El conjunto debe comenzar y terminar por números.")

    return Pair(true, "")
}

private val t9 = mapOf(
    2 to "A",
    22 to "B",
    222 to "C",
    3 to "D",
    33 to "E",
    333 to "F",
    4 to "G",
    44 to "H",
    444 to "I",
    5 to "J",
    55 to "K",
    555 to "L",
    6 to "M",
    66 to "N",
    666 to "O",
    7 to "P",
    77 to "Q",
    777 to "R",
    7777 to "S",
    8 to "T",
    88 to "U",
    888 to "V",
    9 to "W",
    99 to "X",
    999 to "Y",
    9999 to "Z"
)
