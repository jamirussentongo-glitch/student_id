fun main() {
    // Task 2 tests
    println("GPA: ${getGPA(82)}")
    println("GPA: ${getGPA(68)}")
    println("GPA: ${getGPA(40)}")
}

// Handling Task 2
fun getGPA(score: Int): Double {
    return when (score) {
        in 80..100 -> 5.0
        in 75..79 -> 4.5
        in 70..74 -> 4.0
        in 65..69 -> 3.5
        in 60..64 -> 3.0
        else -> 0.0
    }
}
