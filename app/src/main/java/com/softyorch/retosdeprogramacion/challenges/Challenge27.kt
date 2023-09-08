package com.softyorch.retosdeprogramacion.challenges

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.lang.Thread.sleep

/*
 * Crea una función que reciba dos parámetros para crear una cuenta atrás.
 * - El primero, representa el número en el que comienza la cuenta.
 * - El segundo, los segundos que tienen que transcurrir entre cada cuenta.
 * - Sólo se aceptan números enteros positivos.
 * - El programa finaliza al llegar a cero.
 * - Debes imprimir cada número de la cuenta atrás.
 */

fun countdown() {
    println("Challenge 27: Countdown")
    println("Por favor, selecciona un número inicial mayor de 0")
    requestParameters()
}

private fun requestParameters() {
    val start = isDecimalNumberPositive(readln())
    if (start != null) {
        println("Ahora introduce el tiempo en segundos de cada cuenta mayor de 0")
        var timeLoop = isDecimalNumberPositive(readln())
        if (timeLoop != null) {
            val toMillis = 1000
            timeLoop *= toMillis
            runBlocking {
                startCountdown(start, timeLoop)
            }
        } else error()
    } else error()
}

private suspend fun startCountdown(start: Int, timeLoop: Int) {
    withContext(Dispatchers.IO) {
        for (i in start downTo 0) {
            println(i)
            sleep(timeLoop.toLong())
        }
        println("It´s the final countdown!!!!!")
    }
}

private fun isDecimalNumberPositive(n: String?): Int? =
    try {
        n?.toInt()
    } catch (e: Exception) {
        null
    }

private fun error() {
    println("No has introducido un número o no es un número positivo")
}