package kotlincode

import kotlin.math.abs

class ContainsDuplicate219 {
}

fun main() {
    val nums = listOf(1, 0, 1, 1)
    val k = 1
    var result = false

    val map: HashMap<Int, Int> = HashMap()
    for (i in nums.indices) {
        if (map.contains(nums[i])) {
            val x = abs(i - map[nums[i]]!!)
            if (x <= k) {
                result = true
            } else {
                map[nums[i]] = i
            }
        } else {
            map[nums[i]] = i
        }

    }

    println(map)

    println("Result: $result")
}