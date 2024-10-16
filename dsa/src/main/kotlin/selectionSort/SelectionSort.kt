package org.example.selectionSort

fun selectionSort(array: MutableList<Int>): MutableList<Int> {
    val newArray = mutableListOf<Int>()
    for (i in array.indices) {
        val smallest = findSmallest(array)
        newArray.add(array.removeAt(smallest))
    }
    return newArray
}

fun findSmallest(array: MutableList<Int>): Int {
    var smallest = array[0]
    var smallestIndex = 0
    for (i in array.indices) {
        if (array[i] < smallest) {
            smallest = array[i]
            smallestIndex = i
        }
    }
    return smallestIndex
}