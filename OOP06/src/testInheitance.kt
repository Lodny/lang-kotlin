import shapes.*

//package com.lodny.oop.shape
// open/override, final
// open class Parent
// class Child:Parent
// kotlin.Any
// super vs. this


fun inheritanceTest() {
    println("> inheritanceTest -----------------------------------------------")

    val ms = MyShape(POINT)
    ms.name = "원점"
    ms.showStatus()

    val sp: MyPoint = MyPoint()
    val ep1: MyPoint = MyPoint(10, 10, "도착점1")
    val ep2: MyPoint = MyPoint(40, 10, "도착점2")

    sp.color = RED
    sp.showStatus()
    sp.printPoint()

    println()

    drawLinewithTwoPoints(sp, null, "null 테스트")
    drawLinewithTwoPoints(sp, ep1, "라인 1")
    drawLinewithTwoPoints(sp, ep2, "라인 2")

    println()
    val line1: MyLine = MyLine()
    val line2 = MyLine("선")
    val line3 = MyLine(10, 10, 50, 80, "선3")
    val line4 = MyLine(MyPoint(), MyPoint(50, 80), "선4")
    val line5 = MyDottedLine(10, 10, 50, 80, "선5")
    val line6 = MyDashedLine(10, 10, 50, 80, "선6")

    val myLines = arrayListOf<MyLine>(line1, line2, line3, line4, line5, line6)
    for (ln in myLines)
        ln.showStatus()

    println()
    val triA: MyTriangle = MyTriangle(MyPoint(), MyPoint(40, 10), MyPoint(10, 40), "삼각형 A")
    triA.showStatus()



    println("> inheritanceTest -----------------------------------------------")
    println()
}

fun drawLinewithTwoPoints(sp: MyPoint?, ep: MyPoint?, name: String?, color: String = BLACK) {
    if (ep == null || sp == null) {
        println("점(들)이 null입니다.")
        return
    }

    val distance = Math.sqrt(
        (ep.y - sp.y) * (ep.y - sp.y).toDouble() +
        (ep.x - sp.x) * (ep.x - sp.x).toDouble())

    println("""
        |
        |*Shape*
        |이름: $name
        |타입: 선, 색상: $color
        |시작점 ${sp.pos()} => 끝점 ${ep.pos()}
        |길이: ${String.format("%.4f", distance)} pt
    """.trimMargin())
}
