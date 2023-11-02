package com.example.iniciandokotlin

import java.util.Scanner

fun main() {
    var numero = 0
    val numero2 = 10
    contar()
    println(numero2)
    val scanner = Scanner(System.`in`)
    print("ingresa un dia de la semana")

    try {
        val fecha = scanner.nextInt()
        getDias(fecha)
    } catch  (e: Exception){
        print("Debes ingresar un NUMERO del 1 al 7")
    }


}


    // PRACTICANDO BUCLES
    fun contar() {
        for (numero in 0..9) { //RANCK 1.. 9 (ES UN RANGO)
            println(numero)         // se puede colocar !in 1..9 para decir que no este entre ese rango
        }
    }

    fun getDias(dias:Int){
        when(dias){
            1 -> print("lunes")
            2 -> print("martes")
            3 -> print("miercoles")
            4 -> print("jueves")
            5 -> print("viernes")
            6 -> print("sabado")
            7 -> print("domingo")
            else -> print("ese dia no existe")
        }
    }



