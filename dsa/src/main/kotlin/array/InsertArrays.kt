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