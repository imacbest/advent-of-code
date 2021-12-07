package nl.imacbest.day7

import kotlin.math.abs

class Day7 {
    fun calculateMostEfficientFuelUse(input: List<String>): Int {
        val positions = input.flatMap { it -> it.split(",") }
            .map { it -> it.trim().toInt() }
        val highestPos = positions.maxOf { it }

        val calculatedFuel = IntArray(highestPos)

        for (i in 0 until highestPos) {
            val sum = positions.sumOf { it -> abs(i - it) }
            calculatedFuel[i] = sum
        }

        return calculatedFuel.minOf { it }
    }

    fun calculateMostEfficientFuelUseWithExponentialFuelBurn(input: List<String>): Int {
        val positions = input.flatMap { it -> it.split(",") }
            .map { it -> it.trim().toInt() }
        val highestPos = positions.maxOf { it }

        val calculatedFuel = IntArray(highestPos)

        for (i in 0 until highestPos) {
            val sum = positions.sumOf { it ->
                val stepSize = abs(i - it)
                stepSize * (stepSize + 1) / 2
            }
            calculatedFuel[i] = sum
        }

        return calculatedFuel.minOf { it }
    }
}