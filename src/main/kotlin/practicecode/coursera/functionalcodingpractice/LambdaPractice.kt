package practicecode.coursera.functionalcodingpractice

import java.util.Map

class LambdaPractice {

}

fun main() {
    val sum = { x: Int, y: Int -> x + y }
    val sum2: (Int, Int) -> Int = { a, b -> a + b }
    fun lambda(x: (Int, Int) -> Int): Int = x(1, 8)
    println(lambda { x: Int, y: Int -> x + y })

    val isEvent = { x: Int -> x % 2 == 0 }
    val list = listOf(1, 2, 3, 4, 5, 6)
    val result = list.filter(isEvent)
    fun eventFinder(pre: (Int) -> Boolean) {
        val fl = list.all(pre)
        println(fl)
    }

    eventFinder(isEvent)

    val map = mapOf<String, Int>("A" to 1, "B" to 2, "C" to 3)
    val mr = map.map { it.value }.all { it == 1 }
    println(mr)


    val list1 = listOf(1, 2, 3, 4)
    //list1.asSequence().map(::m).filter(::f).toList()
    //m1 f1 m2 f2 m3 f3 m4 f4
    list1.filter { it % 2 == 0 }.map(::m).toList() //?
    println("---------")
    val seq = generateSequence(3) { n ->
        println("Hello")
        (n + 1).takeIf { it < 7 }
    }

    println(seq.first())

    println(seq.toList())

    println(isEven { this + 1 == 5 })

    println(buildSomething(Pair(5, 2), { first + second }))

    val number = 42
    println(number.takeIf { it > 100 } ?: 0)

    val map1 =
        mapOf("Switch1" to Pair("ENABLE", "OPEN"), "Switch2" to Pair("DISABLE", "CLOSE"), "C" to Pair("ENABLE", "OPEN"))

    map1.map { it.value }.map { it.first }.filter { it == "ENABLE" }
    map1.entries.filter { it.value.second == "ENABLE" }
    map1.values.filter { it.second == "ENABLE" }

    val smartDevices = mapOf(
        "Thermostat" to Pair("ENABLE", "AUTO"),
        "Smart Lock" to Pair("DISABLE", "LOCKED"),
        "Camera" to Pair("ENABLE", "ACTIVE")
    )

    smartDevices.mapValues { it.value.second == "ENABLE" }

}

fun isEven(i: Int.() -> Boolean): Int {
    return if (i.invoke(4)) 100 else 0
}

inline fun <T, R> buildSomething(r: T, x: T.() -> R): R {
    return r.x()
}

val isEven1: () -> Boolean = { true }

inline fun newWith() {

}

fun m(i: Int): Int {
    print("m$i ")
    return i
}

fun f(i: Int): Boolean {
    print("f$i ")
    return i % 2 == 0
}