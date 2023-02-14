package kotlincode

class XOROperationInAnArray {
}

fun main(){
    val start = 3
    var result = 0
    for (i in 0 until 4){
        println(start + 2 * i)
        result = result xor start + 2 * i
    }

    println(result)
}