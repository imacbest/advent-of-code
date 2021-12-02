package nl.imacbest.day2

import nl.imacbest.day2.Direction.*
import nl.imacbest.utils.readFileToStringList
import java.lang.Integer.parseInt


class Day2 {

    fun calculateAim(input: List<String>): Int {
        val parsedInput = parseInput(input)
        var horizontalMovement = 0
        var depth = 0
        var aim = 0

        parsedInput.forEach() { it ->
            if (it.direction == FORWARD) {
                horizontalMovement += it.amount
                depth += (aim * it.amount)
            } else if (it.direction == UP) {
                aim -= it.amount
            } else if (it.direction == DOWN) {
                aim += it.amount
            }
        }

        return horizontalMovement * depth
    }

    fun calculateMovement(input: List<String>): Int {
        val parsedInput = parseInput(input)
        var horizontalMovement = 0
        var depth = 0

        parsedInput.forEach() { it ->
            when (it.direction) {
                FORWARD -> {
                    horizontalMovement += it.amount
                }
                UP -> {
                    depth -= it.amount
                }
                DOWN -> {
                    depth += it.amount
                }
            }
        }

        return horizontalMovement * depth
    }

    private fun parseInput(input: List<String>): List<Movement> =
        input.stream()
            .map { it.split(" ") }
            .map { it ->
                Movement(
                    valueOfString(
                        it[0]
                    ),
                    parseInt(it[1])
                )
            }
            .toList()

    private fun valueOfString(value: String): Direction =
        Direction.values()
            .first() { it.name.lowercase() == value.lowercase() }


}

data class Movement(val direction: Direction, val amount: Int)

enum class Direction {
    UP,
    DOWN,
    FORWARD
}


fun main() {
    val day2 = Day2()
    val inputPuzzle1 = readFileToStringList("day2/puzzle1.txt")
    val puzzle1Result = day2.calculateMovement(inputPuzzle1)
    println("Result day2, puzzle 1: $puzzle1Result")
    val puzzle2Result = day2.calculateAim(inputPuzzle1)
    println("Result day2, puzzle 2: $puzzle2Result")
}