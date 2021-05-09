package com.lavalliere.daniel.kotlin

import com.lavalliere.daniel.java.Animal

// Most of the time the constructor keyword can be omitted.
// It is only needed if the constructor and a visibility or annotation modifier

// class Person constructor(firstName: String, lastName: String)
// class Person (firstName: String, lastName: String) {

@Deprecated("Use the animal class instead", ReplaceWith("Animal"))
class Person internal constructor (var firstName: String, var lastName: String) {
    init {
        // Do something here if need to initialize something else omit this block completely
        println("Hello from $firstName $lastName")
    }

    constructor (firstName: String, lastName: String, middleName: String)
        : this(firstName, lastName) {
        println("My middle name is $middleName")
    }
}