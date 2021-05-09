package com.lavalliere.daniel.kotlin

interface Vehicule {
    val MakeName: String
    fun go() {
        println("Vroom, vroom")
    }
    fun stop() {
        println("Screehing")
    }
    fun getMpg(): Int {
        return 50
    }
    fun getDoors(): Int
}