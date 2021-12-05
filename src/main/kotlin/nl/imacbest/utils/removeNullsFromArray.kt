package nl.imacbest.utils

inline fun <reified T> Array<T?>.removeNulls(): Array<T> =
    this.toList()
        .filterNotNull()
        .toTypedArray()
