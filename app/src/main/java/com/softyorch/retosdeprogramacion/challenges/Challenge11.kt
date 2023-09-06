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
        pokeAPI()
    }
}

fun pokeAPI() {
    val json = URL("https://pokeapi.co/api/v2/pokemon?limit=151").readText()
    println(json)
}
