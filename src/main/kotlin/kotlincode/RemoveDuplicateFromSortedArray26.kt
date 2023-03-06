package kotlincode

import java.util.*
import kotlin.collections.HashMap
import kotlin.math.abs

class RemoveDuplicateFromSortedArray26 {
}

fun main() {
    val map: HashMap<Int, Int> = HashMap()

    var nums = IntArray(10)
    nums[0] = 0
    nums[1] = 0
    nums[2] = 1
    nums[3] = 1
    nums[4] = 1
    nums[5] = 2
    nums[6] = 2
    nums[7] = 3
    nums[8] = 3
    nums[9] = 4


    var toBeChangedIndex = 1
    for (i in 1 until nums.size) {
        if(nums[i] > nums[i-1]){
            nums[toBeChangedIndex] = nums[i]
            toBeChangedIndex++
        }
    }

    println(nums.contentToString())
    println(toBeChangedIndex)

}