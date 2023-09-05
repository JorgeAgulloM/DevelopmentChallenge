package com.softyorch.retosdeprogramacion.challenges

/*
 * Crea 3 funciones, cada una encargada de detectar si una cadena de
 * texto es un heterograma, un isograma o un pangrama.
 * - Debes buscar la definición de cada uno de estos términos.
 */

fun typeOfString() {
    val text = "yuxtaponer"
    //val text = "arra"
    //val text = "Benjamín pidió una bebida de kiwi y fresa. Noé, sin vergüenza, la más exquisita champaña del menú."
    val standardText = standardisingChars(text)

    result(text, isHeterogram(standardText), "heterograma")
    result(text, isIsogram(standardText), "isograma")
    result(text, isPangram(standardText), "pangram")

}

private fun result(text: String, value: Boolean, mode: String) {
    println("La palabra o frase $text ${if (value) "SI es un $mode" else "NO es un $mode"}")
}

private fun standardisingChars(text: String): ArrayList<Int> {
    val accentMap = mapOf(
        'á' to 'a', 'é' to 'e', 'í' to 'i', 'ó' to 'o', 'ú' to 'u',
        'Á' to 'A', 'É' to 'E', 'Í' to 'I', 'Ó' to 'O', 'Ú' to 'U',
        'ü' to 'u', 'Ü' to 'U', 'ñ' to 'n', 'Ñ' to 'N'
    )
    var modifiedText = ""
    text.forEach { char ->
        modifiedText += if (char in accentMap.keys)
            accentMap[char.lowercaseChar()]
        else
            char.lowercase()
    }

    val charArray = arrayListOf<Char>()
    modifiedText.forEach { char ->
        if (char.isLetter() && char !in charArray)
            charArray.add(char)
    }

    val values = arrayListOf<Int>()
    charArray.forEach { value ->
        values.add(0)
        modifiedText.forEach { char ->
            if (value == char)
                values[values.size - 1]++
        }
    }

    return values
}

//Palabra o frase que no contiene ninguna letra repetida.
private fun isHeterogram(text: ArrayList<Int>): Boolean {
    text.forEach { value ->
        if (value > 1) {
            return false
        }
    }
    return true
}

//Palabra o frase en la que cada letra aparece el mismo número de veces
private fun isIsogram(text: ArrayList<Int>): Boolean {
    text.forEachIndexed { i, value ->
        if (i > 0) {
            if (value != text[i - 1] || value < 2) {
                return false
            }
        }
    }
    return true
}

//Una frase en la que aparecen todas las letras del abecedario
private fun isPangram(text: ArrayList<Int>) = text.size == 26 //Abecedario standard

