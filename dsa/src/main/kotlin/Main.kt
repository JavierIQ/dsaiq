package org.example

import org.example.array.RunningSumOf1dArray
import org.example.array.maximumWealth
import org.example.binarySearch.binarySearch
import org.example.selectionSort.selectionSort

fun main() {

    // binarySearchTest()
    // selectionSortTest()
    // runningSumOf1dTest()
    richestCustomerWealthTest()
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

    println( "Running Sum of 1d Array ${RunningSumOf1dArray().runningSum(input1).contentToString()}")
    println( "Running Sum of 1d Array ${RunningSumOf1dArray().runningSum(input2).contentToString()}")
}

fun richestCustomerWealthTest(){
    val test1 = arrayOf(
        intArrayOf(1,2,3),
        intArrayOf(3,2,1)
    )
    val test2 = arrayOf(
        intArrayOf(1,5),
        intArrayOf(7,3),
        intArrayOf(3,5)
    )
    println("richestCustomerWealthTest ${maximumWealth(test1)}")
    println("richestCustomerWealthTest ${maximumWealth(test2)}")
}