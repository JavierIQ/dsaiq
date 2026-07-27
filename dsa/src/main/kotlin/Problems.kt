package org.example

import kotlin.math.max

/*
Maximum Product of Three Numbers

Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

Example 1:

Input: nums = [1,2,3]
Output: 6
Example 2:

Input: nums = [1,2,3,4]
Output: 24
Example 3:

Input: nums = [-1,-2,-3]
Output: -6
 */

fun maximumProduct(nums: IntArray): Int {
    if (nums.size < 3) {
        return 0
    }
    nums.sort()
    val lastIndex = nums.lastIndex

    val threeLargestNumbers =
        nums[lastIndex] * nums[lastIndex - 1] * nums[lastIndex - 2]
    val threeSmallestNegative =
        nums[0] * nums[1] * nums[lastIndex]

    return max(threeSmallestNegative, threeLargestNumbers)
}

/*
Maximum Product of Two Elements in an Array
Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).

Example 1:

Input: nums = [3,4,5,2]
Output: 12
Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12.
Example 2:

Input: nums = [1,5,4,5]
Output: 16
Explanation: Choosing the indices i=1 and j=3 (indexed from 0), you will get the maximum value of (5-1)*(5-1) = 16.
Example 3:

Input: nums = [3,7]
Output: 12
 */
fun maxProduct(nums: IntArray): Int {
    var largest = 0
    var secondLargest = 0

    for (number in nums) {
        if (number > largest) {
            secondLargest = largest
            largest = number
        } else if (number > secondLargest) {
            secondLargest = number
        }
    }

    return (largest - 1) * (secondLargest - 1)
}

/*
 Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */

fun longestCommonPrefix(strs: Array<String>): String {
    var longestPrefix = ""

    for (i in strs[0].indices){
        for (s in strs) {
            if (i == s.length || s[i] != strs[0][i]) {
                return longestPrefix
            }
        }
        longestPrefix += strs[0][i]
    }

    return longestPrefix
}