fun whileTest() {
    println("> whileTest -----------------------------------------------")

    isPrimeNumber(7)
    isPrimeNumber(111)

    val myNumbers = intArrayOf(3, 8, 9, 13, 15, 17, 20)
    var i =0
    do {
        isPrimeNumber(myNumbers[i])
        i++
    } while (i < myNumbers.size)

    println("> whileTest -----------------------------------------------")
    println()
}

fun isPrimeNumber(num: Int) {
    println("\n$num 소수판단")

    when {
        num <= 1 -> return
        num == 2 -> println("2는 당연히 소수 입니다.")
        num >= 3 -> {
//            for (n in 2..num - 1) {
//                println("${n}으로 나눠보기..")
//                if (num % n == 0) {
//                    println("${num}은 ${n}으로 나눠 떨어짐")
//                    return
//                }
//            }
            // while문으로
            var n = 3
            while (n < num) {
                println("${n}으로 나눠보기..")
                if (num % n == 0) {
                    println("${num}은 ${n}으로 나눠 떨어짐")
                    return
                }
                n++
            }
            println("${num}은 소수입니다.")
        }
        else -> return
    }
}