package practicecode

class InterfacePractice {
}

fun main() {
    val interfacePractice: (Int) -> Boolean = { it % 2 == 0 }
    val x = IntPredicate(interfacePractice)
}

fun <E> printArray(elements: Array<E>) {
    for (element in elements) {
        println(element)
    }
    println()
}

interface MyTest<T> {
    fun onTestClick(t: T)
}

fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

class A(private val onTest: OnTap<Int>) {
    interface OnTap<T> {
        fun onItemTap(t: T)
    }
}