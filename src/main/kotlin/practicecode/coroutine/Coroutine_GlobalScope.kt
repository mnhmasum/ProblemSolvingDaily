package practicecode.coroutine

import kotlinx.coroutines.*

fun main() = runBlocking {
    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }
    GlobalScope.launch {
        delay(2000L)
        println("World!")
    }
    println("Hello,")
// delay(3000L)
}
