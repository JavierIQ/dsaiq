package org.example.array

fun myDvdShelf() {
    val squareNumber = Array(10){ i ->
        (i + 1) * (i + 1)
    }
}

fun saveDVDList() {
    val dvdCollection = arrayOfNulls<DVD>(15) // Creates an array of size 15 with null values
    val avengersDVD = DVD(name = "The Avengers", releaseYear = 2012, director = "Joss Whedon")
    val incrediblesDVD = DVD(name = "The Incredibles", releaseYear = 2004, director = "Brad Bird")
    val findingDoryDVD = DVD(name = "Finding Dory", releaseYear = 2016, director = "Andrew Stanton")
    val lionKingDVD = DVD(name = "The Lion King" , releaseYear = 2019, director = "Jon Favreau")

    dvdCollection[3] = incrediblesDVD
    dvdCollection[7] = avengersDVD
    dvdCollection[9] = findingDoryDVD
    dvdCollection[2] = lionKingDVD

    println(dvdCollection[3].toString())
}

data class DVD(
    var name: String,
    var releaseYear: Int,
    var director: String
) {
    fun DVD.getInfo() {
        println("$name directed by $director,release in $releaseYear")
    }
}

/*
Given a binary array nums, return the maximum number of consecutive 1's in the array.
Example 1:
Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.

Example 2:
Input: nums = [1,0,1,1,0,1]
Output: 2
 */

fun maxConsecutiveOnes(nums: Array<Int>): Int {
    var currentCount = 0
    var maxCount = 0
    for (i in nums) {
        if (i == 1) {
            currentCount += 1
            maxCount = maxOf(maxCount, currentCount) // Always update maxCount here
        } else {
            currentCount = 0
        }
    }
    return maxCount
}
