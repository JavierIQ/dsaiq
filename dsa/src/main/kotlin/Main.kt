package org.example

import org.example.binarySearch.binarySearch

fun main() {

    binarySearchTest()
}

fun binarySearchTest() {
    val binarySearchList1 = listOf(1, 3, 5, 7, 9)
    println("Example: ")
    println("Binary Search Result : ${binarySearch(list = binarySearchList1, item = 3)}")
    println("Binary Search Result : ${binarySearch(list = binarySearchList1, item = -1)}")
}