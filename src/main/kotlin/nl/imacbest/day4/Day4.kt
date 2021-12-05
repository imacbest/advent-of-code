package nl.imacbest.day4

import nl.imacbest.utils.readFileToStringList
import nl.imacbest.utils.removeNulls
import org.apache.commons.lang3.StringUtils.isEmpty
import org.apache.commons.lang3.StringUtils.isNotEmpty
import java.lang.Integer.parseInt
import java.util.*

class Day4 {
    fun findLastWiningBoardScore(inputLocation: String): Int {
        return playBingo(inputLocation)
            .filter { it -> it.score != 0 }
            .sortedByDescending { it -> it.winningNumber }[0]
            .score
    }

    fun findWinningBingoScore(inputLocation: String): Int {
        return playBingo(inputLocation)
            .sortedBy { it -> it.winningNumber }[0]
            .score
    }

    private fun playBingo(inputLocation: String): List<BingoBoard> {
        var bingo = parseInputFile(inputLocation)
        var currentNumber: Int = 0
        val winners = mutableListOf<BingoBoard>()
        for (i in bingo.numbers.indices) {
            currentNumber = bingo.numbers[i]
            val selectedNumbers = bingo.numbers.slice(0..i)
            val winner = bingo.boards.filter { it -> isWinner(it, selectedNumbers) }.toList()
            if (winner.isNotEmpty()) {
                winner.forEach { it ->
                    winners.add(
                        it.copy(
                            winningNumber = winners.size + 1,
                            score = calculateWinningScore(it, selectedNumbers, currentNumber)
                        )
                    )
                    bingo = bingo.copy(boards = bingo.boards.filter { board -> board != it })
                }
            }
        }
        return winners
    }

    private fun calculateWinningScore(
        winner: BingoBoard,
        selectedNumbers: List<Int>,
        currentNumber: Int,
    ) = winner.values
        .flatMap { it.asIterable() }
        .filter { it -> !selectedNumbers.contains(it) }
        .sum() * currentNumber

    private fun isWinner(board: BingoBoard, numbers: List<Int>): Boolean {
        if (numbers.size < board.values.size) {
            return false
        }
        return isHorizontalWinner(board.values, numbers) || isVerticalWinner(board.values, numbers)
    }

    private fun isVerticalWinner(values: Array<IntArray>, numbers: List<Int>): Boolean {
        for (i in values.indices) {
            var verticalFound = true
            for (y in values[i].indices) {
                if (!numbers.contains(values[y][i])) {
                    verticalFound = false
                }
            }
            if (verticalFound) {
                return true
            }
        }
        return false
    }

    private fun isHorizontalWinner(values: Array<IntArray>, numbers: List<Int>): Boolean {
        for (i in values.indices) {
            if (numbers.containsAll(values[i].toList())) {
                return true
            }
        }
        return false
    }

    private fun parseInputFile(inputLocation: String): Bingo {
        val lines: List<String> = readFileToStringList(inputLocation)
        val numbers: List<Int> = parseNumbersLine(lines[0])
        var i = 2
        val boards = mutableListOf<BingoBoard>()
        while (i < lines.size) {
            var boardArray: Array<IntArray?> = emptyArray()
            while (i < lines.size && !isEmpty(lines[i])) {
                val currentLine = lines[i]
                boardArray = boardArray.copyOf(boardArray.size + 1)
                boardArray[boardArray.size - 1] = currentLine.split(" ")
                    .filter { it -> isNotEmpty(it) }
                    .map(::parseInt)
                    .toIntArray()
                i++
            }
            boards.add(BingoBoard(0, 0, boardArray.removeNulls()))
            i++
        }

        return Bingo(numbers = numbers, boards = Collections.unmodifiableList(boards))
    }

    private fun parseNumbersLine(line: String): List<Int> =
        line.split(',')
            .map(::parseInt)
            .toList()


}


data class Bingo(
    val numbers: List<Int>,
    val boards: List<BingoBoard>
)

data class BingoBoard(
    var winningNumber: Int,
    var score: Int,
    val values: Array<IntArray>
)