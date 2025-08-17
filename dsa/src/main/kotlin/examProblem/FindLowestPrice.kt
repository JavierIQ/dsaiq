package org.example.examProblem

data class Discount(val type: Int, val amount: Int)

fun applyDiscount(basePrice: Int, d: Discount): Int {
    val candidate = when (d.type) {
        0 -> d.amount                                 // type 0: price becomes amount
        1 -> (basePrice * (100 - d.amount)) / 100      // type 1: percent off, truncated
        2 -> basePrice - d.amount                      // type 2: fixed off
        else -> basePrice
    }
    return candidate.coerceAtLeast(0) // never below zero
}

fun findLowestPrice(
    products: List<List<String>>,
    discounts: List<List<String>>
): Int {
    val tagMap = discounts.associate { (tag, typeStr, amountStr) ->
        tag to Discount(typeStr.toInt(), amountStr.toInt())
    }

    var total = 0
    for (prod in products) {
        val base = prod[0].toInt()
        var best = base

        for (i in 1 until prod.size) {
            val tag = prod[i]
            if (tag.isEmpty() || tag == "EMPTY") continue
            val d = tagMap[tag] ?: continue
            val candidate = applyDiscount(base, d)
            if (candidate < best) best = candidate
        }
        total += best
    }
    return total
}
