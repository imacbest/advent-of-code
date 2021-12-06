package nl.imacbest.day5

import java.lang.Integer.parseInt

class Day5 {

    fun calculateIntersectingLinePoints(input: List<String>, onlyHorizontal: Boolean = true): Int {
        val lines = parseLines(input)
        val gridMaxX = findMaxX(lines) + 1
        val gridMaxY = findMaxY(lines) + 1
        val grid = Array<IntArray>(gridMaxX) { IntArray(gridMaxY) }
        fillGridWithLines(grid, lines, onlyHorizontal)
        return countIntersections(grid)
    }

    private fun fillGridWithLines(grid: Array<IntArray>, lines: List<Line>, onlyHorizontal: Boolean = true) {
        lines
            .filter { it ->
                if (onlyHorizontal) {
                    it.x1 == it.x2 || it.y1 == it.y2
                } else {
                    true
                }
            }
            .forEach { line ->
                var xLow = line.getXStart() - 1
                val xHigh = line.getXEnd()
                var yLow = line.getYStart() - 1
                val yHigh = line.getYEnd()
                while (xLow < xHigh || yLow < yHigh) {
                    if (xLow < xHigh) {
                        xLow++
                    }
                    if (yLow < yHigh) {
                        yLow++
                    }
                    grid[xLow][yLow]++
                }

            }
    }

    private fun countIntersections(grid: Array<IntArray>): Int {
        var counter = 0;
        for (x in grid.indices) {
            for (y in grid.indices) {
                if (grid[x][y] >= 2) {
                    counter++
                }
            }
        }
        return counter
    }

    private fun findMaxX(lines: List<Line>) = lines.maxOf {
        if (it.x1 > it.x2) {
            it.x1
        } else {
            it.x2
        }
    }

    private fun findMaxY(lines: List<Line>) = lines.maxOf {
        if (it.y1 > it.y2) {
            it.y1
        } else {
            it.y2
        }
    }

    private fun parseLines(input: List<String>): List<Line> =
        input.map { it ->
            val spliter = it.split("->")
            val startCords = spliter[0].split(",")
                .map { cords ->
                    parseInt(cords.trim())
                }
            val endCords = spliter[1].split(",")
                .map { cords ->
                    parseInt(cords.trim())
                }
            Line(
                x1 = startCords[0],
                y1 = startCords[1],
                x2 = endCords[0],
                y2 = endCords[1]
            )
        }
}

data class Line(
    val x1: Int,
    val y1: Int,
    val x2: Int,
    val y2: Int
) {
    fun getXStart(): Int = getHighest(x1, x2)

    fun getXEnd(): Int = getLowest(x1, x2)

    fun getYStart(): Int = getHighest(y1, y2)

    fun getYEnd(): Int = getLowest(y1, y2)

    private fun getHighest(a: Int, b: Int) =
        if (a >= b) {
            b
        } else {
            a
        }

    private fun getLowest(a: Int, b: Int) =
        if (a >= b) {
            a
        } else {
            b
        }
}