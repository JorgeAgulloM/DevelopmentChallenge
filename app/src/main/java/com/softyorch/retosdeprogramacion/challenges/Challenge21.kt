package com.softyorch.retosdeprogramacion.challenges

/*
 * Crea un programa que encuentre y muestre todos los pares de números primos
 * gemelos en un rango concreto.
 * El programa recibirá el rango máximo como número entero positivo.
 *
 * - Un par de números primos se considera gemelo si la diferencia entre
 *   ellos es exactamente 2. Por ejemplo (3, 5), (11, 13)
 *
 * - Ejemplo: Rango 14
 *   (3, 5), (5, 7), (11, 13)
 */

fun twinPrimes() {
    val primes = extractPrimes(100)
    var twinsList = ""
    getTwins(primes).forEach { twin ->
        twinsList += "$twin, "
    }
    println(twinsList)
}

private fun extractPrimes(max: Int): ArrayList<Int> {
    val list = arrayListOf(2)
    for (n in 3..max) {
        var isPrime = true
        for (i in 2..<n) {
            if (n % i == 0) isPrime = false
        }
        if (isPrime) list.add(n)
    }
    return list
}

private fun getTwins(primes: ArrayList<Int>): ArrayList<String> {
    val twins = arrayListOf<String>()
    primes.forEachIndexed { i, prime ->
        if (prime < primes[primes.size -1]){
            val next = primes[i + 1]
            if (prime + 2 == next)
                twins.add("($prime, $next)")
        }
    }
    return twins
}