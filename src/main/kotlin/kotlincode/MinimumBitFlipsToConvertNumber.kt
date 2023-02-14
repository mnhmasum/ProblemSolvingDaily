package kotlincode

class MinimumBitFlipsToConvertNumber {
}

fun main() {
    var start = 1
    val goal = 14
    var counter = 0
    var step = 0
    while (goal != start) {
        if (1 shl counter and start != 1 shl counter and goal) {
            val bitNeedTobeChanged = if (1 shl counter and start > 0) 1 else 0
            start = if (bitNeedTobeChanged == 0) {
                start or (1 shl counter) // make zero to one
            } else {
                (1 shl counter).inv() and start // make 1 to zero
            }
            step++
        }
        counter++
    }

    println("Total steps: $step")
}