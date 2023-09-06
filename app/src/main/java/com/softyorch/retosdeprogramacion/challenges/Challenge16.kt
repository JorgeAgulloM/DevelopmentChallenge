package com.softyorch.retosdeprogramacion.challenges

/*
 * Crea una función que sea capaz de transformar Español al lenguaje básico
 * del universo Star Wars: el "Aurebesh".
 * - Puedes dejar sin transformar los caracteres que no existan en "Aurebesh".
 * - También tiene que ser capaz de traducir en sentido contrario.
 *
 * ¿Lo has conseguido? Nómbrame en twitter.com/mouredev y escríbeme algo en Aurebesh.
 *
 * ¡Que la fuerza os acompañe!
 */

fun aurebeshTraslator() {
    doubleChars = basicAlphabet.filterKeys { char -> char.length > 1 }
    val aure = abcToAure("Hola, soy Jorge. Soy desarrollador y vivo en España.")
    println(aure)

    val abc = aureToAbc(aure)
    println(abc)
}

private fun abcToAure(text: String): String {
    var result = ""

    text.lowercase().forEachIndexed { i, char ->
        result += if (char.isLetter())
            if (char.toString() != "ñ")
                if (i < text.length - 1) {
                    val doubleChar = char.toString() + text.lowercase()[i + 1]
                    if (doubleChar in doubleChars)
                        doubleChars[doubleChar]
                    else
                        basicAlphabet[char.toString()]
                } else
                    basicAlphabet[char.toString()]
            else
                "?"
        else
            char
    }
    return result
}

private fun aureToAbc(text: String): String {
    var textResume = text
    var result = ""

    while (true) {
        run lit@ {
            basicAlphabet.forEach { (key, value) ->
                if (textResume.isEmpty()) return@lit

                if (textResume[0].toString() == "?") {
                    result += "ñ"
                    textResume = textResume.substringAfter(textResume[0])
                    return@lit
                }

                if (!textResume[0].isLetter()) {
                    result += textResume[0]
                    textResume = textResume.substringAfter(textResume[0])
                    return@lit
                }

                if (textResume[0].toString() == value[0].toString()){
                    result += key
                    textResume = textResume.substringAfter(value)
                    return@lit
                }
            }
        }
        if (textResume.isEmpty()) break
    }

    return result
}

private lateinit var doubleChars: Map<String,String>

private val basicAlphabet = mapOf(
    "a" to "aurek",
    "b" to "besh",
    "c" to "cresh",
    "d" to "dorn",
    "e" to "esk",
    "f" to "forn",
    "g" to "grek",
    "h" to "herf",
    "i" to "isk",
    "j" to "jenth",
    "k" to "krill",
    "l" to "leth",
    "m" to "merm",
    "n" to "nern",
    "o" to "osk",
    "p" to "peth",
    "q" to "qek",
    "r" to "resh",
    "s" to "senth",
    "t" to "trill",
    "u" to "usk",
    "v" to "vev",
    "w" to "wesk",
    "x" to "xesh",
    "y" to "yirt",
    "z" to "zerek",
    "ae" to "enth",
    "eo" to "onith",
    "kh" to "krenth",
    "ng" to "nen",
    "oo" to "orenth",
    "sh" to "sen",
    "th" to "thesh"
)
