package nl.imacbest.day4

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day4Test {

    private val day4 = Day4()

    @Test
    fun `Should return bingo winning score for sample data`() {
        val result = day4.findWinningBingoScore("day4/sample_input.txt")
        assertEquals(4512, result)
    }

    @Test
    fun `Should find vertical bingo`() {
        val result = day4.findWinningBingoScore("day4/verticalBingoSample.txt")
        assertEquals(242, result)
    }

    @Test
    fun `Should return bingo winning score for puzzle data`() {
        val result = day4.findWinningBingoScore("day4/puzzle1.txt")
        assertEquals(25410, result)
    }

    @Test
    fun `Should return bingo winning score for the last board to win with sample data`() {
        val result = day4.findLastWiningBoardScore("day4/sample_input.txt")
        assertEquals(1924, result)
    }

    @Test
    fun `Should return bingo winning score for the last board to win with puzzel`() {
        val result = day4.findLastWiningBoardScore("day4/puzzle1.txt")
        assertEquals(2730, result)
    }
}