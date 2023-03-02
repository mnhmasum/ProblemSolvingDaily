package practicecode

import java.math.BigInteger
import kotlin.experimental.and


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
    for (i in 1..2) {
        for (j in 10 downTo 1) {
            println("$i, $j")
        }
    }


    val list = listOf(1, 2, 4, 5, 6, 7, 8)
    val index = list.indexOfFirst { it == 4 }.takeIf { it > 0 }
    index?.let {  }
    println("Index $index")
    println("Hex ${hexStringToDecimal("FF")}")

    val x = generateSequence(0) { it + 1 }
    val iterator = x.iterator()

    for (i in 1..10) {
        println(iterator.next())
    }



}

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