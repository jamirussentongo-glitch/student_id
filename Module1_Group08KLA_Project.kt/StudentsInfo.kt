fun main() {
    // Task 3 tests
    printStudentDetails("Martin Sendi", "24/2/306/D/127")
    printStudentDetails(null, "24/2/306/D/127")
}

// Handling Task 3
fun printStudentDetails(name: String?, studentNumber: String?) {
    if (name != null && studentNumber != null) {
        println("Welcome $name! Your student number is $studentNumber.")
    } else {
        println("Error: Incomplete record")
    }
}
