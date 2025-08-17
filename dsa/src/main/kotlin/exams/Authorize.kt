package org.example.exams

import java.time.LocalDateTime

fun main() {
    println(authorize(transactionBurgerKing, accountTest))
}

val transactionBurgerKing: Transaction =
    Transaction(
        amount = 5,
        merchant = "Burger King",
        time = LocalDateTime.now()
    )

val accountTest: Account =
    Account(
        active = true,
        availableLimit = 100,
        history = emptyList<Transaction>()
    )

data class Transaction(
    val amount: Int,
    val merchant: String,
    val time: LocalDateTime?
)

data class Account(
    val active: Boolean,
    val availableLimit: Int,
    val history: List<Transaction>
)

data class AuthorizationResponse(
    val account: Account,
    val violationList: List<String>
)

fun authorize(transaction: Transaction, account: Account): AuthorizationResponse {
    requireNotNull(transaction.time) { "Transaction time must not be null" }

    val violations = mutableListOf<String>()

    // 1) account-not-active
    if (!account.active) {
        violations += "account-not-active"
    }

    // 2) first-transaction-above-threshold (strictly greater than 90% of limit)
    if (account.history.isEmpty()) {
        // avoid rounding issues by cross-multiplying
        val aboveThreshold = transaction.amount * 100 > account.availableLimit * 90
        if (aboveThreshold) violations += "first-transaction-above-threshold"
    }

    // 3) insufficient-limit
    if (transaction.amount > account.availableLimit) {
        violations += "insufficient-limit"
    }

    // Window: last 2 minutes, inclusive
    val tNow = transaction.time
    val windowStart = tNow!!.minusMinutes(2)

    val recent = account.history.filter { h ->
        val ht = h.time
        ht != null && !ht.isBefore(windowStart) && !ht.isAfter(tNow)
    }

    // 4) high-frequency-small-interval
    // Interpretation: No more than 3 transactions (any merchant) within a 2-minute window.
    // If authorizing this would make it 4+, flag it.
    if (recent.size >= 3) {
        violations += "high-frequency-small-interval"
    }

    // 5) doubled-transaction: no more than 1 similar (same amount & merchant) within 2 minutes
    val similarInWindow = recent.count { it.amount == transaction.amount && it.merchant == transaction.merchant }
    if (similarInWindow >= 1) {
        violations += "doubled-transaction"
    }

    // If any violations, return unchanged account
    if (violations.isNotEmpty()) {
        return AuthorizationResponse(account = account, violationList = violations)
    }

    // All good: apply the transaction
    val updated = account.copy(
        availableLimit = account.availableLimit - transaction.amount,
        history = account.history + transaction
    )
    return AuthorizationResponse(account = updated, violationList = emptyList())
}


// Violation Rules:
//1. No transaction should be accepted for an inactive account: account-not-active
//2. The value of the first transaction should not exceed 90% of the limit: first-transaction-above-threshold
//3. The value of the transaction should not exceed the available limit: insufficient-limit
//4. There should not be more than 3 transactions from any merchant within a 2-minute interval: high-frequency-small-interval // special
//There should not be more than 1 similar transaction (same amount and merchant) within a 2-minute interval: doubled-transaction

//If all rules are met, the value of the authorized transaction should be subtracted from the
//account balance, and the account's transaction history should be updated.

// Use Cases:
// Pass
//transaction = {
//    amount: 10,
//    merchant: "Burger King",
//    time: Date.now()
//}
//account = {
//    active: true,
//    availableLimit: 100,
//    history: []
//}

//result = authorize(transaction, account)

// Output
//result.account == {
//    active: true,
//    availableLimit: 90,
//    history: [{
//        amount: 10,
//        merchant: "Burger King",
//        time: 1629298219336
//    }]
//}
//result.violations == []

//transaction = {
//    amount: 100,
//    merchant: "Paris 6",
//    time: Date.now()
//}
//account = {
//    active: false,
//    availableLimit: 100,
//    history: []
//}
//result = authorize(transaction, account)
//
//result.account == {
//    active: false,
//    availableLimit: 100,
//    history: []
//}
//result.violations == ["account-not-active", "first-transaction-above-threshold"]