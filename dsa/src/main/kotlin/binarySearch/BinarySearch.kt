package org.example.binarySearch

fun binarySearch(list: List<Int>, item: Int): Int {
    // low and high keep track of which part of the list you will search in
    var low = 0
    var high = list.size - 1

    // While you haven't narrowed it down to one element...
    while (low <= high) {
        val mid = (low + high) / 2 // Check the middle element
        val guess = list[mid]
        if (guess == item) { // when you found the item
            return mid
        }
        if (guess > item) { // the guess was too high
            high = mid - 1
        } else { // the guess was too low
            low = mid + 1
        }
    }
    return -1 // the item doesn't exist
}