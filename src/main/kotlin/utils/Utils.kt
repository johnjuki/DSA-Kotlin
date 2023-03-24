package utils

infix fun String.example(function: () -> Unit) {
    println("---Example of $this---")
    function()
    println()
}

infix fun String.challenge(function: () -> Unit) {
    println("---Challenge of $this---")
    function()
    println()
}
