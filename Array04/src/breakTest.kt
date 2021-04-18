fun breakTest() {
    println("> breakTest -----------------------------------------------")

    println("isLeapYear(2016) = ${isLeapYear(2016)}")
    println("isLeapYear(2016) = ${isLeapYear(2017)}")
    println("isLeapYear(2016) = ${isLeapYear(1988)}")

    val testYears = arrayOf(1988, 1992, 1996, 2004, 2008, 2012, 1900, 2100, 2200, 2300, 2500, 1600, 2000, 2400, 2016)

    for ((i, y) in testYears.withIndex())
        println("testYears[$i] $y 년도 = ${ if(isLeapYear(y)) " leap year " else " common year "}")

    println()

    findFirstTenLeapYears(1583, 2013)

    println("> breakTest -----------------------------------------------")
    println()
}

fun findFirstTenLeapYears(from: Int, to: Int): IntArray {
    val years = if (from <= to ) from..to else from downTo to
    val foundLeaps = IntArray(10)
    var ly = 0

    for ((i, y) in years.withIndex()) {
        println("${i}번째 실행..")
        if (!isLeapYear(y)) continue

        foundLeaps[ly] = y
        println("윤년 발견 foundLeaps = ${foundLeaps.joinToString(",")}")
        ly++

        if (ly == foundLeaps.size)
            break
    }

    println()

    return foundLeaps
}

fun isLeapYear(year: Int): Boolean {
    return if (year % 4 != 0) false
        else if (year % 100 != 0) true
        else year % 400 == 0
}
