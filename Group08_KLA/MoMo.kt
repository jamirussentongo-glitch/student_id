fun main() {
    // Task 1 tests
    calculateMoMoFee(amount = 4500, balance = 6000)
    calculateMoMoFee(amount = 50000, balance = 50500)
    calculateMoMoFee(amount = 70000, balance = 80000)
}

// Handling Task 1
fun calculateMoMoFee(amount: Int, balance: Int) {
    val fee = when {
        amount in 0..5000 -> 500
        amount in 5001..60000 -> 1000
        else -> 2000
    }

    val total = amount + fee

    if (total <= balance) {
        println("Transaction Successful. Fee: $fee, Total Deducted: $total")
    } else {
        println("Insufficient Funds")
    }
}
