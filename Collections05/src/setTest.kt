fun setTest() {
    println("> setTest -----------------------------------------------")

    val myNumberSet = setOf(2, 1, 3, 2, 2, 3, 1, 3, 3)
    val myNumberList = listOf(2, 1, 3, 2, 2, 3, 1, 3, 3)
    val myDistinctNumberList = myNumberList.distinct().sorted()
    println("myNumberSet = ${myNumberSet} => ${myNumberSet.size}개")
    println("myNumberList = ${myNumberList} => ${myNumberList.size}개")
    println("myDistinctNumberList = ${myDistinctNumberList} => ${myDistinctNumberList.size}개")

    for (n in myNumberSet) println("set n => $n")
    for ( (i, n) in myNumberSet.withIndex()) println("set[$i] => $n")

    val mySet: Set<Int> = myNumberSet
    println("mySet = ${mySet}")
    println("mySet.isEmpty() = ${mySet.isEmpty()}")
    println("4 in mySet = ${4 in mySet}")
    println("mySet.contains(4) = ${mySet.contains(4)}")

    // iterator
    // Set : Collection : Iterable ( iterator )

//    val myAlphabets = setOf<Char>('A', 'B', 'C', 'D', 69.toChar(), 'F', 'G')
    val myAlphabets = "ABCDEFG".toSet()         // toSet()
    val it = myAlphabets.iterator()             // iterator()
    while (it.hasNext()) {
        var ch = it.next()
        print("${ch} \t")
    }
    println()

    val myName = "BEN".toSet()
    val yourName = "DEA".toSet()
    val hisName = "XYZ".toSet()
    // sub set
    println("myAlphabets.containsAll(myName) = ${myAlphabets.containsAll(myName)}")
    println("myAlphabets.containsAll(yourName) = ${myAlphabets.containsAll(yourName)}")

    // intersect
    println("myAlphabets intersect myName = ${myAlphabets intersect myName}")
    println("myAlphabets intersect yourName = ${myAlphabets intersect yourName}")

    // union , +
    println("myAlphabets union myName = ${myAlphabets union myName}")
    println("myAlphabets + myName = ${myAlphabets + myName}")

    // subtract , -
    println("myAlphabets subtract myName = ${myAlphabets subtract  myName}")
    println("myAlphabets - myName = ${myAlphabets - myName}")

    val herName = setOf('M', 'a', 'r', 'y')
//    herName.add('n')        // error : immutable
    val herName2 = mutableSetOf('M', 'a', 'r', 'y')     // MutableSet<Char>
    herName2.add('n')
    herName2.addAll(setOf('L', 'e'))
    herName2.remove('y')
//    herName2.clear()

    println("herName2 = ${herName2}")

    println("> setTest -----------------------------------------------")
    println()
}