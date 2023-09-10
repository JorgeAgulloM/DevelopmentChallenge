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
    startTxt()
}

private fun startTxt() {
    val next = "seguir"
    val new = "nuevo"
    file = File("$FILE_PATH$FILE_NAME")

    if (txtExist()) {
        println("Existe un fichero $FILE_NAME")
        println("¿Deseas seguir escribiendo en él o borrar y empezar de nuevo?")

        while (true) {
            println("Escriber $next o $new")

            when (readln()) {
                next -> {
                    val readFile = readFile()
                    println(readFile)
                    writeFile(readFile)
                    break
                }

                new -> {
                    writeFile(null)
                    break
                }

                else -> println("Opcion no encontrada")
            }
        }

    } else {
        println("Escribe lo que quieras para guardarlo en el fichero")
        val read = readln()

        if (read.isNotBlank()) {
            writeFile(null)
        } else
            println("No has escrito nada")
    }
}

private fun writeFile(readeFile: String?) {
    try {
        FileWriter(file).apply {
            val newRead = readln()
            val textToWrite = if (readeFile.isNullOrBlank()) newRead else "$readeFile\n$newRead"
            write(textToWrite)

            close()
        }
        println("Datos guardados. Adios")
    } catch (e: Exception) {
        print("Error, no se ha gaurdado nada. ${e.printStackTrace()}")
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
        file.exists()
    } catch (e: Exception) {
        false
    }
}

private lateinit var file: File
private const val FILE_NAME = "text.txt"
private const val FILE_PATH = "app/src/main/java/com/softyorch/retosdeprogramacion/challenges/"