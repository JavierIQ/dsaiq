package org.example.array

fun insertAtTheEnd() {
    // Declare an integer array of 6 elements
    val intArray = IntArray(6)

    for(i in intArray.indices) {
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
        if (array[i] == 0) {
            j--
            if (j < array.size) array[j] = 0
        }
        i--
        j--
    }
    println(array.joinToString())
}
