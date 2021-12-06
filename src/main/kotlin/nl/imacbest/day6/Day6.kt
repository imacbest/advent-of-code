package nl.imacbest.day6

import java.lang.Integer.parseInt

class Day6 {

    private var fishCounter = LongArray(9)

    fun calculateFish(input: List<String>, rounds: Int): Long {
        input[0].split(",")
            .map { it -> parseInt(it.trim()) }
            .forEach { it -> fishCounter[it]++ }
        println("Inital state: ${fishCounter.joinToString(", ")}")
        for (i in 0 until rounds) {
            val newFishCounter = LongArray(9)
            val zeroValue = fishCounter[0]
            for (x in 0..7) {
                newFishCounter[x] = fishCounter[x + 1]
            }
            newFishCounter[8] = zeroValue
            newFishCounter[6] += zeroValue
            fishCounter = newFishCounter
        }
        println("Final state ${fishCounter.joinToString(", ")}")
        return fishCounter.sum()
    }
}