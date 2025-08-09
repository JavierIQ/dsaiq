package org.example.array

fun insertAtTheEnd() {
    // Declare an integer array of 6 elements
    val intArray = IntArray(6)

    for (i in intArray.indices) {
        print(intArray[i])
    }
    println()
    intArray.forEach { i ->
        print(i)
    }
    println()
    for ((i, value) in intArray.withIndex()) {
        println("Index $i has value $value")
    }
    println()
    for ((i, value) in (0..2).withIndex()) {
        intArray[value] = i
    }

    println()
    println(intArray.joinToString())
}

fun insertAtTheStart() {
    val intArray = IntArray(6)
    var length = 0
    // Inserting 1, 2 to the list
    for ((i, value) in (0..2).withIndex()) {
        intArray[value] = i
        length++
    }
    // 0, 1, 2, 0, 0, 0
    // Inserting 10 on the last index (length)
    intArray[length] = 10
    // 0, 1, 2, 10, 0, 0
    println(intArray.joinToString())
    // First, we will have to create space for a new element.
    // We do that by shifting each element one index to the right.
    // This will firstly move the element at index 3, then 2, then 1, then finally 0.
    // We need to go backwards to avoid overwriting any elements.
    for (i in length downTo 0) {
        intArray[i + 1] = intArray[i]
    }
    intArray[0] = 20
    println(intArray.joinToString())
}

fun insertAtAnyIndex() {
    val intArray = IntArray(6)
    var length = 0
    for ((i, value) in (0..2).withIndex()) {
        intArray[value] = i
        length++
    }
    intArray[length] = 10
    for (i in length downTo 0) {
        intArray[i + 1] = intArray[i]
    }
    intArray[0] = 20
    println(intArray.joinToString())
    // 20, 0, 1, 2, 10, 0
//   Say we want to insert the element at index 2.
//   First, we will have to create space for the new element.
    for (i in 4 downTo 2) {
        intArray[i + 1] = intArray[i]
    }
    intArray[2] = 30
    println(intArray.joinToString())
}

fun insertTwentyFiveQuestion(
    arr: IntArray,
    index: Int,
    newValue: Int
) {
    if (index > arr.lastIndex) return

    for (i in 4 downTo index) {
        arr[i + 1] = arr[i]
    }

    arr[index] = newValue
    println(arr.joinToString())
}

fun duplicateZeros(array: IntArray) {
    var last = array.lastIndex
    var possibleDups = 0

    var left = 0
    while (left <= last - possibleDups) {
        if (array[left] == 0) {
            if (left == last - possibleDups) {
                array[last] = 0
                last -= 1
                break
            }
            possibleDups++
        }
        left++
    }

    val finalIndex = last - possibleDups

    for (j in finalIndex downTo 0) {
        if (array[j] == 0) {
            array[j + possibleDups] = 0
            array[j + possibleDups - 1] = 0
            possibleDups --
        } else {
            array[j + possibleDups] = array[j]
        }
    }
}

// nums1 = [1,2,3,0,0,0], m=3
// nums2 = [2,5,6], n=3

fun mergeSortedArray(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    // Three pointers
    var p1 = m - 1 // last valid element nums1 = 2
    var p2 = n - 1 // last element in nums2 = 2
    var p = m + n - 1 // last index of the final merged array = 5

    while (p1 >= 0 && p2 >= 0){
        if (nums2[p2] > nums1[p1]) {
            nums1[p] = nums2[p2]
            p2--
            p--
        } else {
            nums1[p] = nums1[p1]
            p1--
            p--
        }
    }
    while (p2 >= 0) {
        nums1[p] = nums2[p2]
        p2--
        p--
    }

    println(nums1.joinToString())
}
