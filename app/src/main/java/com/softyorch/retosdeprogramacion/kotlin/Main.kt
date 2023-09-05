package com.softyorch.retosdeprogramacion.kotlin

import com.softyorch.retosdeprogramacion.challenges.helloWorld
import com.softyorch.retosdeprogramacion.challenges.leapYears
import com.softyorch.retosdeprogramacion.challenges.magicSortingHat
import com.softyorch.retosdeprogramacion.challenges.passGenerator
import com.softyorch.retosdeprogramacion.challenges.pseudoRandom
import com.softyorch.retosdeprogramacion.challenges.rocPaperScissorsLizardSpock
import com.softyorch.retosdeprogramacion.challenges.tennisMatch
import com.softyorch.retosdeprogramacion.challenges.theHackerLanguage
import com.softyorch.retosdeprogramacion.challenges.typeOfString
import com.softyorch.retosdeprogramacion.challenges.whatIsThisNumber

fun main() {

    println("Porfavor, introduce el número de prueba: ")
    when (readlnOrNull()?.toInt() ?: 0) {
        0 -> leapYears()
        1 -> theHackerLanguage("Código leet. Hola, me llamo Jorge y nací en 1982. Soy desarrollador de software.")
        2 -> tennisMatch()
        3 -> passGenerator()
        4 -> whatIsThisNumber()
        5 -> helloWorld()
        6 -> rocPaperScissorsLizardSpock()
        7 -> magicSortingHat()
        8 -> pseudoRandom()
        9 -> typeOfString()
        else -> {
            println("No se ha encontrado la prueba")
        }
    }
}