fun nestedLoopTest() {
    println("> nestedLoopTest -----------------------------------------------")

    printTriangle(1)
    printTriangle(2)
    printTriangle(3)
    printTriangle(4)

    val typeA = intArrayOf(1, 3)
    val typeB = intArrayOf(4, 2)
    val typeC = intArrayOf(4, 4, 4, 4, 4)
    val typeT = intArrayOf(0)

    val shapes = arrayOf(typeB, typeA, typeA, typeC, typeT, typeC, typeC, typeC)

    var i = 0
    abc@ while (i < shapes.size) {
        for (triangle in shapes[i]) {
            if (triangle == 0) break@abc
            printTriangle(triangle)
        }
        i++
    }

    println("> nestedLoopTest -----------------------------------------------")
    println()
}

fun printTriangle(target: Int) {
    println("${target}번 도형")

    val row = when (target) {
        1, 2 -> 1..4
        else -> 4 downTo 1
    }

    val column = when (target) {
        1, 3 -> 1..8
        else -> 8 downTo 1
    }

    for (i in row) {
        for (j in column)
            print("${if (j <= (i-1)*2) " " else "O"}")

        println()
    }
}