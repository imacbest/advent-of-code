package nl.imacbest.day3

import nl.imacbest.utils.readFileToStringList


class Day3 {
    fun calculatePowerConsumption(input: List<String>): Int {
        val columns: Array<StringBuilder?> = arrayOfNulls<StringBuilder>(input[0].length)
        for (i in 0 until columns.count()) {
            columns[i] = StringBuilder()
        }
        for (i in 0 until columns.count()) {
            for (y in input.indices) {
                columns[i]!!.append(input[y][i])
            }
        }
        val mostCommonString = getCommonValue(columns = columns, flip = false)
        val leastCommonString = getCommonValue(columns = columns, flip = true)

        return binaryStringToInt(mostCommonString) * binaryStringToInt(leastCommonString)
    }

    private fun getCommonValue(columns: Array<StringBuilder?>, flip: Boolean): String {
        val mostCommon = ArrayList<Int>()
        columns.forEach { it ->
            val value = getMostCommonCharInString(it.toString())
            mostCommon.add(
                if (flip) {
                    flip(value)
                } else {
                    value
                }
            )
        }
        return mostCommon.joinToString("")
    }

    fun binaryStringToInt(binary: String): Int = Integer.parseInt(binary, 2)

    /**
     * Combines the output of oxygen rating and co2 rating, to find the life support rating
     * of the vessel
     */
    fun findLifeSupportRating(input: List<String>, column: Int = 0): Int {
        return findOxygenRating(input, column) * findCo2Rating(input, column)
    }

    fun findCo2Rating(input: List<String>, column: Int): Int {
        val leastCommon = flip(findMostCommonCharInColumn(input, column, '1'))
        val filtered = input.filter { it -> it[column] == leastCommon }
            .toList()
        return if (filtered.count() <= 1) {
            binaryStringToInt(filtered[0])
        } else {
            findCo2Rating(filtered, column + 1)
        }
    }

    fun findOxygenRating(input: List<String>, column: Int): Int {
        val mostCommon = findMostCommonCharInColumn(input, column)
        val filtered = input
            .filter { it -> it[column] == mostCommon }
            .toList()
        return if (filtered.count() <= 1) {
            binaryStringToInt(filtered[0])
        } else {
            findOxygenRating(filtered, column + 1)
        }
    }

    private fun findMostCommonCharInColumn(input: List<String>, i: Int, default: Char = '1'): Char {
        var cOnes = 0;
        var cZeros = 0;
        for (y in input.indices) {
            if (input[y][i] == ZERO) {
                cZeros++
            } else {
                cOnes++
            }
        }
        return if (cOnes > cZeros) {
            ONE
        } else if (cOnes < cZeros) {
            return ZERO
        } else {
            default
        }
    }

    private fun flip(input: Int): Int =
        if (input == 0)
            1
        else
            0

    private fun flip(input: Char): Char =
        if (input == ZERO)
            ONE
        else
            ZERO

    private fun getMostCommonCharInString(row: String): Int {
        val common: Map<Char, Int> = row.groupingBy { it }.eachCount()
        return if (common[ZERO]!! > common[ONE]!!) {
            0
        } else if (common[ZERO]!! < common[ONE]!!) {
            1
        } else {
            1
        }
    }

    companion object {
        const val ZERO = '0'
        const val ONE = '1'
    }
}

fun main() {
    val day3 = Day3()
    val inputPuzzle1 = readFileToStringList("day3/puzzle1.txt")
    val puzzle1Result = day3.calculatePowerConsumption(inputPuzzle1)
    println("Result day3, puzzle 1: $puzzle1Result")
    val puzzle2Result = day3.findLifeSupportRating(inputPuzzle1)
    println("Result day2, puzzle 2: $puzzle2Result")
}