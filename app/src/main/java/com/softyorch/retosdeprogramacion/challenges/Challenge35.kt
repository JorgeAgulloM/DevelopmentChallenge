package com.softyorch.retosdeprogramacion.challenges

import android.util.Range
import androidx.annotation.StringRes
import androidx.core.util.toRange
import java.io.File

/*
 * Como cada año, el día 256 se celebra el "Día de la Programación".
 * En nuestra comunidad siempre hacemos una gran fiesta donde repartirmos
 * 256 regalos para seguir aprendiendo programación:
 * https://diadelaprogramacion.com
 *
 * Para seguir ayudando, te propongo este reto:
 * Mostrar la sintaxis de los principales elementos de un lenguaje
 * en TODOS los lenguajes de programación que podamos. ¿Llegaremos a 50?
 *
 * En un fichero, haz lo siguiente (si el lenguaje lo soporta),
 * y comenta cada bloque para identificar con qué se corresponde:
 * - Haz un "Hola, mundo!"
 * - Crea variables de tipo String, numéricas (enteras y decimales)
 *   y Booleanas (o cualquier tipo de dato primitivo).
 * - Crea una constante.
 * - Usa un if, else if y else.
 * - Crea estructuras como un array, lista, tupla, set y diccionario.
 * - Usa un for, foreach y un while.
 * - Crea diferentes funciones (con/sin parámetros y con/sin retorno).
 * - Crea una clase.
 * - Muestra el control de excepciones.
 *
 * Así, cualquier persona podrá consultar rápidamente diferentes ejemplos
 * de sintaxis básica de muchos lenguajes.
 *
 * ¡Muchas gracias!
 */

fun kotlinSyntax() {
    //Imprime en consola el texto
    println("Hola, mundo!")

    //<- utiliza la doble barra invertida para comentar lo que quieras, el compilador hará caso omiso de esto.

    /**
     * Tambien puedes encerrar parrafos de texto usando la combinación /** texto */
     * Al hacerlo sobre un objeto, variable, función... cuando uses dicho objeto el editor te mostrará este
     * texto como documentación respeco al objeto al situar el puntero sobre este.
     * */

    //Utiliza 'val' para crear una variable que solo se va a setear una vez, esta no podrá cambiar de valor.
    val myBoolean: Boolean = true
    val myBooleanWithOutExplicitType = false

    //Utiliza 'var' para crear variables mutables, que pueden ser modificadas más adelante durante su vida.
    var myBooleanMutable = true

    val myInt: Int = 10
    val myIntWithoutExplicitType = 10
    val myIntMaxValue = 2147483647
    val myIntMinValue = -2147483647
    val myIntMaxValueWithSeparator = 2_147_483_647

    val myLong: Long = 100
    val myLongMaxValue = 9_223_372_036_854_775_807
    val myLongMinValue = 9_223_372_036_854_775_807

    val myFloat: Float = 10.5f
    val myFloatWithOutExplicitType = 10.5f

    val myDouble: Double = 1.932214124
    val myDoubleWithOutExplicitType = 1.932214124

    val myChar: Char = '1'
    val myCharWithOutExplicitType = 'q'

    val myString: String = "Esto es un string"
    val myStringWithoutExplicitType = "Esto también es un string"

    /** Puede concatenar variables o resultados fácilmente de esta forma.
     * Existen otras de hacerlo, pero para mi esta el la más simple.
     * */
    val myResultsInString = "MyInt:$myInt, myLong:$myLong, myFloat:$myFloat, myDouble:$myDouble"
    val exampleCharMethods =
        "My example Char methods: myChar: $myChar," +
                " my char code: ${myChar.code}, " +
                "my char digit evaluated ${myChar.digitToInt()}"

    //Construcción de un array, en kotlin llamadas Array o ArrayList
    //La gran diferencia entre un array y un arraylist es que el array tiene un tamaño fijo, mientra que
    //El del arrayList puede ser modificado.
    val myArray: Array<Int> = arrayOf(10, 20, 30, 40, 50) //Array de enteros

    //Para acceder a estas, usamos un indice, que debe ser siempre entre 0 como primer índice y el valor máximo
    //de objetos que tenga el array
    println(myArray[0]) // == 10
    println(myArray[1]) // == 20
    //...
    //En este caso utilizamos - 1, ya que el número total de objetos del array
    //Si utilizasemos .size tal cual, este sería 5, pero no existe una posición 5 dentro del array
    //cuesta cogerlo un poco al principio
    //arrayOf(10, 20, 30, 40, 50)
    //Cantidad total de valores = 5
    //indice: 0, 1, 2, 3, 4 pero no 5
    println(myArray[myArray.size - 1]) // = 50

    //Sucede lo mismo para el arrayList y el mutableList

    val myArrayList: ArrayList<Any> = arrayListOf("hola", "mundo", "soy", "una", "lista")

    //Añadimos un valor al arrayList. Este se colocará en última posición
    myArrayList.add("variable")

    //Eliminamos un valor. Se eliminará el objeto cuyo valor sea 'hola
    myArrayList.remove("hola") // = arrayListOf("mundo", "soy", "una", "lista")

    //También podemos eliminar por el índice
    myArrayList.removeAt(3) // = arrayListOf("mundo", "soy", "una")

    //Podemos modificar el valor de uno de sus objetos
    myArrayList[0] = ""

    //La tupla en kotlin se representa con el objeto Pair()
    //Los objetos Pair son inmutables, pueden combinar distintos objetos en su interior, siempre dos objetos.
    val myPair: Pair<Int, String> = Pair(0, "cero")
    val myPairFirst = myPair.first //= 0
    val myPairSecond = myPair.second //= "cero"

    //Los sets son colecciones de datos sin orden, sin indices y son inmutables.
    //Su ventaja erradica en que no puede contener valores duplicados.
    val mySet: Set<Int> = setOf(0, 1, 2, 4, 5, 6)
    //El valor 2 no se guardaría, ya que existe en este momemto.
    mySet.plus(2)
    //Son muy eficaces para evitar duplicidades.

    //Los diccionarios en kotlin se representa con el objeto Map, estos se conforman en conjuntos de clave valor.
    //Una clave puede alvergar múltiples valores, no alrevés. Las claves no pueden duplicarse.
    val myMap: Map<String, Int> = mapOf("clave" to 1)
    val myMapTwo: Map<Int, Array<String>> = mapOf(0 to arrayOf("uno", "dos", "tres"))

    //Podemos crear objetos como rangos. En este caso se representan los números del 0 al 10
    val myRange: IntRange = 0..10
    //Este rango recorre el abecedario (Internacional, sin la ñ) de la 'a' a la 'z'
    val abc = ('a'..'z')

}

/** Puedes crear constantes para variables primitivas, fuera de funciones y clases tal que así */
const val MY_CONST = "Esto es una constante inmutable y pública a todo el proyecto"


/**
 * Función con parámetros y retorno, debe ser llamada con un parametro, en este caso del tipo Stirng y
 * debe terminar devolviendo un valor, en este caso un entero (Int)
 *
 * En el texto explicativo puede resaltar estos parametros
 *
 * @param myParam String
 * @return Int
 */
fun ifAndIfElse(myParam: String): Int {
    //Sintaxis de evaluación If else
    var result = 0

    if (myParam == "Hola") {
        result = 1
    } else if (myParam == "Adios") {
        result = 2
    } else
        result = 3

    return result
}

/**
 * En este caso simplificamos la devolución de la evaluación del if
 * */
fun ifAndIfElseSimplified(myParam: String): Int {
    if (myParam == "Hola") {
        return 0
    } else if (myParam == "Adios") {
        return 1
    } else
        return 2
}

/**
 * En este caso simplificamos la devolución de la evaluación del if
 * Esto solo puede realizarse así cuando cada resultado de la sentencia contiene una unica operación
 * en la que se obtiene el resultado del tipo a devolver
 * */
fun ifAndIfElseMoreSimplified(myParam: String): Int {
    return if (myParam == "Hola") 0 else if (myParam == "Adios") 1 else 2
}

/**
 * Tambien podemos igualar la función de forma que todos los resultados de la sentencia sean
 * del mismo tipo. También es una función con retorno, pero esta vez no es necesario especificar
 * explicitamente el tipo a devolver.
 * */
fun ifAndIfElseMoreMoreSimplified(myParam: String) =
    if (myParam == "Hola") 0 else if (myParam == "Adios") 1 else 2

/**
 * Podemos incluso crear una función que evalue una condición sin usar un if
 * En este caso sería una devolución Boolean, que que estamos evaluando si
 * el parámetro de la función es igual a un valor esperado.
 * Por lo que devolvería un true o un false
 * */
fun ifAndIfElseMoreMoreMoreSimplified(myParam: String) = myParam == "Hola"

/**
 * Así creamos una clase, esta también podría aceptar parámetros.
 * */
class MyClass() {
    val myName = "MyClass"
    fun myPublicFunction(): String = "Hola, soy una función"
}

//Esta es una función simple sin parámetros y sin retorno
fun calledClassMyClass() {
    MyClass()

    //Si quemeremos usar la classe en várias ocasiones debemos instanciarla. No es necesario expecificar el tipo
    val myClass: MyClass = MyClass()

    println(myClass.myName)
    println(myClass.myPublicFunction())

}

class Loops() {

    private val myValues = arrayListOf(0, 2, 34, 50, 2, 27)
    //Los loops son muy interesantes para recorrer objetos que contiene otros objetos o para

    fun forLoop() {

        /**
         * Bucle for, en el se recorre un rango de valores representado en esta caso por 0..10
         * Estos bucles permiten modificar los valores y objetos de la lista sobre la que itera,
         * otra forma que permite que hayan fallos.
         * Index es una variable en linea para representar el objeto que se recorre, en este caso 0,1,2,3...
         * Los bucles for son más flexibles, pero tambien pueden ser más peligrosos frente a errores que otros bucles
         * */
        for (index in 0..10) {
            println("Soy un bulce y este es mi indice $index")
        }

        /** Tambien podemos recorrer un objeto tipo array, list, set...
         *
         * Los bucles for que permiten modificar el objeto sobre el que iternan, lo que podría llevar a
         * un caso de error por iteración.
         * En este caso usamos el operador < para evitar alcanzar la numeración del úiltimo elemento, recordando
         * que las indexaciones empiezan por 0, pero si contamos los objetos tendremos siempre un elemento más.
         * */
        for (value in 0..<myValues.size) {
            myValues[value] = 4
            println(value)
            myValues.remove(value) // est podría provocar un error.
        }

    }

    /**
     * Tambien existe el bucle forEach, muy similar y con el mismo fin que el bucle for.
     * Los bucles forEach son más cerrados y no permiten mutabilidad, por lo que es más seguro
     * su uso, evitando errores típicos de iteración.
     * En este caso es mas seguro su utilización, ya que solo se recorreran los objetos almacenados
     * en el array, y al no definir unos indices de inicio y fin, es más dificil que este provoque un
     * error por indexación, es decir, que intente buscar en un indice que no exista.
     * */
    fun forEachLoop() {

        //Forma simple de representar un bucle forEach
        //index e
        for (value in myValues) {
            println(value)
        }

        //Representación en forma de Lamda. Una lamba, en pocas palabras, es un objeto que solo hace una cosa,
        myValues.forEach { value ->
            println(value)
        }

        //Tambien podemos crear bucles forEach indexados en forma de lambda
        myValues.forEachIndexed { index, value ->
            println("En el indice $index se encuentra el valor $value")
        }

        //podemos incluso crear bucles forEach sobre rangos
        (0..100).forEach { value ->
            println(value)
        }

        /**
         * Una forma muy simplicada, aunque ya se trata de un nivel más avanzado, es pasarle al propio
         * bucle una lambad como operación.
         * Parece algo absurdo, pero puede simplificar mucho el código a escribir.
         * */

        fun printer(num: Int) {
            println(num)
        }

        myValues.forEach(::printer)

    }

    /**
     * Bucles while y doWhile.
     * Estos bulces pueden ser muy peligrosos, ya que si no controlamos adecuadamente la condición que hace
     * que nuestro código salga de ellos, podriamos tener un bucle infinito, con lo que ello conlleva.
     * */

    //En el bucle while realizamos una serie de acciones meintra una condición se mantega a true.
    //Si al llegar al bucle while la condición no se cumple, no se entra a este y se continua la ejecución
    fun whileLoop() {

        var count = 0
        while (count < 10) {
            count = count + 1
            print("Seguimos en el bucle while. La condición vale ${count < 10}")
        }

        //Extra: Las operaciones aritmeticas simples se pueden representar muy fácilmente en kotlin
        fun arithmetics() {
            var value = 1
            //sumar 1
            value++

            //Restar 1
            value--

            //Sumar x (10 en este caso)
            value+= 10

            //Restar x
            value-= 10

            //multiplicar por x
            value*= 2

            //Dividir entre x
            value/= 2

            //obetener resto de la división entre x
            value%= 2

        }

    }

    //En el bucle doWhile sucede lo mismo con la condición, hayq ue controlarla correctamente.
    //La diferencia reside en que el código siempre va a antrar, al menos una vez, en el bucle
    //y saldrá de este cuando la condición no se cumpla
    fun doWhileLoop() {
        var value = 10

        do {
            value--
            println("Seguimos en bulce doWhile y la condición es ${value <= 0}")
        } while (value >= 0)
        //Observa que he usado el >= y no solo el == 0, porque si por cualquier razón
        //la modificación de la condición no pasase por cero, esta pasaría a ser negativa y el búcle
        //sería infinito hasta provocar el crash
    }


}


//Es muy importante aprender la situaciones en las que debemos controlar los posibles errores que puedan
//surgir en tiempo de ejecución, como podría ser algo tansimple como intentar leer un fichero.txt
//y que este no exista o que no tengamos su path correcto.


class ErrorClass() {

    //En esta función vamos a intentar leer un fichero que está en la misma ruta que nuestro
    // fichero de código y como no existe provocaría un error que debe ser controlado.
    fun readFile() {
        val file = File("com/softyorch/retosdeprogramacion/challenges/fichero.txt")
        var text = ""

        //Para controlar esto errores que no podemos evitar en tiempo de compilación
        //Exsiten el control Try Catch Finally
        try {

            //En try colocamos el código que puede alvergar el error en tiempo de compilación
            text = file.readText()

        } catch (error: Exception) {

            //En catch lo que queremos que haga el código en caso de fallo
            text = "Error al leer el fichero $error" //podemos usar la variable en linea que recoge el error sufrido

        } finally {

            //En finaly podemos hacer que pase lo que pase, cuando termine la ejecución anterior se
            //lea el siguiente código
            println(text)

        }

    }

}

//Existen muchas más objetos y métodos en kotlin, como los interface, las funciones inline,
// las funciones scope, las lambdas... te animo a que indagues sobre ello, es un lenguaje
// muy amigable y muy potente, que a mi particularmente me encanta.
// Aquí tienes el enlace a su web oficial https://kotlinlang.org

/** Muchas gracias */





