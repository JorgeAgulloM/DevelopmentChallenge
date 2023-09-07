package com.softyorch.retosdeprogramacion.challenges

import com.softyorch.retosdeprogramacion.challenges.Properties.AVERAGE_LENGTH
import com.softyorch.retosdeprogramacion.challenges.Properties.LONGEST_WORD
import com.softyorch.retosdeprogramacion.challenges.Properties.SENTENCES_COUNT
import com.softyorch.retosdeprogramacion.challenges.Properties.WORDS_COUNT

/*
 * Crea un programa que analice texto y obtenga:
 * - Número total de palabras.
 * - Longitud media de las palabras.
 * - Número de oraciones del texto (cada vez que aparecen un punto).
 * - Encuentre la palabra más larga.
 *
 * Todo esto utilizando un único bucle.
 */

private const val TEXT = "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen. No sólo sobrevivió 500 años, sino que tambien ingresó como texto de relleno en documentos electrónicos, quedando esencialmente igual al original. Fue popularizado en los 60s con la creación de las hojas \"Letraset\", las cuales contenian pasajes de Lorem Ipsum, y más recientemente con software de autoedición, como por ejemplo Aldus PageMaker, el cual incluye versiones de Lorem Ipsum."

fun textAnalytics() {
    analyzer(TEXT).let { map ->
        println("El número total de palabras es: ${map[WORDS_COUNT.name]}")
        println("La longitud media de las palabras es: ${map[AVERAGE_LENGTH.name]}")
        println("El número de oraciones del texto es: ${map[SENTENCES_COUNT.name]}")
        println("La palabra más larga es: ${map[LONGEST_WORD.name]}")
    }
}

private fun analyzer(text: String): Map<String, Any> {

    var analyticText = text
    var wordsCounter = 0
    var avgWordLength = 0
    var sentencesCounter = 0
    var longestWord = ""

    run lit@{
        text.forEach { char ->
            var word = analyticText.split(" ")[0]

            if (char.toString() == ".") {
                sentencesCounter++
                word = word.split(".")[0]
            }

            if (char.toString() == ",") word = word.split(",")[0]
            if (char.toString() == ":") word = word.split(":")[0]

            wordsCounter++
            avgWordLength += word.length

            if (longestWord.length < word.length)
                longestWord = word

            analyticText = analyticText.substringAfter("$word ")

            if (analyticText.isEmpty()) return@lit
        }
    }

    return mapOf(
        WORDS_COUNT.name to wordsCounter,
        AVERAGE_LENGTH.name to (avgWordLength / wordsCounter),
        SENTENCES_COUNT.name to sentencesCounter,
        LONGEST_WORD.name to longestWord
    )
}

private enum class Properties {
    WORDS_COUNT,
    AVERAGE_LENGTH,
    SENTENCES_COUNT,
    LONGEST_WORD
}
