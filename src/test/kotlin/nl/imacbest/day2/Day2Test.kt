package nl.imacbest.day2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day2Test {

    private val day2: Day2 = Day2()

    @Test
    fun `Should get back multiplication of dept and horizontal position`() {
        val input = listOf("forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2")
        val result = day2.calculateMovement(input)
        assertEquals(150, result)
    }

    @Test
    fun `Should calculate based on aim`() {
        val input = listOf("forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2")
        val result = day2.calculateAim(input)
        assertEquals(900, result)
    }
}