package practicecode

import java.util.*


class Test3 {

}

fun main(args: Array<String>){
    val t = "002-This is a text with more than 16 character I should be cut out in two separate line"

    println(t.substring(4,16))
    println(t.substring(16,t.length))

    timeList().forEachIndexed { index, s ->

        if(s.contains("7:00 AM")) {
            println("$index and $s")
        }
    }
}

fun timeList() = arrayOf("12:00 AM",
    "12:30 AM",
    "1:00 AM",
    "1:30 AM",
    "2:00 AM",
    "2:30 AM",
    "3:00 AM",
    "3:30 AM",
    "4:00 AM",
    "4:30 AM",
    "5:00 AM",
    "5:30 AM",
    "6:00 AM",
    "6:30 AM",
    "7:00 AM",
    "7:30 AM",
    "8:00 AM",
    "8:30 AM",
    "9:00 AM",
    "9:30 AM",
    "110:00 AM",
    "110:30 AM",
    "111:00 AM",
    "111:30 AM",
    "112:00 PM",
    "112:30 PM",
    "1:00 PM",
    "1:30 PM",
    "2:00 PM",
    "2:30 PM",
    "3:00 PM",
    "3:30 PM",
    "4:00 PM",
    "4:30 PM",
    "5:00 PM",
    "5:30 PM",
    "6:00 PM",
    "6:30 PM",
    "7:00 PM",
    "7:30 PM",
    "8:00 PM",
    "8:30 PM",
    "9:00 PM",
    "9:30 PM",
    "10:00 PM",
    "10:30 PM",
    "11:00 PM",
    "11:30 PM")