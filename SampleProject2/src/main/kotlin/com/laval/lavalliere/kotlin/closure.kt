package com.laval.lavalliere.kotlin

fun closureMaker(): () -> Unit {
    var num = 0
    return { println(num++) }
}

fun main(args: Array<String>) {
    val myCounter1 = closureMaker()
    val myCounter2 = closureMaker()
    myCounter1()
    myCounter1()
    myCounter1()
    myCounter1()
    myCounter2()
    myCounter2()
    myCounter1()

    // Looking at the output, it makes it pretty obvious that each counter
    // has its own copy of the variable num, but this is a function, not a class
    // or an object, so where is the variable kept?
    // The answer is that num is kept in the closure
}