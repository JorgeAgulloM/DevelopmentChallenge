package com.softyorch.retosdeprogramacion.challenges

/*
 * Crea un generador de números pseudoaleatorios entre 0 y 100.
 * - No puedes usar ninguna función "random" (o semejante) del
 *   lenguaje de programación seleccionado.
 *
 * Es más complicado de lo que parece...
 */

fun pseudoRandom() {
    println(generatedRandom())
}

private fun generatedRandom() = (System.currentTimeMillis() % 101).toInt()
