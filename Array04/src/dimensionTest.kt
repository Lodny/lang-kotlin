fun dimensionTest() {
    println("> dimensionTest -----------------------------------------------")

    var str1: CharArray = charArrayOf('A', 'B', 'C', 'D', 'E')
    var str2: String = "ABCDE"

    println("str1 = ${str1.joinToString("")}")
    println("str2 = ${str2.toCharArray().joinToString(",")}")

    val c0 = str2[0]        // str2.get(0)  // 'A'
    val c1 = str2[1]        // 'B'
//    str2[2] = 'Z'       // error : no set method

    println("c0 = ${c0}, ${c0.toInt()}, ${c0.javaClass}")
    println("str2.lastIndex = ${str2[str2.lastIndex]}, ${str2[str2.lastIndex].toInt()}, ${str2[str2.lastIndex].javaClass}")
    println()

    val numbers2d = Array(3, {IntArray(4)})

    // row 0 1 2, column 0 1 2 3 => 12개
    val number2dZero = Array(3, { IntArray(4, { 0 })})
    for ( (i, row) in  number2dZero.withIndex()) {
        for ((j, column) in row.withIndex())
            print("[$i, $j] => $column\t")

        println()
    }

    println()
    val numbers2Ordered
            = Array(3, { i -> IntArray(4, { j -> j + i * 4 })})
    for ( (i, row) in  numbers2Ordered.withIndex()) {
        for ((j, column) in row.withIndex())
            print("[$i,$j] => $column\t")

        println()
    }

    println()

    val myFriends = arrayOf<String>("John", "Alice", "Bob", "Anna")
    if (myFriends[0] == "John") println("첫번째 친구 이름 : ${myFriends[0]}")
    if (myFriends[1][0] == 'A') println("두번째 친구의 첫글자 : ${myFriends[1][0]}")
    if (myFriends[1][0] == 'A') println("두번째 친구의 첫글자 : ${myFriends.get(1).get(0)}")

    println("가장 이름길이가 긴 친구의 문자길이 = ${myFriends.map { it.length }.maxOrNull() }")


    println("> dimensionTest -----------------------------------------------")
    println()
}