package org.example

import org.example.array.*
import org.example.binarySearch.binarySearch
import org.example.selectionSort.selectionSort
import org.example.twoPointers.hasPairWithSum
import org.example.twoPointers.isPalindrome
import org.example.twoPointers.rotateArray

fun main() {
    // binarySearchTest()
    // selectionSortTest()
    // runningSumOf1dTest()
    // richestCustomerWealthTest()
    // isPalindromeTest()
    // hasPairWithSumTest()
    // rotateArrayKStepsTest()
    // maxConsecutiveOnesTest()
    // findNumbersTest()
    // sortedSquaresTest()
    // Arrays
    // insertAtTheEnd()
    // insertAtTheStart()
    // insertAtAnyIndex()
//    insertTwentyFiveQuestion(
//        arr = intArrayOf(1, 2, 3, 77, 4, 5), index = 3, newValue = 77
//    )
    duplicateZeros()
    //duplicateZerosTest()
}

fun binarySearchTest() {
    val binarySearchList1 = listOf(1, 3, 5, 7, 9)
    println("Example Binary Search: ")
    println("Binary Search Result : ${binarySearch(list = binarySearchList1, item = 3)}")
    println("Binary Search Result : ${binarySearch(list = binarySearchList1, item = -1)}")
}

fun selectionSortTest() {
    val listForSelectionSort = mutableListOf(5, 3, 6, 2, 10)
    val sortedList = selectionSort(listForSelectionSort)
    println("Example Selection Sort: ")
    for (i in sortedList.indices) {
        print(sortedList[i])
    }
}

fun runningSumOf1dTest() {
    val input1 = intArrayOf(1, 2, 3, 4) // Output 1, 3, 6, 10
    val input2 = intArrayOf(1, 1, 1, 1, 1) // Output 1,2,3,4,5

    println("Running Sum of 1d Array ${RunningSumOf1dArray().runningSum(input1).contentToString()}")
    println("Running Sum of 1d Array ${RunningSumOf1dArray().runningSum(input2).contentToString()}")
}

fun richestCustomerWealthTest() {
    val test1 = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(3, 2, 1)
    )
    val test2 = arrayOf(
        intArrayOf(1, 5),
        intArrayOf(7, 3),
        intArrayOf(3, 5)
    )
    println("richestCustomerWealthTest ${maximumWealth(test1)}")
    println("richestCustomerWealthTest ${maximumWealth(test2)}")
}

fun isPalindromeTest() {
    val test1 = "abcdcba"
    val test2 = "Ana lava lana"
    val test3 = "racecar"
    val test4 = "Javier"

    println(isPalindrome(test1))
    println(isPalindrome(test2))
    println(isPalindrome(test3))
    println(isPalindrome(test4))
}

fun hasPairWithSumTest() {
    val listTest = intArrayOf(1, 2, 4, 6, 8, 9, 14, 15)
    val target = 13

    println(hasPairWithSum(listTest, target).toString()) // Output: true (4 + 9 = 13)
}

fun rotateArrayKStepsTest() {
    val listTest = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    val steptest = 4
    println("Rotate list ${listTest.contentToString()} $steptest steps")
    println(rotateArray(listTest, steptest).contentToString())
}

fun maxConsecutiveOnesTest() {
    val test1 = arrayOf(1, 1, 0, 1, 1, 1) // 3
    val test2 = arrayOf(1, 0, 1, 1, 0, 1) // 2
    println(maxConsecutiveOnes(test1))
    println(maxConsecutiveOnes(test2))
}

fun findNumbersTest() {
    val test1 = arrayOf(12, 345, 2, 6, 7896)
    val test2 = arrayOf(555, 901, 482, 1771)
    println(findNumbers(test1))
    println(findNumbers(test2))
}

fun sortedSquaresTest() {
    val test1 = arrayOf(-4, -1, 0, 3, 10)
    val test2 = arrayOf(-7, -3, 2, 3, 11)
    println(sortedSquares(test1).joinToString())
    println(sortedSquares(test2).joinToString())
}

fun duplicateZerosTest() {
    val testArray1 = intArrayOf(1, 0, 2, 3, 0, 4, 5, 0)
    duplicateZeros()
}
