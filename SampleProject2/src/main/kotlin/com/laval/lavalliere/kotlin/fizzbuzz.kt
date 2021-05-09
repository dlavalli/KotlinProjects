package com.lavalliere.daniel.kotlin

fun main(args: Array<String>) {
    for(num in 1.rangeTo(105)) {
        when {
            // (num % 15 == 0) -> println("${num} : fizz buzz")  // Another possible way
            ((num % 3 == 0) && (num % 5 == 0)) -> println("${num} : fizz buzz")
            (num % 3 == 0) -> println("${num} : fizz")
            (num % 5 == 0) -> println("${num} : buzz")
        }
    }

    println("Fizz Buzz")

    // Create a loop to display the numbers 1 to 105
    // after the number
    //  print "fizz" if the number is divisible by 3
    //  print "buzz" if the number is divisible by 5
    //  print "fizz buzz" if the number is divisible by 3 and 5

    // Add your solution here

}
