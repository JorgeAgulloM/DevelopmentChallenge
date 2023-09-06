package com.softyorch.retosdeprogramacion.challenges

import java.net.URL

/*
 * El día 128 del año celebramos en la comunidad el "Hola Mundo day"
 * Vamos a hacer "web scraping" sobre su sitio web: https://holamundo.day
 *
 * Crea un programa que se conecte a la web del evento e imprima únicamente la agenda de eventos
 * del día 8. Mostrando hora e información de cada uno.
 * Ejemplo: "16:00 | Bienvenida"
 *
 * Se permite utilizar librerías que nos faciliten esta tarea.
 *
 */

fun webScraping() {
    run()
}

private fun run() {

    val pageUrl = "https://holamundo.day/"
    val title8May = "Agenda 8 de mayo"

    val htmlString = downloadPage(pageUrl)
    val articleBlocks = extractHTMLTagBlock("article", htmlString)
    val articleBlock8May = articleBlocks.filter { it.contains(title8May) }.toString()
    val articleBlock8MayFilter = Regex("<h1.+${title8May}.+").find(articleBlock8May)!!.value

    val title = extractHTMLTagContent(extractHTMLTagBlock("h1", articleBlock8MayFilter).first())
    val events = extractHTMLTagBlock("blockquote", articleBlock8MayFilter).map {
        extractHTMLTagContent(it)
    }

    println(title)
    println()
    events.forEach { event ->
        println(event)
    }
}

private fun downloadPage(pageUrl: String): String {
    val html = URL(pageUrl).openConnection().apply {
        setRequestProperty("User-Agent", "Mozilla/5.0")
    }.getInputStream().bufferedReader().use {
        it.readText()
    }
    return html
}

private fun extractHTMLTagBlock(tag: String, html: String): List<String> {
    val regex = Regex("<$tag.*?</$tag>", RegexOption.DOT_MATCHES_ALL)
    val blocks: List<String> = regex.findAll(html).map {
        it.value
    }.toList()
    return blocks
}

private fun extractHTMLTagContent(input: String): String {
    val regex = "<[^>]*>".toRegex()
    return regex.replace(input, "")
}

