package nl.imacbest.day5

import kotlin.math.sign

class Day5 {

    fun calculateIntersectingLinePoints(input: List<String>, onlyHorizontal: Boolean = true): Int {
        val ventMap = mutableMapOf<Point, Int>()
        parseLines(input)
            .flatMap { line -> createLines(line, onlyHorizontal) }
            .forEach { point ->
                ventMap.merge(point, 1) { a, b ->
                    a + b
                }
            }
        return ventMap.count { it.value > 1 };
    }

    private fun parseLines(input: List<String>): List<Line> =
        input.map { it ->
            val (startX, startY) = it.substringBefore(" -> ").split(',').map(String::toInt)
            val (endX, endY) = it.substringAfter(" -> ").split(',').map(String::toInt)
            Line(
                Point(startX, startY), Point(endX, endY)
            )
        }

    private fun createLines(line: Line, onlyHorizontal: Boolean = true): List<Point> {
        val pointList = mutableListOf<Point>()
        val delta = Point(
            x = line.p2.x - line.p1.x,
            y = line.p2.y - line.p1.y
        ).deltafy()
        if (onlyHorizontal && (delta.x != 0 && delta.y != 0)) {
            return listOf()
        }

        pointList.add(line.p1)
        var cur = line.p1

        while (cur != line.p2) {
            cur = Point(
                x = cur.x + delta.x,
                y = cur.y + delta.y
            )
            pointList.add(cur)
        }
        return pointList
    }

    private fun Point.deltafy(): Point = Point(x = this.x.sign, y = this.y.sign)
}

data class Line(val p1: Point, val p2: Point)

data class Point(val x: Int, val y: Int)