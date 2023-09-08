package com.softyorch.retosdeprogramacion.challenges

import kotlin.math.pow

/*
 * Crea una función que calcule el número de la columna de una hoja de Excel
 * teniendo en cuenta su nombre.
 * - Las columnas se designan por letras de la "A" a la "Z" de forma infinita.
 * - Ejemplos: A = 1, Z = 26, AA = 27, CA = 79.
 */

fun excelNumbNameOfColumn() {
    val name = "EXCEL"
    println("Challenge32. Número de colunma de Excel equivalente a su nombre ")
    println("El número que corresponde a la combinación de columna $name es: ${numberOfNameColumnInExcel(name)}")
}

private fun numberOfNameColumnInExcel(name: String): Int {
    var value = 0
    name.reversed().lowercase().forEachIndexed { index, c ->
        val valueChar = abc.indexOf(c) + 1
        val pow = 26.0.pow(index.toDouble()).toInt()
        value += valueChar * pow
    }
    return value
}

private val abc = ('a'..'z').toList().toTypedArray()