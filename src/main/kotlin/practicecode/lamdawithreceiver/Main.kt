package practicecode.lamdawithreceiver

import java.nio.charset.StandardCharsets
import java.util.*


fun main(args: Array<String>) {

    fun check(x: Int, isItEven: Int.() -> Boolean): Boolean {
        return x.isItEven()
    }

    fun check1(input: Int, isEven: (Int) -> Boolean): Boolean {
        return isEven(input)
    }

    val result = check(20) { this % 2 == 0 }
    val result1 = check1(21, { it % 2 == 0 })

    println("The perfect result $result")
    println("The perfect result1 $result1")

    lambdaVar = { println("Check something") }
    val lambdaVar1:(Int, Int) -> Unit = { a: Int, b: Int -> println("===") }

    //lambdaVar
    lambdaVar1(10, 30)

    val test = StringBuilder()
    test.append("A")
    test.append("A")
    println(test)

    run { println("Direct run lambda") }
    run { println("Direct run lambda using invoke") }


}


private fun String.decodePassword(): String {
    val decodedText = Base64.getDecoder().decode(this)
    val text = String(decodedText, StandardCharsets.UTF_8)
    val password = text.split(":")
    return if (password.isNotEmpty()) password[1] else ""
}

var lambdaVar: (() -> Unit)? = null

//Lambda with receiver
val isEven: Int.() -> Boolean = { this % 2 == 0 }

//Lambda without receiver
val isEven1: (Int) -> Boolean = { it % 2 == 0 }
