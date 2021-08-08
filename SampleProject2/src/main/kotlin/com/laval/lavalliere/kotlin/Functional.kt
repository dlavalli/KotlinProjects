package com.lavalliere.daniel.kotlin;

import org.funktionale.collections.destructured
import org.funktionale.composition.compose
import org.funktionale.composition.forwardCompose
import org.funktionale.currying.*
import org.funktionale.partials.partially1
import org.funktionale.partials.partially3
import org.funktionale.memoization.memoize

// Now what we're doing is we're creating a list of numbers, one, two, and three,
// and we're going to apply destructured extension method
// from out of the funKTionale library to it to get the values for head and tail.

fun functional() {
    val (head, tail) = listOf(1, 2, 3).destructured()
    println("Head = $head and tail = $tail")

    val add5 = {i: Int -> i + 5}
    val multiplyBy2 = {i: Int -> i * 2}
    val multiplyBy2AndAdd5 = add5 compose multiplyBy2
    val composeResult = multiplyBy2AndAdd5(10)
    println("multiplyBy2AndAdd5(10) = $composeResult")

    // The forwardCompose method applies the functions
    // in the opposite order. It uses the results of the first function
    // as the parameters for the second.
    val add5andMultiplyBy2 = add5 forwardCompose multiplyBy2
    val forwardComposeResult = add5andMultiplyBy2(10)
    println("add5andMultiplyBy2(10) = $forwardComposeResult")

    // Currying
    val sum3ints = {x: Int, y: Int, z: Int -> x + y + z}

    // Now, curried is going to return a function that takes an Int
    // that returns another function that takes an Int, that returns another function
    // that takes an Int, and finally, returns an Int.
    val curried: (Int) -> (Int) -> (Int) -> Int = sum3ints.curried()

    // and keep in mind, what we're doing is we're actually making three separate function calls.
    // We're calling the first function with a two, the second function with a four,
    // and the third function with a six.
    val cur = curried(2)(4)(6)
    println("curried(2)(4)(6) = $cur")

    // Take note again of how we called curry. We actually are calling three functions.
    // Then, we display the results to the terminal


    // A partial application takes a function that accepts some number of arguments,
    // binding values to one or more of those arguments, and returning a new function
    // that only accepts the remaining unbound arguments.
    val prefixAndPosfix: (String, String, String) -> String =
        {prefix: String, x: String, postfix: String -> "${prefix}${x}${postfix}"}

    // So if you remember from the definition of prefixAndPosFix, it wants three parameters,
    // and we're going to tell it, hey, you're only going to get part of what you want.
    // And we're going to supply the missing parameter since prefixAndBang only gives it two
    val prefixAndBang: (String, String) -> String = prefixAndPosfix.partially3("!")
    val hello: (String) -> String = prefixAndBang.partially1("Hello, ")
    println(hello("Funktionale"))
}

fun memo() {
    var fibonacci: (Long) -> Long = {it }

    // we're doing a shortcut out of a fibonacci calculation.  If the value
    // of the fibonacci index is less than two, you return the value
    // Otherwise you're going to recursively call it.
    fibonacci = { n: Long ->
        if (n < 2) n else fibonacci(n - 1) + fibonacci(n - 2)
    }

    // Now, the difference here is once we finish creating
    // this lambda method, we're going to do a .memoize on it.
    var m: (Long) -> Long = {it}
    m = { n: Long ->
        if (n < 2) n else m(n - 1) + m(n - 2)
    }.memoize()

    println("Calling fib: " + timeElapsed {fibonacci(40)} + " ms")
    println("Calling memoized version" + timeElapsed{ m(40)} +" ms")
}

fun timeElapsed(body: ()-> Unit): Long {
    val start = System.currentTimeMillis()

    // So, we're going to get the time right now. And we're going to call the method that
    // we passed in-- In this case it's the fibonacci calculation. That's our body
    body()

    val end = System.currentTimeMillis()
    return end - start
}

fun main(args: Array<String>){
    // functional()

    memo()
}