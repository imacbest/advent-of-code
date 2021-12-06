package nl.imacbest.day6

import nl.imacbest.utils.readFileToStringList
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@ExperimentalTime
internal class Day6Test {
    private val day6 = Day6()

    @Test
    fun `Should calculate fish after 18 days with sample data`() {
        val input = readFileToStringList("day6/sample_input.txt")
        val result = day6.calculateFish(input, 18)
        assertEquals(26, result)
    }

    @Test
    fun `Should calculate fish after 80 days with puzzle data`() {
        val input = readFileToStringList("day6/puzzle1.txt")
        val result = day6.calculateFish(input, 80)
        assertEquals(383160, result)
    }

    @Test
    fun `Should calculate fish after 265 days with sample data`() {
        val input = readFileToStringList("day6/sample_input.txt")
        val (result, elapsed) = measureTimedValue {
            day6.calculateFish(input, 256)
        }
        assertEquals(26984457539, result)
        println("Time: $elapsed")

    }

    @Test
    fun `Should calculate fish after 256 days with puzzle data`() {
        val input = readFileToStringList("day6/puzzle1.txt")
        val (result, elapsed) = measureTimedValue {
            day6.calculateFish(input, 256)
        }
        assertEquals(1721148811504, result)
        println("Time: $elapsed")
    }
}