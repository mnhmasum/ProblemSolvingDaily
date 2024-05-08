package practicecode.coroutine

import kotlinx.coroutines.*

fun main() = runBlocking {
    val resultDeferred: Deferred<Int> = GlobalScope.async {
        delay(1000L)
        42
    }
// do other stuff...

    println("No delay")

    val result: Int = resultDeferred.await() // (1 sec)
    println(result)

    println("After delay")
}

data class Foo(val x: String = "Test")

suspend fun getList(): String {
    return  coroutineScope {
        val t = ArrayList<Foo>()
        val a = Foo("fdsfdsf")
        t.add(a)
        "fdsfsdf"
    }
}