package org.example.array

import kotlin.math.abs
import kotlin.math.log10

fun myDvdShelf() {
    val squareNumber = Array(10) { i ->
        (i + 1) * (i + 1)
    }
}

fun saveDVDList() {
    val dvdCollection = arrayOfNulls<DVD>(15) // Creates an array of size 15 with null values
    val avengersDVD = DVD(name = "The Avengers", releaseYear = 2012, director = "Joss Whedon")
    val incrediblesDVD = DVD(name = "The Incredibles", releaseYear = 2004, director = "Brad Bird")
    val findingDoryDVD = DVD(name = "Finding Dory", releaseYear = 2016, director = "Andrew Stanton")
    val lionKingDVD = DVD(name = "The Lion King", releaseYear = 2019, director = "Jon Favreau")

    dvdCollection[3] = incrediblesDVD
    dvdCollection[7] = avengersDVD
    dvdCollection[9] = findingDoryDVD
    dvdCollection[2] = lionKingDVD

    println(dvdCollection[3].toString())
}

data class DVD(
    var name: String,
    var releaseYear: Int,
    var director: String
) {
    fun DVD.getInfo() {
        println("$name directed by $director,release in $releaseYear")
    }
}

/*
Given a binary array nums, return the maximum number of consecutive 1's in the array.
Example 1:
Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.

Example 2:
Input: nums = [1,0,1,1,0,1]
Output: 2
 */

fun maxConsecutiveOnes(nums: Array<Int>): Int {
    var currentCount = 0
    var maxCount = 0
    for (i in nums) {
        if (i == 1) {
            currentCount += 1
            maxCount = maxOf(maxCount, currentCount) // Always update maxCount here
        } else {
            currentCount = 0
        }
    }
    return maxCount
}

/*
Given an array nums of integers, return how many of them contain an even number of digits.
Example 1:

Input: nums = [12,345,2,6,7896]
Output: 2
Explanation:
12 contains 2 digits (even number of digits).
345 contains 3 digits (odd number of digits).
2 contains 1 digit (odd number of digits).
6 contains 1 digit (odd number of digits).
7896 contains 4 digits (even number of digits).
Therefore only 12 and 7896 contain an even number of digits.
Example 2:

Input: nums = [555,901,482,1771]
Output: 1
Explanation:
Only 1771 contains an even number of digits.
 */

fun findNumbers(nums: Array<Int>): Int {
    var counterEven = 0
    for (i in nums) {
        val numberOfDigits = divideNumber(i)
        if (numberOfDigits % 2 == 0) {
            counterEven += 1
        }
    }
    return counterEven
}

fun divideNumber(num: Int): Int {
    return when (num) {
        0 -> 1
        else -> log10(abs(num).toDouble()).toInt() + 1
    }
}

/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 */

fun sortedSquares(nums: Array<Int>): IntArray {
    var squareList = arrayOf<Int>(nums.size)
    for((index, i) in nums.withIndex()) {
        squareList[index] = i*i
    }
    return squareList.toIntArray()
}