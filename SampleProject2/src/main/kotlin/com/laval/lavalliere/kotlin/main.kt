package com.lavalliere.daniel.kotlin

// An example of object decleration
object MySingleton {
    var temperatures = arrayOf(80, 76, 90)
    fun getLastTemperature() = temperatures.last()
}

fun main(args: Array<String>) {
    println("Hello, welcome to kotlin")

    val maxInt: Int = Max(42, 99)
    val maxLong: Long = Max(42L, 99L)
    val maxByte: Byte = Max((42).toByte(), (99).toByte())
    val maxString: String = Max("beta", "alpha")
    println("The max int = $maxInt")
    println("The max long = $maxLong")
    println("The max byte = $maxByte")
    println("The max string = $maxString")



    val person = Person("Sylvain", "Lavalliere")
    val calimerPerson = Person("Daniel", "Lavalliere", "Calimero")

    //  creating an object using its type definition (ie: similar to JSON in javascript)
    val location = object {
        var xPosition = 200
        var yPosition = 400
        fun prinIt() {
            // Curly braces are required because we are giving a property out of location
            println("Position = ($xPosition, $yPosition)")
        }
    }
    location.xPosition = 300
    location.prinIt()

    val temperatures = MySingleton.getLastTemperature()
    println("Last reading: $temperatures degrees")

    val myCar = Car()
    myCar.go()
}