package kotlincode

class MaximumRepeatingString1668 {
}

fun main() {
    var sequence = "aaabaaaabaaabaaaabaaaabaaaabaaaaba"
    var word = "aaaba"
    var toBeConcatenated = word
    var counter = 0
    while (sequence.contains(word)) {
        counter++
        word += toBeConcatenated
        println(word)
    }

    println("Result: $counter")

}