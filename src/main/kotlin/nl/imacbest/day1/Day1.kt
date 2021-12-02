package nl.imacbest.day1

import nl.imacbest.utils.readFileToIntList

class Day1 {
    fun calculateHigherThanPreviousValue(input: List<Int>): Int {
        var incCounter = 0
        var lastVal = input[0]
        input.stream().skip(1)
            .forEachOrdered {
                if (it > lastVal) {
                    incCounter++
                }
                lastVal = it
            }
        return incCounter
    }

    fun calculateHigherWithSlidingWindow(input: List<Int>, window: Int): Int {
        val windowsValues = mutableListOf<Int>()
        var i = 0
        while (i + window <= input.size) {
            var sum = 0
            for (x in 0 until window) {
                sum += input[i + x]
            }
            windowsValues.add(sum)
            i++
        }
        return calculateHigherThanPreviousValue(windowsValues)
    }
}


fun main() {
    val day1 = Day1()
    val inputPuzzle1 = readFileToIntList("day1/puzzle-1.txt")
    val puzzle1Result = day1.calculateHigherThanPreviousValue(inputPuzzle1)
    println("Result day1, puzzle 1: $puzzle1Result")
    val inputPuzzle2 = readFileToIntList("day1/puzzle-2.txt")
    val puzzle2Result = day1.calculateHigherWithSlidingWindow(inputPuzzle2, 3)
    println("Result day1, puzzle 2: $puzzle2Result")
}