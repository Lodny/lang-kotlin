fun isasTest() {
    println("> isasTest -----------------------------------------------")

    var a: Any = 1234           // Any
    var a2: Any = 'A'
    var a3: Any = "xyz"
    a3 = 3.141592
    a3 = true

    val b1 = 365
    val b2 = b1 is Int          // is
    println("b1 is Int = ${b1 is Int}, b2 = ${b2}")
    println("a is Int = ${a is Int}")
    println("a2 is Char = ${a2 is Char}")
    println("a3 is Boolean = ${a3 is Boolean}")
    println("a3 !is String = ${a3 !is String}")         // !is

    val c1 = 123
    val c2 = 123L
    val c3: Byte = 123
    val c4: Short = 123
    println("c1.javaClass = ${c1.javaClass} ${c1 is Int}")
    println("c2.javaClass = ${c2.javaClass} ${c2 is Long}")
    println("c3.javaClass = ${c3.javaClass} ${c3 is Byte}")
    println("c4.javaClass = ${c4.javaClass} ${c4 is Short}")

    println()
    val c5: Any = c3
    println("c5.javaClass = ${c5.javaClass} ${c5 is Byte}")
    // 강제 cast
    val d: Byte = c5 as Byte            // as
//    val d: Int = c5 as Int      // ClassCastException : Byte와 Int는 완전히 다르게 취급

    // 명시적 방법 - 권장
    val d1: Int = d.toInt()
    val d2: Short = d.toShort()
    val d3: Long = d.toLong()
    val d4: Float = d.toFloat()
    val d5: Double = d.toDouble()
    val d6: Char = d.toChar()
    val d7: String = d.toString()

    println("d1 = ${d1}")
    println("d2 = ${d2}")
    println("d3 = ${d3}")
    println("d4 = ${d4}")
    println("d5 = ${d5}")
    println("d6 = ${d6}")
    println("d7 = ${d7}")

    println("> isasTest -----------------------------------------------")
    println()
}