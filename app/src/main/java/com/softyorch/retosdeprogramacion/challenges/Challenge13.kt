package com.softyorch.retosdeprogramacion.challenges

import java.util.Calendar

/*
 * Crea una función que sea capaz de detectar si existe un viernes 13
 * en el mes y el año indicados.
 * - La función recibirá el mes y el año y retornará verdadero o falso.
 */

fun isFriday13() {
    val isFriday = knowIfFridayThe13th(9, 2023)
    println(isFriday)
}

private fun knowIfFridayThe13th(month: Int, year: Int) =
    Calendar.getInstance().apply {
        set(Calendar.MONTH, month)
        set(Calendar.YEAR, year)
        set(Calendar.DAY_OF_MONTH, 13)
    }.get(Calendar.DAY_OF_WEEK) == 6

