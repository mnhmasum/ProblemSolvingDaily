package kotlincode

import java.lang.Math.min
import java.util.Collections.max

fun main(args: Array<String>) {
    val arr = listOf<Int>(0,-4,19,1,8,-2,-3,5)
    var minIndex = 0
    var maxIndex = 0
    for (i in arr.indices) {
        if (arr[i] > arr[maxIndex]) {
            maxIndex = i
        } else if (arr[i] < arr[minIndex]) {
            minIndex = i
        }
    }

    val front: Int = 1 + Math.max(maxIndex, minIndex)
    val back: Int = arr.size - Math.min(maxIndex, minIndex)

    val both: Int = 1 + min(maxIndex, minIndex) + (arr.size - Math.max(maxIndex, minIndex))

    val result =  Math.min(Math.min(front, back), both)

    println("back $back")
    println("front $front")
    println("both $both")
    println("result $result")
}