package com.softyorch.retosdeprogramacion.challenges

import java.util.Calendar

/*
 * Crea una función que sea capaz de detectar si existe un viernes 13
 * en el mes y el año indicados.
 * - La función recibirá el mes y el año y retornará verdadero o falso.
 *
 * Se añade test como nuevo challenge.
 *
 */


fun isFriday13() {
    val isFriday = CheckFriday(KnowIfFridayThe13thImpl()).check(10, 2023)
    println(isFriday)
}

/** Clase testeada como Challenge26 */
class CheckFriday(private val knowIfFridayThe13ThImpl: IKnowIfFridayThe13th) {
    fun check(month: Int, year: Int): Boolean {
        println("¡Challenge Viernes 13!")
        println("El resultado es: ")
        return knowIfFridayThe13ThImpl.isFriday(month, year)
    }
}

class KnowIfFridayThe13thImpl : IKnowIfFridayThe13th {
    override fun isFriday(month: Int, year: Int) =
        if (month in (1..12))
            Calendar.getInstance().apply {
                set(Calendar.MONTH, month -1)
                set(Calendar.YEAR, year)
                set(Calendar.DAY_OF_MONTH, 13)
            }.get(Calendar.DAY_OF_WEEK) == 6
        else
            false
}

interface IKnowIfFridayThe13th {
    fun isFriday(month: Int, year: Int): Boolean
}
