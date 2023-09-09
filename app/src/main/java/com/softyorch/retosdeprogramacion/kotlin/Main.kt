package com.softyorch.retosdeprogramacion.kotlin

import com.softyorch.retosdeprogramacion.challenges.abacusReader
import com.softyorch.retosdeprogramacion.challenges.aurebeshTraslator
import com.softyorch.retosdeprogramacion.challenges.caesarEncryption
import com.softyorch.retosdeprogramacion.challenges.callPokemonApi
import com.softyorch.retosdeprogramacion.challenges.countdown
import com.softyorch.retosdeprogramacion.challenges.dbConnector
import com.softyorch.retosdeprogramacion.challenges.equalStrings
import com.softyorch.retosdeprogramacion.challenges.excelNumbNameOfColumn
import com.softyorch.retosdeprogramacion.challenges.getParametersValue
import com.softyorch.retosdeprogramacion.challenges.helloWorld
import com.softyorch.retosdeprogramacion.challenges.isFriday13
import com.softyorch.retosdeprogramacion.challenges.konamiCode
import com.softyorch.retosdeprogramacion.challenges.leapYears
import com.softyorch.retosdeprogramacion.challenges.magicSortingHat
import com.softyorch.retosdeprogramacion.challenges.mathExpression
import com.softyorch.retosdeprogramacion.challenges.octalAndHexadecimalConverter
import com.softyorch.retosdeprogramacion.challenges.passGenerator
import com.softyorch.retosdeprogramacion.challenges.pseudoRandom
import com.softyorch.retosdeprogramacion.challenges.reedGithubInfo
import com.softyorch.retosdeprogramacion.challenges.rocPaperScissorsLizardSpock
import com.softyorch.retosdeprogramacion.challenges.spiral
import com.softyorch.retosdeprogramacion.challenges.t9Keyboard
import com.softyorch.retosdeprogramacion.challenges.tennisMatch
import com.softyorch.retosdeprogramacion.challenges.testingFriday13th
import com.softyorch.retosdeprogramacion.challenges.tetrisGame
import com.softyorch.retosdeprogramacion.challenges.textAnalytics
import com.softyorch.retosdeprogramacion.challenges.theHackerLanguage
import com.softyorch.retosdeprogramacion.challenges.twinPrimes
import com.softyorch.retosdeprogramacion.challenges.typeOfString
import com.softyorch.retosdeprogramacion.challenges.webScraping
import com.softyorch.retosdeprogramacion.challenges.whatIsThisNumber
import com.softyorch.retosdeprogramacion.challenges.words
import com.softyorch.retosdeprogramacion.challenges.zeldaTriforce

fun main() {

    println("Porfavor, introduce el número de prueba: ")
    when (readlnOrNull()?.toInt() ?: 0) {
        1 -> leapYears()
        2 -> theHackerLanguage("Código leet. Hola, me llamo Jorge y nací en 1982. Soy desarrollador de software.")
        3 -> tennisMatch()
        4 -> passGenerator()
        5 -> whatIsThisNumber()
        6 -> helloWorld()
        7 -> rocPaperScissorsLizardSpock()
        8 -> magicSortingHat()
        9 -> pseudoRandom()
        10 -> typeOfString()
        11 -> callPokemonApi()
        12 -> getParametersValue()
        13 -> isFriday13()
        14 -> words()
        15 -> octalAndHexadecimalConverter()
        16 -> aurebeshTraslator()
        17 -> reedGithubInfo()
        18 -> webScraping()
        19 -> textAnalytics()
        20 -> zeldaTriforce()
        21 -> twinPrimes()
        22 -> spiral()
        23 -> dbConnector()
        24 -> caesarEncryption()
        25 -> konamiCode()
        26 -> testingFriday13th()
        27 -> countdown()
        28 -> mathExpression()
        29 -> equalStrings()
        30 -> t9Keyboard()
        31 -> abacusReader()
        32 -> excelNumbNameOfColumn()
        33 -> tetrisGame()
        else -> {
            println("No se ha encontrado la prueba")
        }
    }
}