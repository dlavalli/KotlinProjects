package com.laval.lavalliere.kotlin

import javax.print.attribute.standard.MediaSize

interface Matcher<T> {
    fun test(lhs: T): Unit

    // Kotlin provides infix notation with which we can call a function with the class object
    // without using a dot and parentheses across the parameter. Using infix function provides
    // more readability to a function similar to other operators like in , is , as in Kotlin.
    infix fun or(other: Matcher<T>): Matcher<T> = object : Matcher<T> {
        override fun test(lhs: T) {
            try {
                this@Matcher.test(lhs)
            } catch (ex: RuntimeException) {
                other.test(lhs)
            }
        }
    }

    // Next, we define two versions of a should method. Again, what we're trying to do is make things read like English.
    // One works with single types, and the other works on collections. Both are going to use the infix keyword.
    // It allows us to move the function in between its parameters. This is similar to the what the plus operator
    // sits between its two operands.

    // This is the should implementation for a single object
    infix fun <T> T.should(matcher: Matcher<T>) {
        matcher.test(this)
    }

    // This is the should implementation for a collection
    infix fun <T> Collection<T>.should(fn: CollectionMatchers<T>.() -> Unit) {
        val matchers = CollectionMatchers(this)
        matchers.fn()
    }

    class CollectionMatchers<T>(val collection: Collection<T>) {
        fun contain(rhs: T): Unit {
            if (!collection.contains(rhs)) {
                throw java.lang.RuntimeException("Collection did not contain $rhs")
            }
        }

        fun notContain(rhs: T): Unit {
            if (collection.contains(rhs)) {
                throw java.lang.RuntimeException("Collection should not contain $rhs")
            }
        }

        fun haveSizelessThan(size: Int): Unit {
            if (collection.size >= size) {
                throw java.lang.RuntimeException("Collection should have size < than $size")
            }
        }
    }

    fun unitTest() {
        val listOfname = listOf("April", "May", "June")
        listOfname should { notContain("Portia") }
    }
}

