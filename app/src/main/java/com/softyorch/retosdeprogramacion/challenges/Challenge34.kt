package com.softyorch.retosdeprogramacion.challenges

import java.io.File
import java.io.FileWriter

/*
 * Crea un programa capaz de interactuar con un fichero TXT.
 * IMPORTANTE: El fichero TXT NO debe subirse como parte de la corrección.
 * Únicamente el código.
 *
 * - Si no existe, debe crear un fichero llamado "text.txt".
 * - Desde el programa debes ser capaz de introducir texto por consola y guardarlo
 *   en una nueva línea cada vez que se pulse el botón "Enter".
 * - Si el fichero existe, el programa tiene que dar la opción de seguir escribiendo
 *   a continuación o borrar su contenido y comenzar desde el principio.
 * - Si se selecciona continuar escribiendo, se tiene que mostrar por consola
 *   el texto que ya posee el fichero.
 */

fun txtEditor() {
    println("Challenge34. El txt")
    readText()
}

private fun readText() {
    val next = "seguir"
    val new = "nuevo"

    if (txtExist()) {
        println("Escribe lo que quieras para guardarlo en el fichero")
        val read = readln()

        if (read.isNotBlank()) {
            writeFile(read)
        } else
            println("No has escrito nada")
    } else {
        println("Existe un fichero $FILE_NAME")
        println("¿Deseas seguir escribiendo en él o borrar y empezar de nuevo?")

        while (true) {
            println("Escriber $next o $new")

            when (readln()) {
                next -> {
                    println("${readFile()}\n")
                    writeFile(readln())
                    break
                }

                new -> {
                    writeFile(readln())
                    break
                }

                else -> println("Opcion no encontrada")
            }
        }

    }
}

private fun writeFile(text: String) {
    try {
        val file = File("$FILE_PATH$FILE_NAME")
        FileWriter(file).apply {
            write(text)
            close()
        }
        println("Datos guardados. Adios")
    } catch (e: Exception) {
        print("Error, no se ha gaurdado nada.")
    }
}

private fun readFile(): String {
    val lines = file.readLines()
    var text = ""

    for (line in lines) {
        text += "$line\n"
    }
    return text
}

private fun txtExist(): Boolean {
    return try {
        File("$FILE_PATH$FILE_NAME").exists()
        true
    } catch (e: Exception) {
        false
    }
}

private lateinit var file: File
private const val FILE_NAME = "text.txt"
private const val FILE_PATH = "app/src/main/java/com/softyorch/retosdeprogramacion/challenges/"