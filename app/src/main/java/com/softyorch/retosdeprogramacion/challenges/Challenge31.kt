package com.softyorch.retosdeprogramacion.challenges

/*
 * Crea una función que sea capaz de leer el número representado por el ábaco.
 * - El ábaco se representa por un array con 7 elementos.
 * - Cada elemento tendrá 9 "O" (aunque habitualmente tiene 10 para realizar
 *   operaciones) para las cuentas y una secuencia de "---" para el alambre.
 * - El primer elemento del array representa los millones, y el último las unidades.
 * - El número en cada elemento se representa por las cuentas que están a
 *   la izquierda del alambre.
 *
 * Ejemplo de array y resultado:
 * ["O---OOOOOOOO",
 *  "OOO---OOOOOO",
 *  "---OOOOOOOOO",
 *  "OO---OOOOOOO",
 *  "OOOOOOO---OO",
 *  "OOOOOOOOO---",
 *  "---OOOOOOOOO"]
 *
 *  Resultado: 1.302.790
 */

fun abacusReader() {
    println("Challenge 31. El ábaco")
    println("El número representado en el siguiente ábaco es: ${reader(abacus)}")
    println()
    abacus.forEach { n ->
        println(n)
    }
}

private fun reader(abacus: ArrayList<String>): Int {
    var abacusValue = ""

    abacus.forEach { line ->
        abacusValue += abacusLine(line)
    }

    return abacusValue.toInt()
}

private fun abacusLine(line: String): String {
    if (line[0].toString() == "0") return "0"
    if (line[line.length -1].toString() == "-") return "9"
    return line.split("---")[0].length.toString()
}

// Resultado: 1.302.790
private val abacus = arrayListOf(
    "O---OOOOOOOO",
    "OOO---OOOOOO",
    "---OOOOOOOOO",
    "OO---OOOOOOO",
    "OOOOOOO---OO",
    "OOOOOOOOO---",
    "---OOOOOOOOO"
)