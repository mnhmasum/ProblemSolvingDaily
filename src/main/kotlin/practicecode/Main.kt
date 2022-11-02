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

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    val list = listOf<String>("Uddin,Nasir", "Yousaf, Muhammad")
    val x = list.map {
        it + "XX"
    }

    x.filter { it.lowercase().contains("U") }.forEach {
        println("Filtered with contains $it")
    }

    println(list)
    println(x)

    val events = listOf<Event>(Event("One", true), Event("Two", true), Event("Three", false))

    events.map {
        val event = it
        event.name = event.name + "XXX"
        event
    }

    println(events)

    val r = events.filter { it.isEnable in listOf<Boolean>(true, false) }.flatMap {
        val result: ArrayList<String> = ArrayList<String>()
        result.add("=>${it.name}")
        result
    }

//    val arrayList:ArrayList<Event> = ArrayList()
//    arrayList.flatMap {
//        val arrayList:ArrayList<Event> = ArrayList()
//        arrayList
//    }


    print(r)

    AuthLog("Masum", 89.0)

    val files = File("Test").listFiles()

    println(files?.size)

    var a = 1
    var b = 2
    a = b.also { b = a }
    print(a)
    println(b)


    val f = OnCLickListenerCustom { event ->
        println(event.name)
    }

    f.onClickFired(events[0])

    var d: Int  // 1

    if (true) {
        d = 1   // 2
    } else {
        d = 2   // 2
    }

    println(d)

    println(authenticate())


}

class OnCLickListenerCustom(val clickHolder: (event: Event) -> Unit) {
    fun onClickFired(event: Event) {
        clickHolder(event)
    }
}

interface OnTest<T> {
    fun <T> onTestGen(t: T)
}

fun provideToken(function : (String) -> Unit) {
    //async call here to an API service
    function.invoke("mytoken")
}

fun authenticate() : String? {
    var token : String? = null
    provideToken { providedToken ->
        token = providedToken
    }
    return token
}

data class Event(var name: String, val isEnable: Boolean)