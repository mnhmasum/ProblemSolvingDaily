package practicecode

import java.io.File

class AuthLog(_data: String, _numberOfData: Int) {

    var x: Int = 0

    init {
        x = _numberOfData
        //println(_numberOfData)
    }

    constructor(_data: String, sId: Double) : this(_data + sId, 100) {
        println(x)
    }

    constructor(_numberOfData: Int) : this("From count", 40)

}

fun List<Int>.allNonZero() = all { it != 0 }
fun List<Int>.allNonZero1() = none { it == 0 }
fun List<Int>.allNonZero2() = any { TODO() }

fun List<Int>.containsZero(): Boolean = any { it == 0 }
fun List<Int>.containsZero1() = all { TODO() }
fun List<Int>.containsZero2() = none { TODO() }

fun isEven(i: Int): Boolean = i % 2 == 0

fun main(args: Array<String>) {
    println("Hello World!")
    val events = listOf(Event("One", true), Event("One", true), Event("Three", true))

    val x = events.groupBy { it.name }

    //println(x.filter { it.value.size > 1 }.firstNotNullOf { it.value }.toList())

    val t = TaxiPark(
        setOf(Driver("D1"), Driver("D2")), setOf(Passenger("P1"), Passenger("P2"), Passenger("P3"), Passenger("P4")),
        listOf(
            Trip(Driver("D1"), setOf(Passenger("P1"), Passenger("P2")), 1, 2.5, 3.0),
            Trip(Driver("D1"), setOf(Passenger("P2"), Passenger("P3")), 1, 2.5, 3.0)
        )
    )

    val r = t.trips.map { it.passengers }.flatten().groupBy { it.name }
    val p = t.allPassengers.asSequence().filter { r.isNotEmpty() }.map { p -> p.name to (r[p.name]?.size ?: 0)
    }.filter { it.second >= 0 }.map { Passenger(it.first) }.toSet()

    //println(r)
    //println(p)

    val byDriver = t.trips.filter { it.driver.name == "D1" }
        .groupBy { it.driver.name }
        .filter { it.key == "D1" }
        .toList()
        .map { it.second }
        .flatten()
        .flatMap { it.passengers }
        .groupBy { it.name}
        .filter { it.value.size > 1 }
        .flatMap { it.value }.
        distinctBy { it.name }


        //?.groupBy { it.passengers }
       /* ?.filter { it.value.size>=5 }
        ?.flatMap { it.value }?.associateBy { it. }?.map { it.value }
        ?.toSet()*/



    println(byDriver)
}

interface OnTest<T> {
    fun <T> onTestGen(t: T)
}

fun provideToken(function: (String) -> Unit) {
    //async call here to an API service
    function.invoke("mytoken")
}

fun authenticate(): String? {
    var token: String? = null
    provideToken { providedToken ->
        token = providedToken
    }
    return token
}

data class Event(var name: String, val isEnable: Boolean)