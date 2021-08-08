package com.laval.lavalliere.kotlin

data class Student(val name: String, val age: Int)

fun getStudents() : List<Student> {
    return listOf(
        Student("Ginger", 19),
        Student("Michael", 23),
        Student("Maria", 20),
        Student("Joe", 39),
        Student("Bob", 16)
    )
}

fun main(args: Array<String>) {
    val students = getStudents()
    val combos = students.map{a -> a.name + " : "+ a.age}
    println("Combos: " + combos)

    // if the lambda has only one parameter, we can make it even shorter by eliminating
    // its arguments, altogether. When there is only one parameter, we can simply use the default of it.
    // The default parameter doesn't need to be passed in, so in this case, we can just say it.age.
    println("The oldest student ${students.maxByOrNull { it.age }}")

    val studentsWithLongNames = students.filter{ it.name.length > 5 }
    println("Long names: " + studentsWithLongNames)

    println("The student with the shortest name : ${students.minByOrNull { it.name.length }}")
    val shortName = students.minByOrNull { it.name.length }
    if(shortName != null) {
        val studentsWithShortNames = students.filter { it.name.length == shortName.name.length }
        println("Short names: $studentsWithShortNames")
    }
}

