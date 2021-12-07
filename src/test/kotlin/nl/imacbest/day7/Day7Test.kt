package nl.imacbest.day7

import nl.imacbest.utils.readFileToStringList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue


@ExperimentalTime
internal class Day7Test {
    private val day7 = Day7()

    @Test
    fun `Should calculate fuel amount for sample data`() {
        val input = readFileToStringList("day7/sample_data.txt")
        val (result, elapsed) = measureTimedValue {
            day7.calculateMostEfficientFuelUse(input)
        }
        assertEquals(37, result)
        println("Time: $elapsed")
    }

    @Test
    fun `Should calculate fuel amount for puzzle data`() {
        val input = readFileToStringList("day7/puzzle1.txt")
        val (result, elapsed) = measureTimedValue {
            day7.calculateMostEfficientFuelUse(input)
        }
        assertEquals(340987, result)
        println("Time: $elapsed")
    }


    @Test
    fun `Should calculate exponential fuel amount for sample data`() {
        val input = readFileToStringList("day7/sample_data.txt")
        val (result, elapsed) = measureTimedValue {
            day7.calculateMostEfficientFuelUseWithExponentialFuelBurn(input)
        }
        assertEquals(168, result)
        println("Time: $elapsed")
    }

    @Test
    fun `Should calculate exponential fuel amount for puzzle data`() {
        val input = readFileToStringList("day7/puzzle1.txt")
        val (result, elapsed) = measureTimedValue {
            day7.calculateMostEfficientFuelUseWithExponentialFuelBurn(input)
        }
        assertEquals(96987874, result)
        println("Time: $elapsed")
    }
}