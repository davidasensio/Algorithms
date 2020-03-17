package com.davidasensio.algorithms

import kotlin.system.measureTimeMillis

class Alg02SelectionSort(val verbose: Boolean = true) {
    companion object {
        fun runSelectionSort(list: List<Int>) {
            var output = ""
            val time = measureTimeMillis {
                //val list = arrayListOf<Int>(3, 2, 7, 1, 5)
                val sortedList = Alg02SelectionSort().selectionSort(ArrayList(list))
                output = "Selection sort applied:\nFrom: $list\nTo: $sortedList"
            }
            println("$output\nin $time ms")
        }
    }

    private fun selectionSort(list: ArrayList<Int>): ArrayList<Int> {
        val sortedList = ArrayList<Int>()
        for (i in 0 until list.size) {
            val smallestIndex = findSmallestIndex(list)
            sortedList.add(list[smallestIndex])
            list.removeAt(smallestIndex)
        }
        return sortedList
    }

    private fun findSmallestIndex(list: List<Int>): Int {
        var smallest = list[0]
        var smallestIndex = 0
        list.forEachIndexed { index, value ->
            if (value < smallest) {
                smallest = value
                smallestIndex = index
            }
        }
        return smallestIndex
    }
}