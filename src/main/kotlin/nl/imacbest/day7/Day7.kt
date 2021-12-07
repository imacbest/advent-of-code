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
        val calculatedFuel = IntArray(positions.maxOf { it })
        calculatedFuel.indices.forEach { i ->
            calculatedFuel[i] = positions.sumOf { it ->
                abs(i - it) * (abs(i - it) + 1) / 2
            }
        }
        return calculatedFuel.minOf { it }
    }
}