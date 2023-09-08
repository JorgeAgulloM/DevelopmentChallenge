package com.softyorch.retosdeprogramacion.challenges

/*
 * Crea una función que reciba una expresión matemática (String)
 * y compruebe si es correcta. Retornará true o false.
 * - Para que una expresión matemática sea correcta debe poseer
 *   un número, una operación y otro número separados por espacios.
 *   Tantos números y operaciones como queramos.
 * - Números positivos, negativos, enteros o decimales.
 * - Operaciones soportadas: + - * / %
 *
 * Ejemplos:
 * "5 + 6 / 7 - 4" -> true
 * "5 a 6" -> false
 */

fun mathExpression() {
    println(isExpression("5 + 6 / 7 - 4"))
}

private fun isExpression(expression: String): Boolean {
    val operators = arrayListOf("+", "-", "*", "/", "%")
    var numbOrOperator = NumbOrOperator.OPERATOR
    expression.forEachIndexed { i, char ->
        if (i == 0) if (char.toString() == " ") return false else return@forEachIndexed

        if (i % 2 == 0) {
            numbOrOperator = when (numbOrOperator) {
                NumbOrOperator.NUMB -> {
                    if (!char.isDigit()) return false
                    NumbOrOperator.OPERATOR
                }
                NumbOrOperator.OPERATOR -> {
                    if (char.toString() !in operators) return false
                    NumbOrOperator.NUMB
                }
            }
        } else {
            if (char.toString() != " ") return false
        }
    }

    return true
}

private enum class NumbOrOperator {
    NUMB,
    OPERATOR
}