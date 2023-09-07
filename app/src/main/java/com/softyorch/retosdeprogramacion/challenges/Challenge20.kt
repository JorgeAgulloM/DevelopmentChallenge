package com.softyorch.retosdeprogramacion.challenges

/*
 *	¡El nuevo "The Legend of Zelda: Tears of the Kingdom" ya está disponible!
 *
 * Crea un programa que dibuje una Trifuerza de "Zelda"
 * formada por asteriscos.
 * - Debes indicarle el número de filas de los triángulos con un entero positivo (n).
 * - Cada triángulo calculará su fila mayor utilizando la fórmula 2n-1.
 *
 * Ejemplo: Trifuerza 2
 *
 *    *
 *   ***
 *  *   *
 * *** ***
 *
 */

/** Result
 *          *
 *         ***
 *        *   *
 *       *** ***
 *      *   *   *
 *     *** *** ***
 *    *   *   *   *
 *   *** *** *** ***
 *  *   *   *   *   *
 * *** *** *** *** ***
 */


fun zeldaTriforce() {
    triforce(5).map {
        println(it)
    }
}

private fun triforce(n: Int): ArrayList<String> {
    val triforces = arrayListOf<String>()
    val space = " "
    val symbol = "*"
    val groupPair = "$symbol$symbol$symbol"
    val groupOdd = "$space$symbol$space"

    //Linea
    for (t in 0..<n) {
        var firstSpace = ""

        for (i in 0..<triforces.size) {
            firstSpace += space
        }

        //Gropo por linea
        for (l in 0..1){
            var result = ""
            for (i in 0..<(n - t)) {
                result += if (l == 0) {
                    if (i == 0)
                        "$firstSpace$groupPair"
                    else
                        "$space$groupPair"
                } else {
                    if (i == 0)
                        "$firstSpace$groupOdd"
                    else
                        "$space$groupOdd"
                }
            }
            triforces.add(0, result)
        }
    }
    return triforces
}