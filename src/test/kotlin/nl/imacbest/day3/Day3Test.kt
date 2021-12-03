package nl.imacbest.day3

import nl.imacbest.utils.readFileToStringList
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day3Test {
    private val day3 = Day3()

    @Test
    fun `Should calculate power consumption based on diagnostic report`() {
        val input = listOf(
            "00100",
            "11110",
            "10110",
            "10111",
            "10101",
            "01111",
            "00111",
            "11100",
            "10000",
            "11001",
            "00010",
            "01010"
        )
        val result = day3.calculatePowerConsumption(input)
        assertEquals(198, result)
    }

    @Test
    fun `Should calculate life supporting rating based on diagnostic report`() {
        val input = listOf(
            "00100",
            "11110",
            "10110",
            "10111",
            "10101",
            "01111",
            "00111",
            "11100",
            "10000",
            "11001",
            "00010",
            "01010"
        )
        val result = day3.findLifeSupportRating(input)
        assertEquals(230, result)
    }

    @Test
    fun `Should calculate oxygen rating based on diagnostic report`() {
        val input = listOf(
            "00100",
            "11110",
            "10110",
            "10111",
            "10101",
            "01111",
            "00111",
            "11100",
            "10000",
            "11001",
            "00010",
            "01010"
        )
        val result = day3.findOxygenRating(input, 0)
        assertEquals(23, result)
    }

    @Test
    fun `Should calculate co2 rating based on diagnostic report`() {
        val input = listOf(
            "00100",
            "11110",
            "10110",
            "10111",
            "10101",
            "01111",
            "00111",
            "11100",
            "10000",
            "11001",
            "00010",
            "01010"
        )
        val result = day3.findCo2Rating(input, 0)
        assertEquals(10, result)
    }

    @Test
    fun `When day 3 puzzle 1 should result correct result`() {
        val inputPuzzle1 = readFileToStringList("day3/puzzle1.txt")
        val puzzle1Result = day3.calculatePowerConsumption(inputPuzzle1)
        assertEquals(3309596, puzzle1Result)
    }

    @Test
    fun `When day 3 puzzle 2 should result correct result`() {
        val inputPuzzle1 = readFileToStringList("day3/puzzle1.txt")
        val puzzle2Result = day3.findLifeSupportRating(inputPuzzle1)
        assertEquals(2981085, puzzle2Result)
    }


}