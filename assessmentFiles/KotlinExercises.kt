package com.example.myapplication

/**
 * Exercise 1 from https://kotlinlang.org/docs/kotlin-reference.pdf from page 65
 *
 * Exercise description: Complete the code to make the program print "Mary is 20 years old" to standard output
 * Author of this solution: Patryk Klimek
 */
fun exercise1() {
    val name = "Mary"
    val age = 20
    println("$name is $age years old")
}

/**
 * Exercise 2 from https://kotlinlang.org/docs/kotlin-reference.pdf from page 66
 *
 * Exercise description: Explicitly declare the correct type for each variable
 * Author of this solution: Patryk Klimek
 */
fun exercise2() {
    val a: Int = 1000
    val b: String = "log message"
    val c: Double = 3.14
    val d: Long = 100_000_000_000_000
    val e: Boolean = false
    val f: Char = '\n'
}

/**
 * Exercise 3 from https://kotlinlang.org/docs/kotlin-reference.pdf from page 71
 *
 * Exercise description: You have a list of “green” numbers and a list of “red” numbers.
 * Complete the code to print how many numbers there are in total
 * Author of this solution: Patryk Klimek
 */
fun exercise3() {
    val greenNumbers = listOf(1, 4, 23)
    val redNumbers = listOf(17, 2)
    val total: Int = greenNumbers.count() + redNumbers.count()
    println(total)
}

/**
 * Exercise 4 from https://kotlinlang.org/docs/kotlin-reference.pdf from page 72
 *
 * Exercise description: You have a set of protocols supported by your server.
 * A user requests to use a particular protocol. Complete the program to check whether
 * the requested protocol is supported or not (isSupported must be a Boolean value)
 * Author of this solution: Patryk Klimek
 */
fun exercise4() {
    val SUPPORTED = setOf("HTTP", "HTTPS", "FTP")
    val requested = "smtp"
    val isSupported = requested in SUPPORTED
    println("Support for $requested: $isSupported")
}

/**
 * Exercise 5 from https://kotlinlang.org/docs/kotlin-reference.pdf from page 72
 *
 * Exercise description: Define a map that relates integer numbers from 1 to 3 to
 * their corresponding spelling. Use this map to spell the given number
 * Author of this solution: Patryk Klimek
 */
fun exercise5() {
    val number2word = mapOf(1 to "one", 2 to "two", 3 to "three")
    val n = 2
    println("$n is spelt as ${number2word[n]}")
}

/**
 * Exercise 6 from https://kotlinlang.org/docs/kotlin-reference.pdf from page 75
 *
 * Exercise description: Using a when expression, update the following program so that when you
 * input the names of GameBoy buttons, the actions are printed to output
 * Author of this solution: Patryk Klimek
 */
fun exercise6() {
    val button = "A"
    println(
        when (button) {
            "A" -> println("Yes")
            "B" -> println("No")
            "X" -> println("Menu")
            "Y" -> println("Nothing")
            else -> println("There is no such button")
        }
    )
}

/**
 * Exercise 7 from https://kotlinlang.org/docs/kotlin-reference.pdf from page 76
 *
 * Exercise description: You have a program that counts pizza slices until there’s a whole pizza
 * with 8 slices. Refactor this program in two ways
 * Variation first, with while loop
 * Author of this solution: Patryk Klimek
 */
fun exercise7a() {
    var pizzaSlices = 0
    while (pizzaSlices <= 7){
        println("There's only $pizzaSlices slice/s of pizza :(")
        pizzaSlices++
    }

    println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
}

/**
 * Exercise 7 from https://kotlinlang.org/docs/kotlin-reference.pdf from page 76
 *
 * Exercise description: You have a program that counts pizza slices until there’s a whole pizza
 * with 8 slices. Refactor this program in two ways
 * Variation second, with do while loop
 * Author of this solution: Patryk Klimek
 */
fun exercise7b() {
    var pizzaSlices = 0
    do {
        pizzaSlices++
        println("There's only $pizzaSlices slice/s of pizza :(")
    } while (pizzaSlices < 7)

    pizzaSlices++
    println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
}

/**
 * Exercise 8 from https://kotlinlang.org/docs/kotlin-reference.pdf from page 77
 *
 * Write a program that simulates the Fizz buzz game. Your task is to print numbers from 1 to 100
 * incrementally, replacing any number divisible by three with the word "fizz",
 * and any number divisible by five with the word "buzz". Any number divisible by both 3 and 5
 * must be replaced with the word "fizzbuzz"
 * Author of this solution: Patryk Klimek
 */
fun exercise8() {
    for (num in 1..100) {
        when {
            num % 15 == 0 -> println("fizzbuzz")
            num % 5 == 0 -> println("buzz")
            num % 3 == 0 -> println("fizz")
            else -> println(num)
        }
    }
}

/**
 * Exercise 9 from https://kotlinlang.org/docs/kotlin-reference.pdf from page 77
 *
 * Exercise description: You have a list of words. Use for and if to print only the words
 * that start with the letter l
 * Author of this solution: Patryk Klimek
 */
fun exercise9() {
    val words = listOf("dinosaur", "limousine", "magazine", "language")
    for (word in words) {
        if (word.startsWith('l')) {
            println(word)
        }
    }
}

/**
 * Exercise 10 from https://kotlinlang.org/docs/kotlin-reference.pdf from page 87
 *
 * Exercise description: Define a data class Employee with two properties: one for a name,
 * and another for a salary. Make sure that the property for salary is mutable, otherwise you won’t
 * get a salary boost at the end of the year! The main function demonstrates how you can use
 * this data class
 * Author of this solution: Patryk Klimek
 */
data class Employee(val name: String, var salary: Int)
fun main() {
    val emp = Employee("Mary", 20)
    println(emp)
    emp.salary += 10
    println(emp)
}
