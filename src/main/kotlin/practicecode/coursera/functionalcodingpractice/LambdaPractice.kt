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

    println("isEvent result " + isEven { this + 1 == 5 })

    println(buildSomething(Pair(5, 2), { first + second }))

    val number = 42
    println(number.takeIf { it > 100 } ?: 0)

}

fun isEven(i: Int.() -> Boolean): Int {
    return if (i.invoke(4)) 100 else 0
}

inline fun <T, R> buildSomething(r: T, x: T.() -> R): R {
    return r.x()
}

val isEven1: () -> Boolean = { true }

fun m(i: Int): Int {
    print("m$i ")
    return i
}

fun f(i: Int): Boolean {
    print("f$i ")
    return i % 2 == 0
}