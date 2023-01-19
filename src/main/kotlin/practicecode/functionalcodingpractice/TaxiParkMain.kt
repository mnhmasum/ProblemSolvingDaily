package practicecode.functionalcodingpractice

import practicecode.Driver
import practicecode.Passenger
import practicecode.TaxiPark
import practicecode.Trip

fun main() {
    val taxiPark = TaxiPark(
        setOf(Driver("D1"), Driver("D2")), setOf(Passenger("P1"), Passenger("P2"), Passenger("P3"), Passenger("P4")),
        listOf(
            Trip(Driver("D1"), setOf(Passenger("P1"), Passenger("P2")), 1, 2.5, 3.0),
            Trip(Driver("D1"), setOf(Passenger("P2"), Passenger("P3")), 1, 2.5, 3.0)
        )
    )

    val r = taxiPark.trips.map { it.passengers }.flatten().groupBy { it.name }
    val p = taxiPark.allPassengers.asSequence().filter { r.isNotEmpty() }.map { p -> p.name to (r[p.name]?.size ?: 0)
    }.filter { it.second >= 0 }.map { Passenger(it.first) }.toSet()

    //println(r)
    //println(p)

    val byDriver = taxiPark.trips.filter { it.driver.name == "D1" }
        .groupBy { it.driver.name }
        .filter { it.key == "D1" }
        .toList()
        .map { it.second }
        .flatten()
        .flatMap { it.passengers }
        .groupBy { it.name}
        .filter { it.value.isNotEmpty() }
        .flatMap { it.value }.
        distinctBy { it.name }

    println(byDriver)
}
