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

    for (i in strs[0].indices) {
        for (s in strs) {
            if (i == s.length || s[i] != strs[0][i]) {
                return longestPrefix
            }
        }
        longestPrefix += strs[0][i]
    }

    return longestPrefix
}

/*
Remove Duplicates from Sorted Array

Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such
that each unique element appears only once. The relative order of the elements should be kept the same.

Consider the number of unique elements in nums to be k.
After removing duplicates, return the number of unique elements k.
The first k elements of nums should contain the unique numbers in sorted order.
The remaining elements beyond index k - 1 can be ignored.

Custom Judge:
The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}

If all assertions pass, then your solution will be accepted.

Example 1:
Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

Example 2:
Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
 */

fun removeDuplicates(nums: IntArray): Int {
    var index = 1
    for (i in 1..< nums.size) {
        if (nums[i] != nums[i - 1]) {
            nums[index++] = nums[i]
        }
    }
    return index
}