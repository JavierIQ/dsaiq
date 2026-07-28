package org.example.array

// Build the prefix Sum
private fun buildPrefixSum(nums: IntArray): IntArray {
    // +1 to cover start == 0
    val prefix = IntArray(nums.size + 1)

    // With this its not necessary start from 1
    for (i in nums.indices) {
        prefix[i + 1] = prefix[i] + nums[i]
    }

    return prefix
}

/*
Example 1: Given an integer array nums, an array queries where queries[i] = [x, y] and an integer limit,
return a boolean array that represents the answer to each query. A query is true if the sum of
the subarray from x to y is less than limit, or false otherwise.

For example, given nums = [1, 6, 3, 2, 7, 2], queries = [[0, 3], [2, 5], [2, 4]], and limit = 13,
the answer is [true, false, true].
For each query, the subarray sums are [12, 14, 12].
 */

fun answerQueries(nums: IntArray, queries: Array<IntArray>, limit: Int): BooleanArray {
    val prefix = buildPrefixSum(nums = nums)
    val answer = BooleanArray(queries.size)
    for (i in queries.indices) {
        val (start,end) = Pair(first = queries[i][0],second = queries[i][1])
        val rangeSum = prefix[end + 1] - prefix[start]
        answer[i] = rangeSum < limit
    }

    return answer
}
