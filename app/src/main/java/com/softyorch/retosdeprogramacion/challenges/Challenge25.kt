package com.softyorch.retosdeprogramacion.challenges

/*
 * Crea un programa que detecte cuando el famoso "Código Konami" se ha
 * introducido correctamente desde el teclado.
 * Si sucede esto, debe notificarse mostrando un mensaje en la terminal.
 *
 * ↑ ↑ ↓ ↓ ← → ← → B A
 * 8 8 2 2 4 6 4 6 b a
 *
 * No he encontrado una librería que pueda integrar para detectar el teclado en la terminal
 *
 */

private const val KONAMI_CODE = """
    ╦╔═╔═╗╔╗╔╔═╗╔╦╗╦  ╔═╗╔═╗╔╦╗╔═╗
    ╠╩╗║ ║║║║╠═╣║║║║  ║  ║ ║ ║║║╣ 
    ╩ ╩╚═╝╝╚╝╩ ╩╩ ╩╩  ╚═╝╚═╝═╩╝╚═╝
"""

fun konamiCode() {
    println("Bienvenido a la prueba del código Konami")
    println("¿Conoces el código? demuestralo.")
    println("utiliza el teclado numérico para simbolizar las teclas de dirección")
    if (isKonamiCode()) println(KONAMI_CODE) else println("¡¡OOOhhh, no lo has conseguido!!")
}

private fun isKonamiCode(): Boolean {
    val konamiCode = "88224646ba"
    val code = readlnOrNull()

    code?.let {
        konamiCode.forEachIndexed { i, char ->
            if (char.toString() != it[i].toString()) {
                return false
            }
        }
        return true
    }

    println("¡No has escrito nada!")

    return false
}

