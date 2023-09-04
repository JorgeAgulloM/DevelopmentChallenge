package com.softyorch.retosdeprogramacion.challenges

/*
 * Escribe un programa que muestre por consola (con un print) los
 * números de 1 a 100 (ambos incluidos y con un salto de línea entre
 * cada impresión), sustituyendo los siguientes:
 * - Múltiplos de 3 por la palabra "fizz".
 * - Múltiplos de 5 por la palabra "buzz".
 * - Múltiplos de 3 y de 5 a la vez por la palabra "fizzbuzz".
 */

fun leapYears() {
    (1..100).forEach { value ->
        if (isFizzBuzz(value)) {
            printFizzBuzz("fizzbuzz")
        } else if (isFizz(value)) {
            printFizzBuzz("fizz")
        } else if (isBuzz(value)) {
            printFizzBuzz("buzz")
        } else {
            printValue(value)
        }
    }
}

fun isFizz(value: Int) = value % 3 == 0

fun isBuzz(value: Int) = value % 5 == 0

fun isFizzBuzz(value: Int) = isFizz(value) && isBuzz(value)

fun printValue(value: Int) = println("$value\n")

fun printFizzBuzz(value: String) = println("$value\n")