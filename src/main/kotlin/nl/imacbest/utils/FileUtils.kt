package nl.imacbest.utils

import java.io.File
import java.lang.Integer.parseInt
import java.util.*

const val FILE_PREFIX = "src/main/resources/"

fun readFileToIntList(filename: String): List<Int> {
    val resultList = mutableListOf<Int>()
    File("$FILE_PREFIX/$filename").forEachLine { resultList.add(parseInt(it)) }
    return Collections.unmodifiableList(resultList)
}