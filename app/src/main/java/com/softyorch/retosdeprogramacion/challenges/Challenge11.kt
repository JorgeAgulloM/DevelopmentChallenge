package com.softyorch.retosdeprogramacion.challenges

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import java.net.URL


/*
 * Llamar a una API es una de las tareas más comunes en programación.
 *
 * Implementa una llamada HTTP a una API (la que tú quieras) y muestra su
 * resultado a través de la terminal. Por ejemplo: Pokémon, Marvel...
 *
 * Aquí tienes un listado de posibles APIs:
 * https://github.com/public-apis/public-apis
 */

fun callPokemonApi() {
    runBlocking(Dispatchers.IO) {
        rickAndMortyAPI()
    }
}

fun rickAndMortyAPI() {
    val json = URL("https://rickandmortyapi.com/api/character/2").readText()
    println(json)
}
