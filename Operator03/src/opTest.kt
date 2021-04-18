fun opTest() {
    println("> opTest -----------------------------------------------")

    val c = 21 % 10
    val d = 21.rem(10)      // reminder ( old> mod -> rem )

    val i = 3 in 1..10          // check(Boolean) range : in -> contains()
    val i2 = 3 in intArrayOf(1, 2, 3, 4, 5)
    val j = 'A' !in listOf('X', 'Y', 'Z')       // !in

    println("i = ${i}")

//    c.unaryPlus()
//    c.unaryMinus()

    println("> opTest -----------------------------------------------")
    println()
}