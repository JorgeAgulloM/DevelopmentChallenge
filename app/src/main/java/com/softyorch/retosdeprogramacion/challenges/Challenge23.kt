package com.softyorch.retosdeprogramacion.challenges

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

/*
 * Realiza una conexión desde el lenguaje que hayas seleccionado a la siguiente
 * base de datos MySQL:
 * - Host: mysql-5707.dinaserver.com
 * - Port: 3306
 * - User: mouredev_read
 * - Password: mouredev_pass
 * - Database: moure_test
 *
 * Una vez realices la conexión, lanza la siguiente consulta e imprime el resultado:
 * - SELECT * FROM `challenges`
 *
 * Se pueden usar librerías para realizar la lógica de conexión a la base de datos.
 */

fun dbConnector() {
    connectToDb()?.let { getChallenges(it) }
}

private const val HOST = "mysql-5707.dinaserver.com"
private const val PORT = "3306"
private const val USER = "mouredev_read"
private const val PASS = "mouredev_pass"
private const val DB = "moure_test"

private fun getChallenges(connection: Connection) {
    val sql = "SELECT * FROM `challenges`"
    val statement = connection.createStatement()
    val result = statement.executeQuery(sql)

    while (result.next()) {
        result.apply {
            val id = getString("id")
            val name = getString("name")
            val difficulty = getString("difficulty")
            val date = getString("date")
            println("$id - nombre: $name dificultad: $difficulty fecha: $date")
        }
    }
}

private fun connectToDb(): Connection? {
    val url = "jdbc:mysql://$HOST:$PORT/$DB?serverTimezone=Europe/Madrid"
    return try {
        DriverManager.getConnection(url, USER, PASS)
    } catch (e: SQLException) {
        println(e.printStackTrace())
        null
    }
}