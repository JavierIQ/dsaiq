package org.example.array

fun deletingFromEndArray() {
    val intArray = IntArray(10)
    var length = 0

    for (i in 0..6) {
        intArray[length] = i
        length++
    }

    length--

    for (i in 0..<length) {
        println("Index " + i + " contains " + intArray[i])
    }

    length--

    println("------")

    for (i in 0..<length) {
        println("Index " + i + " contains " + intArray[i])
    }

    length--

    println("------")

    for (i in 0..<length) {
        println("Index " + i + " contains " + intArray[i])
    }


    println(intArray.joinToString())
}

fun deletingFromStartArray () {
    val intArray = IntArray(10)
    var length = 0

    for (i in 0..8) {
        intArray[length] = i
        length++
    }

    for (i in 1..length){
        intArray[i-1] = intArray[i]
    }

    length--

    for (i in 0..<length) {
        println("Index " + i + " contains " + intArray[i])
    }

    println(intArray.joinToString())
}
