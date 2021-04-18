fun sayHello() {
    val msg = "Again!!"
    println("Hello Again!")
    println("Hello " + msg)
    println("Hello ${msg}")
}

fun sayHelloMsg1(msg: String) {
    println("안녕하세요! " + msg)
}

class Greeting(val to: String, val msg: String) {
    fun sayHello() {
        println()
        println("${to} ${msg}!")
    }
}