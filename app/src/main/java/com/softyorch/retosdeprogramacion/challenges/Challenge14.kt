package com.softyorch.retosdeprogramacion.challenges

/*
 * Crea un pequeño juego que consista en adivinar palabras en un número máximo de intentos:
 * - El juego comienza proponiendo una palabra aleatoria incompleta
 *   - Por ejemplo "m_ur_d_v", y el número de intentos que le quedan
 * - El usuario puede introducir únicamente una letra o una palabra (de la misma longitud que
 *   la palabra a adivinar)
 *   - Si escribe una letra y acierta, se muestra esa letra en la palabra. Si falla, se resta
 *     uno al número de intentos
 *   - Si escribe una resolución y acierta, finaliza el juego, en caso contrario, se resta uno
 *     al número de intentos
 *   - Si el contador de intentos llega a 0, el jugador pierde
 * - La palabra debe ocultar de forma aleatoria letras, y nunca puede comenzar
 *   ocultando más del 60%
 * - Puedes utilizar las palabras que quieras y el número de intentos que consideres
 */


fun words() {
    runGame()
}

private fun runGame() {
    println("Adivina la palabra que se muestra a continuación a la que le faltan caracteres.")
    println("Puedes introducir una letra a adivinar o una palabra de la misma longitud")
    println("Si aciertas una la letra se añdirá a la palabra, si aciertas la palabra habrás ganado")
    println("Si fallas de cualquiera de las dos opiones se te restará un intento")

    var intents = 6
    val randomWord = words.random()
    var secretWord = getSecretWord(randomWord)

    println("La palabra es:")

    while (intents > 0 && secretWord != randomWord) {
        println(secretWord)
        val read = readlnOrNull()
        if (!read.isNullOrEmpty()) {
            pair(read, randomWord, secretWord, intents).apply {
                intents = first
                secretWord = second
            }
        } else {
            println("Debes introducir una letra la palabra correcta")
        }
    }

    if (secretWord == randomWord)
        println("¡¡¡ENHORABUENA!!! has acertado, la palabra es: $randomWord")
    else
        println("Más suerta la prosima vez. La palabra era: $randomWord")
}

private fun pair(read: String, randomWord: String, secretWord: String, intents: Int):
        Pair<Int, String> {
    var inSecretWord = secretWord
    var inIntents = intents

    if (read.length == 1) {
        if (read in randomWord) {
            randomWord.forEachIndexed { i, char ->
                if (char.toString() == read) {
                    inSecretWord = inSecretWord.replaceRange((i..i), read)
                }
            }

            if (secretWord == inSecretWord)
                println("La letra que has introducido ya se muestra")

        } else {
            inIntents--
            println("Mal, te quedan $inIntents intentos")
        }

    } else if (read.length == randomWord.length) {
        if (read == randomWord) {
            inSecretWord = randomWord
        } else {
            inIntents--
            println("Mal, te quedan $inIntents intentos")
        }

    } else {
        println("Debes introducir una letra la palabra correcta")
    }
    return Pair(inIntents, inSecretWord)
}


private fun getSecretWord(randomWord: String): String {
    var secretWord = randomWord
    val charToHide = (0..<(randomWord.length * 0.6).toInt())

    for (hide in charToHide) {
        var charHided = false
        while (!charHided) {
            val charRandom = secretWord.random().toString()
            if (charRandom != "_") {
                secretWord = secretWord.replaceFirst(charRandom, "_", true)
                charHided = true
            }
        }
    }
    return secretWord
}

private val words = arrayListOf(
    "computadora",
    "programacion",
    "desarrollo",
    "teclado",
    "monitor",
    "android",
    "aplicacion",
    "tecnologia",
    "inteligente",
    "telefono"
)
