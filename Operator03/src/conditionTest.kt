fun conditionTest() {
    println("> conditionTest -----------------------------------------------")

    var a: Int = 0
    a = 122
    a++

    if (true) {
        a = 200
        a--
    }
    if (false) a = -1
    println("a = ${a}")


    val numberType = if (a % 2 == 1) "$a 는 홀수" else "$a 는 짝수"       // expression if
    println("numberType = ${numberType}")

    println(getAbsoluteValue(10, 20))
    println(getAbsoluteValue(-10, 20))


    when (a) {
        !in 10..200 -> println("${a}가 범위 안에 있음")
        !is Int -> {
            println("a 타입 판정했아나..")
            println("a는 Int 타입이 아님.")
        }
        199 -> println("a는 199임")
        else -> println("a는 어느 경우도 아님")
    }


    println("> conditionTest -----------------------------------------------")
    println()
}

fun getAbsoluteValue(num1: Int, num2: Int) = if (num1 > num2) num1 - num2 else num2 - num1