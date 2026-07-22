package org.example.recursion

fun checkList(list: List<Int>) {
    for (i in list.indices) {
        println("${list[i]}")
    }
}

fun recursion(number: Int) {
    if (number > 10) {
        return
    } else {
        println(number)
        recursion(number + 1)
        println("End of call where i = $number")
        return
    }
}

fun fibonacci(number: Int): Int {
    if(number <= 1 ){
        return number
    }
    val oneBack = fibonacci(number - 1)
    val twoBack = fibonacci(number - 2)
    return oneBack + twoBack
}
