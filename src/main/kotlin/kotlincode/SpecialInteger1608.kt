package kotlincode

class SpecialInteger1608 {
}

fun main() {
    var total = 0

    val a = listOf(0,0)
    for (x in 0..a.max()) {
        val counter = a.count { it >= x }
        if (x == counter) {
            total = x
        }
        println("x $x counter $counter")
    }



    println("Result is $total")

}