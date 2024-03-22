package practicecode.lamdawithreceiver

import kotlin.concurrent.thread

data class Person(
    var name: String? = null,
    var age: Int? = null,
    var address: Address? = null
)

data class Address(
    var street: String? = null,
    var number: Int? = null,
    var city: String? = null
)

fun person(block: Person.() -> Unit): Person {
    val p = Person()
    p.block()
    return p
}

//same thing as the previous person function
//fun person(block: Person.() -> Unit): Person = Person().apply(block)

fun Person.address(block: Address.() -> Unit) {
    address = Address().apply {
        this.block()
    }
}

fun main(args: Array<String>) {
  /*  val person = person {
        name = "John"
        age = 25
        address {
            street = "Gaznabi"
            number = 5
            city = "Dhaka"
        }
    }*/

    thread(isDaemon = false) {
        Thread.sleep(1000L)
        println("World")
    }

    thread(isDaemon = false) {
        Thread.sleep(1000L)
        println("World")
    }

    thread(isDaemon = false) {
        Thread.sleep(1000L)
        println("World")
    }

    println("hELLO")
    Thread.sleep(200L)


    
}

