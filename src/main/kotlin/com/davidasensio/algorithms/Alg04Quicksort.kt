package com.davidasensio.algorithms

import kotlin.system.measureTimeMillis

class Alg04Quicksort(val verbose: Boolean = true) {
    companion object {
        fun runQuicksort(list: List<Int>) {
            var output = ""
            val time = measureTimeMillis {
                val quicksortedList = Alg04Quicksort().quicksort(ArrayList(list))
                output = "Quicksort applied:\nFrom: $list\nTo: $quicksortedList"

            }
            println("$output\nin $time ms")
        }
    }

    private fun quicksort(list: List<Int>): List<Int> {
        return if (list.size <= 1) {
            // Base case
            list
        } else {
            // Recursive case
            val pivot = list[list.size / 2]
            val equal = list.filter { it == pivot }
            val less = list.filter { it < pivot }
            val greater = list.filter { it > pivot }
            quicksort(less) + equal + quicksort(greater)
        }
    }
}