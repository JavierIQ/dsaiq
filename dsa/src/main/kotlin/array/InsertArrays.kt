package org.example.array

fun insertAtTheEnd() {
    // Declare an integer array of 6 elements
    val intArray = IntArray(6)

    // Add 3 elements to the Array
    for ((length, i) in (0..2).withIndex()) {
        intArray[length] = i
    }

    intArray[intArray.lastIndex] = 10

    println(intArray.joinToString())
}

fun insertAtTheStart() {
    val intArray = IntArray(6)
    for (i in 3 downTo 0) {
        intArray[i + 1] = intArray[i]
    }
    intArray[0] = 20
    println(intArray.joinToString())
}

fun insertAtAnyIndex() {
    val intArray = IntArray(6)

    // Say we want to insert the element at index 2.
    // First, we will have to create space for the new element.
    for (i in 4 downTo 2) {

        // Shift each element one position to the right.
        intArray[i + 1] = intArray[i]
    }

    intArray[2] = 30
    println(intArray.joinToString())
}

fun duplicateZeros(array: IntArray) {
    // Length is 8
    val countZeros = array.count { it == 0 }

    // Original array pointer
    var i = array.size - 1
    // "Extended" array pointer
    var j = array.size + countZeros - 1

    while (i >= 0) {
        if (j < array.size) array[j] = array[i]
        if (array[i] == 0){
            j--
            if (j < array.size) array[j] = 0
        }
        i--
        j--
    }
    println(array.joinToString())
}

