fun forTest() {
    println("> forTest -----------------------------------------------")

    val iceCreams = intArrayOf(1000, 2000, 4500, 9000, 14000, 20000)
    val coffeeCups = IntArray(3, { i -> i * 2000 + 1000 })
    val sweetDonuts = IntArray(4)
    sweetDonuts.fill(990, 0, sweetDonuts.size)

    println("iceCreams.size = ${iceCreams.size} = ${iceCreams.joinToString(", ")}")
    println("coffeeCups.size = ${coffeeCups.size} = ${coffeeCups.joinToString(", ")}")
    println("sweetDonuts.size = ${sweetDonuts.size} = ${sweetDonuts.joinToString(", ")}")

    var index = 0

    println()
    for (ic in iceCreams) {
        println("ic[${index}] = ${ic}")
        index ++
    }

    println()
    for (i in iceCreams.indices)       // indices => 0..5 IntRange
        println("ic[${i}] = ${iceCreams[i]}")

    println()
    println("iceCreams[0] = ${iceCreams[0]}")
    println("iceCreams[iceCreams.size-1] = ${iceCreams[iceCreams.size-1]}")
    println("iceCreams[iceCreams.lastIndex] = ${iceCreams[iceCreams.lastIndex]}")       // lastIndex
    println("iceCreams.first() = ${iceCreams.first()}")     // first()
    println("iceCreams.last() = ${iceCreams.last()}")       // last()

    println()
    var ccSum = 0
    for (cc in coffeeCups) {
        println("cc = ${cc}")
        ccSum += cc
    }
    println("coffeeCups Sum = ${ccSum} won")
    ccSum = 0
    for ( (i, cc) in coffeeCups.withIndex()) {          // withIndex()
        println("cc[$i] = ${cc}")
        ccSum += cc
    }
    println("coffeeCups Sum = ${ccSum} won")
    println("coffeeCups Sum() = ${coffeeCups.sum()} won")       // sum()

    println()
    var sdSum: Double = 0.0
    for ( (i, sd) in sweetDonuts.withIndex()) {
        println("sd[$i] = ${sd}")
        sdSum += sd
    }
    println("sdSum = ${sdSum}, ${sweetDonuts.sum()}")
    println("sweetDonuts Avg = ${sdSum / sweetDonuts.size}, ${sweetDonuts.average()}")      // average()

    println()
    for ((i, ic) in iceCreams.withIndex())
        if ( ic > 5000 ) println("expensive $i => $ic")

    println("iceCreams.filter { it > 5000 } = ${iceCreams.filter { it > 5000 }}")       // filter
    println("iceCreams.find { it > 5000 } = ${iceCreams.find { it > 5000 }}")            // find

    println("> forTest -----------------------------------------------")
    println()
}