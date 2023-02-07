package kotlincode

class NumberOfStepsToReduceToZero {
}
fun main(){
    var counter = 0
    var step = 14
    while (step !=0){
        if( step and 0x01 == 1) {
            step -=1
            counter++
        } else {
            step/=2
            counter++
        }
    }

    println("Total step: $counter")
}