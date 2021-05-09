package com.lavalliere.daniel.kotlin

// Not every type has a compareTo method, only the ones derived from Comparable supports it.
// We must make sure the types implements Comparable by placing an upperbound.
fun <T: Comparable<T>> Max(param1: T, param2: T): T {
    val results = param1.compareTo(param2)
    return if (results > 0) param1 else param2
}