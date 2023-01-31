package practicecode.coursera.rational

import java.math.BigInteger
import java.math.BigInteger.*

class Rational(numerator: BigInteger, denominator: BigInteger) : Comparable<Rational> {
    val numer: BigInteger
    val denom: BigInteger

    init {
        val divisor = numerator.gcd(denominator)
        val sign = denominator.signum().toBigInteger()
        numer = numerator / divisor * sign
        denom = denominator / divisor * sign
    }

    override fun compareTo(other: Rational): Int {
        return ((numer * other.denom) - (denom * other.numer)).signum()
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

    operator fun unaryMinus(): Rational = Rational(-numer, denom)

    operator fun plus(other: Rational): Rational = Rational(
        (numer * other.denom) + (other.numer * denom),
        denom * other.denom
    )

    operator fun minus(other: Rational): Rational = Rational(
        (numer * other.denom) - (other.numer * denom),
        denom * other.denom
    )

    operator fun times(other: Rational): Rational = Rational((numer * other.numer), (denom * other.denom))

    operator fun div(other: Rational): Rational {
        val r2 = Rational(other.denom, other.numer)
        return times(r2)
    }

    override fun toString(): String {
        if (numer < ZERO && numer > denom) return "-$numer/$denom"
        if (denom < ZERO && numer > denom) return "-$numer/${denom.abs()}"

        if (numer > denom && numer.rem(denom) == ZERO) return numer.toString()
        return "$numer/$denom"
    }

}

infix fun Int.divBy(r2: Int): Rational = Rational(toBigInteger(), r2.toBigInteger())
infix fun Long.divBy(r2: Long): Rational = Rational(toBigInteger(), r2.toBigInteger())
infix fun BigInteger.divBy(r2: BigInteger): Rational = Rational(this, r2)

fun String.toRational(): Rational {
    if (!contains("/")) {
        return Rational(toBigInteger(), ONE)
    }
    val (numerator, denominator) = split("/")
    return Rational(numerator.toBigInteger(), denominator.toBigInteger())
}

fun main() {
    val half = 1 divBy 2
    val third = 1 divBy 3

    val sum: Rational = half + third
    println(sum)
    println(5 divBy 6 == sum)

    val difference: Rational = half - third
    println(1 divBy 6 == difference)

    val product: Rational = half * third
    println(1 divBy 6 == product)

    val quotient: Rational = half / third
    println(3 divBy 2 == quotient)


    val negation: Rational = -half
    println(-1 divBy 2 == negation)

    println((2 divBy 1).toString() == "2")
    println((-2 divBy 4).toString() == "-1/2")

    println("117/1098".toRational().toString() == "13/122")

    val twoThirds = 2 divBy 3
    println(half < twoThirds)

    println(half in third..twoThirds)

    println(2000000000L divBy 4000000000L == 1 divBy 2)

    println(
        "912016490186296920119201192141970416029".toBigInteger() divBy
                "1824032980372593840238402384283940832058".toBigInteger() == 1 divBy 2
    )

}