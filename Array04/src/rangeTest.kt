fun rangeTest() {
    println("> rangeTest -----------------------------------------------")

    val naturalNumbers = 1..100     // 1, 2, 3, ... , 100   : 상하 포함
    val r1 = 1..(99+1)
    val r2 = IntRange(1, 100)
    val arr1: IntArray = r1.toList().toIntArray()       // toList(), toIntArray()
    val arr2: Array<Int> = r1.toList().toTypedArray()   // toTypedArray()

    val r3 = 100.rangeTo(200)     // rangeTo()

    val r4 = 100 until 200      // == 100..200-1    200 미포함
    val r5 = 200 downTo 100     // 100 미포함
    val r6 = (200 downTo 100).step(20)      // step()
    println("r5.joinToString(\", \") = ${r5.joinToString(", ")}")
    println("r6.joinToString(\", \") = ${r6.joinToString(", ")}")

    println()
    println("r3.last = ${r3.last}, r4.last = ${r4.last}, r5.last = ${r5.last}, r6.last = ${r6.last}, ")

    println()
    for (number in 1..20)
        if (number % 2 == 0) println("even number = ${number}")

    for (number2 in 2L..20L step 2L)
        println("long even number = ${number2}")

    println("(1..20).filter { it % 2 == 0  = ${(1..20).filter { it % 2 == 0 }}")

    println()
    for ( (i, n) in (51..80 step 4).withIndex())        // indices
        println("${i}번째 값 = $n")


    println("> rangeTest -----------------------------------------------")
    println()
}