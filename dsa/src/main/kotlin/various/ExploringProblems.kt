package org.example.various

fun fizzBuzz(n: Int): List<String> {
    val result = mutableListOf<String>()
    for (i in 1..n) {
        if (i % 3 == 0 && i % 5 == 0) {
            result.add("FizzBuzz")
            continue
        } else if (i % 3 == 0) {
            result.add("Fizz")
            continue
        } else if (i % 5 == 0) {
            result.add("Buzz")
            continue
        } else {
            result.add(i.toString())
            continue
        }
    }
    return result
}

fun numberOfSteps(num: Int): Int {
    // my variables
    var stepsCounter = 0
    var result = num

    while (result > 0) {
        if ( result % 2 == 0) {
            result /= 2
        } else {
            result -= 1
        }
        stepsCounter += 1
    }

    return stepsCounter
}
