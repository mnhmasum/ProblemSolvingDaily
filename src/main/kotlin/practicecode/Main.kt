package practicecode

import java.math.BigInteger
import kotlin.random.Random


class Rational(numerator: BigInteger, denometor: BigInteger) {
    val numer: BigInteger
    val denom: BigInteger

    init {
        val divisor = numerator.gcd(denometor)
        val sign = numerator.signum().toBigInteger()
        numer = numerator / divisor * sign
        denom = denometor / divisor * sign
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Rational

        if (numer != other.numer) return false
        if (denom != other.denom) return false

        return true
    }

    override fun hashCode(): Int {
        var result = numer.hashCode()
        result = 31 * result + denom.hashCode()
        return result
    }

}

infix fun Int.divBy(r2: Int): Rational = Rational(toBigInteger(), r2.toBigInteger())


fun main(args: Array<String>) {

    val x = generateSequence(0) {
        println("Yeild $it")
        it + 1
    }
    println(x.take(5).toList())

    val oddNumbers = sequence {
        yield(2)
        yieldAll(generateSequence(2) { it + 2 })
    }

    //println(oddNumbers.take(5).toList())

    fun m(i: Int): Int {
        //print("m$i ")
        return i
    }

    fun f(i: Int): Boolean {
        //print("f$i ")
        return i % 2 == 0
    }

    val list = listOf(1, 2, 3, 4)
    //list.map(::m).filter(::f)  //m1 m2 m3 m4 f1 f2 f3 f4
    val a = oddNumbers.take(5).map(::m).filter(::f).toList() //?

    //println(a)


    val x1 = generateSequence {
        Random.nextInt(4).takeIf { it > 0 }
    }

    //println(x1.toList())

    val map = mutableMapOf<Int, MutableList<String>>()
    for (i in x1.toList()) {
        map[i] = mutableListOf()
        var group = map.getValue(i)
    }

    fun check(x: Int, isItEven: Int.() -> Boolean): Boolean {
        return x.isItEven()
    }

    fun check1(input: Int, isEven: (Int) -> Boolean): Boolean {
        return isEven(input)
    }

    val result = check(21) { this % 2 == 0 }
    val result1 = check1(21, { it % 2 == 0 })

    println("The perfect result $result")

}

val isEven: Int.() -> Boolean = { this % 2 == 0 }
val isEven1: (Int) -> Boolean = { it % 2 == 0 }

private fun hexStringToDecimal(inputTime: String = "FF"): String {
    return inputTime.toInt(16).toString()
}

interface Test {
    fun onClick()
}

interface Test1 : Test {
    override fun onClick() {
        TODO("Not yet implemented")
    }
}

fun process(x: BigInteger) {
    println(x.signum())
}

data class Event(var name: String, val isEnable: Boolean)