package practicecode

import java.math.BigInteger


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

infix fun Int.divBy(r2: Int) : Rational = Rational(toBigInteger(), r2.toBigInteger())


fun main(args: Array<String>) {
    println("Hello World!")
    val events = listOf(Event("One", true), Event("One", true), Event("Three", true))
    println(1.plus(4))
    process("-6".toBigInteger())
    println(Rational("2".toBigInteger(),"4".toBigInteger()))
    println(Rational("4".toBigInteger(),"28".toBigInteger()))
    println("12".toBigInteger().rem("5".toBigInteger()))

    val x = 1 divBy 2
    val y = 4 divBy 28

    println(x == y)
}

fun process(x: BigInteger) {
    println(x.signum())
}

data class Event(var name: String, val isEnable: Boolean)