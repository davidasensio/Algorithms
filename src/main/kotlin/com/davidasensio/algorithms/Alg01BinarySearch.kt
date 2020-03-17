package com.davidasensio.algorithms

import kotlin.system.measureTimeMillis

class Alg01BinarySearch(val verbose: Boolean = true) {
    companion object {
        fun runBinarySearch() {
            var output = ""
            val time = measureTimeMillis {
                val list = (0..10000000 step 7).toList()
                val item = 54005
                val (position, attempts) = Alg01BinarySearch(verbose = true).binarySearch(list, item)
                output = "The binary search algorithm found the item at position $position in $attempts attempts"
            }
            println("$output in $time ms")
        }
    }

    private fun binarySearch(list: List<Int>, item: Int): Pair<Int, Int> {
        var low = 0
        var high = list.size - 1
        var attempts = 0

        while (low <= high) {
            val mid = (low + high) / 2
            val guess = list[mid]
            attempts++
            if (verbose) {
                println("Trying to guess with $guess")
            }

            if (guess == item) {
                return Pair(mid, attempts)
            }

            if (guess > item) {
                high = mid - 1
            } else {
                low = mid + 1
            }
        }

        return Pair(-1, attempts)
    }
}