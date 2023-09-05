package com.softyorch.retosdeprogramacion.challenges

/*
 * Crea un programa que simule el comportamiento del sombrero selccionador del
 * universo mágico de Harry Potter.
 * - De ser posible realizará 5 preguntas (como mínimo) a través de la terminal.
 * - Cada pregunta tendrá 4 respuestas posibles (también a selecciona una a través de terminal).
 * - En función de las respuestas a las 5 preguntas deberás diseñar un algoritmo que
 *   coloque al alumno en una de las 4 casas de Hogwarts:
 *   (Gryffindor, Slytherin , Hufflepuff y Ravenclaw)
 * - Ten en cuenta los rasgos de cada casa para hacer las preguntas
 *   y crear el algoritmo seleccionador:
 *   Por ejemplo, en Slytherin se premia la ambición y la astucia.
 */


fun magicSortingHat() {

    println("Preparate para responder a la siguientes preguntas y saber a que casa perteneces.")
    println("Responde con el número correspondiente a cada respuesta de cada preguntra.")
    println("¿Preparado?, Empecemos!")
    questions.map { (ask, answer) ->

        val index = questions.keys.indexOf(ask)
        var isResponseTrue = false

        println(ask)
        println("1: ${answer[0]}")
        println("2: ${answer[1]}")
        println("3: ${answer[2]}")
        println("4: ${answer[3]}")

        while (!isResponseTrue) {
            try {
                val read = readlnOrNull()
                if (read!!.toInt() in (0..5)) {
                    userRequest[index] = read.toInt() - 1
                    isResponseTrue = true
                } else {
                    println("Debes seleccionar tu respuesta con un número del 1 al 4")
                }
            } catch (e: Exception) {
                println("Debes seleccionar tu respuesta con un número del 1 al 4")
            }
        }
    }

    println("!Felicidades! Has sido elegido para la casa: ${houses.elementAt(calculateResult())}!!!")

}

fun calculateResult(): Int {
    userRequest.forEachIndexed { userI, userValue ->
        (0..3).forEach { index ->
            addValue(userI, userValue, index)
        }
    }
    println(pointsAcquired)

    var result = 0
    pointsAcquired.forEach {
        if (it > result)
            result = it
    }

    return pointsAcquired.indexOf(result)
}

private fun addValue(userI: Int, userValue: Int, index: Int) {
    if (userValue == houseValues.elementAt(index)[userI]) pointsAcquired[index]++
}

private val userRequest = mutableListOf(0, 0, 0, 0, 0)
private val pointsAcquired = mutableListOf(0, 0, 0, 0)
private val houses = arrayListOf("Gryffindor", "Hufflepuff", "Ravenclaw", "Slytherin")
private val houseValues = arrayListOf(
    arrayListOf(2, 1, 0, 3, 3),
    arrayListOf(3, 0, 2, 1, 1),
    arrayListOf(1, 2, 1, 0, 2),
    arrayListOf(0, 3, 3, 2, 0)
)
private val questions: Map<String, ArrayList<String>> = mapOf(
    "¿Cuál de las siguientes opciones odiaría más que la gente lo llamara?" to
            arrayListOf(
                "Ordinario",
                "Ignorante",
                "Cobarde",
                "Egoista"
            ),
    "Después de su muerte ¿qué es lo que más le gustaría que hiciera la gentecuando escuche su nombre?" to
            arrayListOf(
                "Te extraña, pero sonríe",
                "Pide mas historias sobre tus aventuras",
                "Piensa con admiración tus logros",
                "No me importa lo que la gente piense de mí después de mi muerte, es lo que piensan de mi mientras estoy vivo lo que cuenta"
            ),
    "Dada la opción, preferirías inventar una poción que garantizara: " to
            arrayListOf(
                "Gloria",
                "Sabiduria",
                "Amor",
                "Poder"
            ),
    "¿Cómo le gustaría ser conocido en la historia?" to
            arrayListOf(
                "El sabio",
                "El bueno",
                "El gran",
                "El audaz"
            ),
    "Entras en un jardín encantado. ¿Qué sería lo más curioso de examinar primero?" to
            arrayListOf(
                "El árbol de hojas de plata con manzanas doradas",
                "Las setas rojas gordas que parecen estar hablando entre sí",
                "El estanque burbujeante en cuyas profundidades se arremolina algo luminoso",
                "La estatua del viejo mago con un extraño centelleo en los ojos"
            )
)
