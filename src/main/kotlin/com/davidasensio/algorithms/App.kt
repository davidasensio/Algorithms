package com.davidasensio.algorithms

import java.lang.Exception
import kotlin.system.exitProcess

/**
 * Project with sample algorithms from the book of Aditya Y. Bhargava "Grokking Algorithms"
 * March 2020
 */
class App {
    val greeting: String
        get() {
            return "Kotlin project just for implement several algorithms."
        }
}

fun main(args: Array<String>) {
    println(App().greeting)

    println("")
    println("Select your algorithm:")
    println("")
    println("    1. Binary Search")
    println("    2. Selection Sort")
    println("    3. Recursion (countdown)")
    println("    4. Recursion tailrec (countdown)")
    println("    5. Recursion (factorial)")
    println("    6. Recursion tailrec (factorial)")
    println("    7. Quicksort")
    println("    8. Breadth First Search")
    println("")
    println("Type your option and press ENTER > ")
    val stringInput = readLine()!!

    val option = try {
        stringInput.toInt()
    } catch (e: Exception) {
        0
    }
    val shuffledList = (0..10000).toList().shuffled()
    when (option) {
        1 -> Alg01BinarySearch.runBinarySearch()
        2 -> Alg02SelectionSort.runSelectionSort(shuffledList)
        3 -> Alg03Recursion.runCountdownRecursively(700)
        4 -> Alg03Recursion.runTailrecCountdownRecursively(700)
        5 -> Alg03Recursion.runFactorialRecursively(5)
        6 -> Alg03Recursion.runTailrecFactorialRecursively(5)
        7 -> Alg04Quicksort.runQuicksort(shuffledList)
        8 -> Alg06BreadthFirstSearch.runBreadthFirstSearch()
        else -> exitProcess(0)
    }
}


