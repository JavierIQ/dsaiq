package org.example.twoPointers

fun isPalindrome(word: String): String {
    var left = 0 // Pointer Starting Beginning
    var right: Int

    // Normalize the string: Remove spaces and convert to lowercase
    val normalizedWord = word.filter { it.isLetterOrDigit() }.lowercase()
    right = normalizedWord.lastIndex

    while (left < right) {
        // Compare chars at the left and right
        if (normalizedWord[left] != normalizedWord[right]) {
            return "Not a palindrome"
        }
        left++
        right--
    }
    return "Its palindrome"
}

// [1, 2, 4, 6, 8, 9, 14, 15]
// Target 13

fun hasPairWithSum(nums: IntArray, target: Int): Pair<Int, Int> {
    var left = 0
    var right = nums.lastIndex
    if (nums.size < 2) return Pair(0, 0)
    // If the array isn’t guaranteed to be sorted, you could sort it first:
    nums.sort()
    while (left < right) {
        val sum = nums[left] + nums[right]
        if (sum == target) {
            return Pair(nums[left], nums[right])
        } else if (sum < target) {
            left++ // Move the left pointer to increase the sum
        } else {
            right-- // Move the right pointer to decrease the sum
        }
    }
    return Pair(0, 0) // No pair found, return false
}