package nl.imacbest.day1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day1Test {
    private val day1: Day1 = Day1()

    @Test
    fun `Should give back times the input increased`() {
        val input = listOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)
        val result = day1.calculateHigherThanPreviousValue(input)
        assertEquals(7, result)
    }

    @Test
    fun `Should give sliding sum results back`() {
        val input = listOf(607, 618, 618, 617, 647, 716, 769, 792)
        val result = day1.calculateHigherWithSlidingWindow(input, 3)
        assertEquals(5, result)
    }
}