package nl.imacbest.day5

import nl.imacbest.utils.readFileToStringList
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day5Test {
    private val day5 = Day5()

    @Test
    fun `Should calculate number of intersecting lines that cross twice from sample data`() {
        val input = readFileToStringList("day5/sample_input.txt")
        val result = day5.calculateIntersectingLinePoints(input)
        assertEquals(5, result)
    }

    @Test
    fun `Should calculate number of intersecting lines that cross twice from puzzle data`() {
        val input = readFileToStringList("day5/puzzle1.txt")
        val result = day5.calculateIntersectingLinePoints(input)
        assertEquals(8060, result)
    }

    @Test
    fun `Should calculate number of intersecting lines that cross twice with diagonal from sample data`() {
        val input = readFileToStringList("day5/sample_input.txt")
        val result = day5.calculateIntersectingLinePoints(input, false)
        assertEquals(12, result)
    }

    @Test
    fun `Should calculate number of intersecting lines that cross twice  with diagonal from puzzle data`() {
        val input = readFileToStringList("day5/puzzle1.txt")
        val result = day5.calculateIntersectingLinePoints(input, false)
        assertEquals(-1, result)
    }
}