package com.davidasensio.algorithms

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet
import kotlin.system.measureTimeMillis

/**
 * This algorithm is for find the nearest shortest path
 */

typealias Graph<T> = HashMap<T, List<T>>

fun <T> Graph<T>.breadthFirstSearch(key: T, isSearched: (T) -> Boolean): Boolean {
    val queue: Deque<T> = LinkedList()
    this[key]?.let {
        queue += it
    }
    val searched = HashSet<T>()

    while (queue.isNotEmpty()) {
        val value = queue.pop()
        if (!searched.contains(value)) {
            if (isSearched(value)) {
                println("Value $value is here!")
                return true
            } else {
                this[value]?.let {
                    queue += it
                }
                searched.add(value)
            }
        }
    }
    return false
}

class Alg06BreadthFirstSearch(val verbose: Boolean = true) {
    companion object {
        private const val MANGO_SELLER_FIRST_LETTER = "B"
        fun runBreadthFirstSearch() {
            var output = ""
            val time = measureTimeMillis {
                val instance = Alg06BreadthFirstSearch()
                instance.breadthFirstSearch()
                output = "BreadthFirstSearch applied in graph:\n ${instance.getGraphData().toString()}"
            }
            println("$output\nin $time ms")
        }
    }

    private fun personIsSeller(name: String): Boolean = name.startsWith(MANGO_SELLER_FIRST_LETTER)

    fun breadthFirstSearch() {
        val graph = getGraphData()
        graph.breadthFirstSearch("you", ::personIsSeller)
    }

    /**
     * Graph with you, your neighbours and the neighbours of your neighbours. Sara is the Mango seller because his name starts with S
     */
    private fun getGraphData(): Graph<String> {
        val graph = HashMap<String, List<String>>()
        graph["you"] = listOf("Maria")
        graph["Maria"] = listOf("Elias", "Ana", "Jesus")
        graph["Elias"] = listOf("Paco", "Margarita")
        graph["Jesus"] = listOf("Gustavo", "Arturo")
        graph["Ana"] = listOf("Blanca", "Pepa")
        graph["Paco"] = listOf("Juan")
        graph["Juan"] = listOf("")
        graph["Margarita"] = listOf("Rosa")
        graph["Rosa"] = listOf("")
        graph["Gustavo"] = listOf("Teresa")
        graph["Teresa"] = listOf("Sara")
        graph["Sara"] = listOf("")
        graph["Arturo"] = listOf("")
        graph["Blanca"] = listOf("Violeta")
        graph["Violeta"] = listOf("")
        return graph
    }
}