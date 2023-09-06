package com.softyorch.retosdeprogramacion.challenges

/*
 * Dada una URL con parámetros, crea una función que obtenga sus valores.
 * No se pueden usar operaciones del lenguaje que realicen esta tarea directamente.
 *
 * Ejemplo: En la url https://retosdeprogramacion.com?year=2023&challenge=0
 * los parámetros serían ["2023", "0"]
 */

fun getParametersValue() {
    val params = getValues2("https://retosdeprogramacion.com?year=2023&challenge=0&yorch=1000")
    params.forEach {
        println(it)
    }
}

private fun getValues2(url: String): Map<String,String> {
    var paramsOfUrl = url.split("?")[1]
    val params = mutableMapOf<String,String>()

    var paramsCount = 0
    paramsOfUrl.forEach {
        if (it.toString() == "=") paramsCount++
    }

    for (param in 0..paramsCount) {
        val paramKey = paramsOfUrl.split("=")[0]
        val paramValue = paramsOfUrl.split("=")[1].split("&")[0]
        params[paramKey] = paramValue

        if ("&" in paramsOfUrl)
            paramsOfUrl = paramsOfUrl.substringAfter("&", paramsOfUrl)
        else
            break
    }

    return params

}