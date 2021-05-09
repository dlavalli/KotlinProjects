package com.lavalliere.daniel.kotlin

import com.laval.lavalliere.kotlin.Position
import com.lavalliere.daniel.java.Animal
import java.beans.PersistenceDelegate

// An example of object decleration
object MySingleton {
    var temperatures = arrayOf(80, 76, 90)
    fun getLastTemperature() = temperatures.last()
}

fun javaInteop() {
    val Frisky = Animal("Frisky", "Cat", 10)
    println(Frisky.show())
    val Fido = Animal("Fido", "Dog", 30)
    println(Fido.show())

    // Frisky.kind = "monkey"   -  Not allowed since a val   (ie:  final string)
    Frisky.weight = 15
    println(Frisky.show())
}

fun useOverload() {
    val p1 = Position(200, 100)
    val p2 = Position(1000, 2000)
    val p3 = p1 + p2
    println(p3)

    // An example of destructuring
    // And what this is going to do is it's going to create two variables
    // for us, xPosition and yPosition, and pull their values off of the data class p1.
    // Kotlin gets the value for each variable based on the order that the properties were created in their constructor.
    // So the first property gets assigned to the first variable, the second property gets assigned to the second variable, and so on.
    val (xPosition, yPosition) =  p1
    println("xPosition: $xPosition yPosition: $yPosition")

    // Underneath the covers, Kotlin creates some operators. The name of the first operator is component1,
    // the second is component2, and so forth. In the position data class, we can access these operator functions directly.
    println("c1 = xPosition: ${p1.component1()}")
}

// For non data classes, destructuring is available, but you must wire up the operator components yourself
class Point(val x:Int, val y:Int, val z:Int) {
    operator fun component1(): Int = x
    operator fun component2(): Int = y
    operator fun component3(): Int = z
}
fun showComponents() {
    val myPoint = Point(5000, 100, 2000)
    val (myX, myY, myZ) = myPoint
    println("myX: $myX myY: $myY myZ: $myZ")
}

fun main(args: Array<String>) {
    println("Hello, welcome to kotlin")

    val joe = Person("Joe", "Smith")
    val kClass = joe.javaClass.kotlin
    println("Simple name ${kClass.simpleName}")
    for (name in kClass.members) {
        println("Class member: ${name.name}")
    }

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

    javaInteop()
    useOverload()
    showComponents()
}