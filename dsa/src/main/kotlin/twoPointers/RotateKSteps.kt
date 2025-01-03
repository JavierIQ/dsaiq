package org.example.twoPointers

fun rotateArray(list: IntArray, steps: Int): IntArray {
    val n = list.size
    val k = steps % n // Normalize steps to avoid unnecessary rotations

    // Helper function to reverse a part of the array
    fun reverse(start: Int, end: Int) {
        var left = start
        var right = end
        while (left < right) {
            val temp = list[left]
            list[left] = list[right]
            list[right] = temp
            left++
            right--
        }
    }
    // Step 1: Reverse the entire array
    reverse(0, n - 1)
    // Step 2: Reverse the first k elements
    reverse(0, k - 1)
    // Step 3: Reverse the rest
    reverse(k, n - 1)

    return list
}
