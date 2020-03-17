package com.davidasensio.algorithms

class Alg03Recursion(val verbose: Boolean = true) {
    companion object {
        fun runCountdownRecursively(number: Int) {
            Alg03Recursion().countdown(number)
        }

        fun runTailrecCountdownRecursively(number: Int) {
            Alg03Recursion().tailrecCountdown(number)
        }

        fun runFactorialRecursively(number: Long) {
            val result = Alg03Recursion().factorial(number)
            println("Factorial of $number is $result")
        }

        fun runTailrecFactorialRecursively(number: Long) {
            val result = Alg03Recursion().factorialWithTailRec(number)
            println("Factorial of $number is $result")
        }
    }

    private fun countdown(number: Int) {
        print("$number, ")
        if (number % 1000 == 0) println()

        if (number <= 0) { // Base case
            return
        } else { // Recursive case
            countdown(number - 1)
        }
    }

    private tailrec fun tailrecCountdown(number: Int) {
        print("$number, ")
        if (number % 1000 == 0) println()

        if (number <= 0) { // Base case
            return
        } else { // Recursive case
            tailrecCountdown(number - 1)
        }
    }

    private fun factorial(number: Long): Long {
        return when (number) {
            1L -> 1L // Base case
            else -> number * factorial(number - 1) // Recursive case
        }
    }

    private tailrec fun factorialWithTailRec(number: Long, accum: Long = 1): Long {
        val soFar = number * accum
        return when (number) {
            1L -> soFar
            else -> factorialWithTailRec(number - 1, soFar)
        }
    }
}

/**
 * Introduction to Tailrec
 *   Some algorithms work best when implemented in a recursive manner – where a computation is based on a simpler form of the same computation.
 *   In most programming languages, there is a risk of a stack overflow associated with recursion. There is a limit on the number of nested method calls that can be made in one go, without returning.
 *   If this is an issue, the algorithm can be re-written in an imperative manner, using a traditional loop instead.
 *   Tail recursion is a technique where the compiler can rewrite a recursive method in an imperative manner, assuming that certain rules are met.
 *
 * 2. Rules for Tail Recursion in Kotlin
 *   To implement a function in Kotlin using tail recursion, there is one rule to follow:
 *     the recursive call must be the very last call of the method.
 *   This rule is not as simple to follow as it seems.
 */