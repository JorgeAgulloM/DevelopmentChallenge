package com.softyorch.retosdeprogramacion.challenges

import org.eclipse.jgit.api.Git
import java.io.File

/*
 * ¡Estoy de celebración! He publicado mi primer libro:
 * "Git y GitHub desde cero"
 * - Papel: mouredev.com/libro-git
 * - eBook: mouredev.com/ebook-git
 *
 * ¿Sabías que puedes leer información de Git y GitHub desde la gran
 * mayoría de lenguajes de programación?
 *
 * Crea un programa que lea los últimos 10 commits de este repositorio y muestre:
 * - Hash
 * - Autor
 * - Mensaje
 * - Fecha y hora
 *
 * Ejemplo de salida:
 * Commit 1 (el más reciente) | 12345A | MoureDev | Este es un commit | 24/04/2023 21:00
 *
 * Se permite utilizar librerías que nos faciliten esta tarea.
 *
 */

fun reedGithubInfo() {
    openApiRepo()
}

private fun openApiRepo() {
    val repo = Git.open(File(".")) // Abre el repositorio actual
    val commits = repo.log().all().setMaxCount(10).call() // Obtiene los últimos 10 commits

    var commitCounter = 1

    for (commit in commits) {
        val hexsha = commit.id.abbreviate(7).name() // Obtiene el hash abreviado
        val authorName = commit.authorIdent.name
        val message = commit.fullMessage.replace("\n", "")
        val authoredDatetime = commit.authorIdent.getWhen()

        println("Commit $commitCounter | $hexsha | $authorName | $message | $authoredDatetime")
        commitCounter++
    }

}
