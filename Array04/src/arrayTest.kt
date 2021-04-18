fun arrayTest() {
    println("> arrayTest -----------------------------------------------")

    val a = Array(2, {0})
    val b = Array<Char>(3, { '_' })
    val c = Array<Int?>(4, { null })
    val d: Array<String> = arrayOf("aaa", "bbb", "ccc", "ddd", "eee")

    println("a.size = ${a.size}, b.size = ${b.size}, c.size = ${c.size}, d.size = ${d.size}")
    println("a[0] = ${a[0]}, b[0] = ${b[0]}, c[0] = ${c[0]}, d[0] = ${d[0]}")

    a.set(0, 33)
    b.set(0, 'A')
    c.set(0, 123)
    d.set(0, "abab")
    println("a[0] = ${a[0]}, b[0] = ${b[0]}, c[0] = ${c[0]}, d[0] = ${d[0]}")

    a[0] = 55
    b[0] = 'B'
    c[0] = 456
    d[0] = "baba"
    println("a[0] = ${a[0]}, b[0] = ${b[0]}, c[0] = ${c[0]}, d[0] = ${d[0]}")

//    println("a[2] = ${a[2]}")                   // ArrayIndexOutOfBoundsException
    println("array a = ${a}")
    println("array a = ${a.joinToString(", ")}")        // joinToString()
    println("a.lastIndex = ${a.lastIndex}")     //    index : 0 ~ size-1 or 0 ~ lastIndex

    val f1 = arrayOf<String>("banana", "apple", "orange")       // arrayOf()
    val f2: Array<String> = Array(3, { "_" })
    f2[2] = "plum"
    val fruitsArray = f1 + f2                                   // array + array
    val fruitsArray2 = arrayOf<String>(*f1, *f2)                // * : spread operator
    fruitsArray2[fruitsArray2.lastIndex] = "last plum"
    println("fruitsArray = ${fruitsArray.joinToString(", ")}")
    println("fruitsArray2 = ${fruitsArray2.joinToString(", ")}")

    val e = arrayOfNulls<String>(3)     // ==Array<String?>
    println("e[0] = ${e[0]}")

    val eng = charArrayOf('A', 'B', 'C')
    val prices = intArrayOf(100, 200, 3000)
    val temps = floatArrayOf(3.14F, 3.22F, 100f)
    val trueFalses = booleanArrayOf(true, false, true, true)
//    shortArrayOf()
//    byteArrayOf()
//    longArrayOf()
//    doubleArrayOf()

    println("> arrayTest -----------------------------------------------")
    println()
}