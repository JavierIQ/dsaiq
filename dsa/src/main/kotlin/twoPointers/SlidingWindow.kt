package org.example.twoPointers

import kotlin.math.max

// Find the longest subarray with a sum less than or equal to k (constraint metric = sum)
// nums = [1, 1, 1, 3] and k = 3
fun findK(numsList: IntArray, k: Int): Int {
    var left = 0
    var answer = 0
    var current = 0
    for (i in numsList.indices) {
        current += numsList[i]
        while (current > k) {
            current -= numsList[left]
            left++
        }
        answer = max(answer, i - left + 1)
    }
    return answer
}

// word = "1101100111" answer = 5
fun findLongestOne(word: String): Int {
    var left = 0
    var answer = 0
    var zeroCount = 0
    for (right in word.indices) {
        if (word[right] == '0'){
            zeroCount++
        }
        while (zeroCount > 1) {
            if (word[left] == '0') {
                zeroCount--
            }
            left++
        }
        answer = max(answer, right - left + 1)
    }
    return answer
}

//nums = [10, 5, 2, 6], k = 100, the answer is 8
fun findSubArraysLessK(numsList: IntArray, k: Int): Int {
    if (k <= 0) {
        return 0
    }

    var left = 0
    var currentProduct = 1
    var answerNumberArrays = 0

    for (right in numsList.indices) {
        currentProduct *= numsList[right]
        while (currentProduct >= k){
            currentProduct /= numsList[left]
            left++
        }
        answerNumberArrays += right - left + 1
    }
    return answerNumberArrays
}

fun findFixingWindow(numsList: IntArray, k: Int): Int {
    var curr = 0
    for (i in 0..<k) {
        curr += numsList[i]
    }

    var ans = curr
    for (i in k..<numsList.lastIndex) {
        curr += numsList[i] - numsList[i - k]
        ans = max(ans, curr)
    }

    return ans
}