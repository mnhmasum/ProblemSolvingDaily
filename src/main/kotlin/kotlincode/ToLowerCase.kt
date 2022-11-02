package kotlincode


fun main(){
    val  s = "HELLO@[]"
    val string:StringBuilder = StringBuilder()

    s.toCharArray().forEach {
        val t = if((it.toInt()>= 65) and (it.toInt() <=90)) {
            (it.toInt() or 32).toChar()
        } else {
            it
        }

        string.append(t)
    }



    println(string.toString())
}