package com.laval.lavalliere.kotlin

import kotlin.time.seconds

// Stream ABIs are becoming increasingly popular.
// There is Microsoft's Lync, streams
// in Java and Scala and now sequences in Kotlin.

fun sequences() {
    val students = getStudents()
    val sqStudents = students.drop(1).take(3).toList()
    println("Sequenced Students: " + sqStudents)

    val numbers = generateSequence(100) { it + 1 }
    println("Numbers: " + numbers.drop(5).take(20).toList())

    val squares = generateSequence(1) { it + 1 }.map{it * it}
    val evenSquares = squares.filter { it % 2 == 0 }
    println("Even squares: " + evenSquares.take(5).toList())

    val fib = generateSequence(1 to 1) { it.second to it.first + it.second }.map{ it.first }
    println("Fibonnaci: " + fib.take(15).toList())
}

// Another example for fibonacci
fun fibonacci(): Sequence<Int> {
    // fibonacci terms
    // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, ...
    return generateSequence(Pair(0, 1), { Pair(it.second, it.first + it.second) }).map { it.first }
}
// println(fibonacci().take(10).toList()) // [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]

fun main(args : Array<String>) {
    sequences()
}