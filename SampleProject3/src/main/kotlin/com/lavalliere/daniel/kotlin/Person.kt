package com.lavalliere.daniel.kotlin

// Most of the time the constructor keyword can be omitted.
// It is only needed if the constructor and a visibility or annotation modifier

// class Person constructor(firstName: String, lastName: String)
// class Person (firstName: String, lastName: String) {
class Person internal constructor (firstName: String, lastName: String) {
    init {
        // Do something here if need to initialize something else omit this block completely
        println("Hello from $firstName $lastName")
    }

    constructor (firstName: String, lastName: String, middleName: String)
        : this(firstName, lastName) {
        println("My middle name is $middleName")
    }
}