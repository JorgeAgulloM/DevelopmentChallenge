package com.softyorch.retosdeprogramacion.challenges

/*
 * Escribe un programa que, dado un número, compruebe y muestre si es primo,
 * fibonacci y par.
 * Ejemplos:
 * - Con el número 2, nos dirá: "2 es primo, fibonacci y es par"
 * - Con el número 7, nos dirá: "7 es primo, no es fibonacci y es impar"
 */


fun whatIsThisNumber() {

    val numSelect = (0..100).random()
    val isPrime = if (isPrime(numSelect)) "$numSelect es primo" else "$numSelect no es primo"
    val isFibonacci = if (isFibonacci(numSelect)) "fibonacci" else "no es fibonacci"
    val isPair = if (isPair(numSelect)) "es par" else "es impar"
    println("$isPrime, $isFibonacci y $isPair")

}

private fun isPrime(num: Int): Boolean {
    for (i in 2..< num) {
        if (num % i == 0) {
            return false
        }
    }
    return true
}

private fun isFibonacci(num: Int): Boolean {
    val fibonacci = arrayListOf(1, 2)
    if (num == 1 || num == 2) return true
    for (i in 1..num) {
        fibonacci.add(fibonacci.last() + fibonacci.elementAt(i - 1))
        if (fibonacci.last() == num) return true
        if (fibonacci.last() > num) return false
    }
    return false
}

private fun isPair(num: Int): Boolean = num % 2 == 0
