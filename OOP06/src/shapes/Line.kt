package shapes

open class MyLine(name: String = "테스트선") : MyShape(LINE) {
    var sp: MyPoint
    var ep: MyPoint
    var thick: Int = 1
    open protected val strokenType = "solid"       // 실선

    init {
        super.name = name
        sp = MyPoint()
        ep = MyPoint(10, 10)
    }

    constructor(_sp: MyPoint? = MyPoint(), _ep: MyPoint?, _name: String): this(_name) {
        this.sp = _sp ?: MyPoint()
        this.ep = _ep ?: MyPoint(10, 10)
    }

    constructor(x1: Int = 0, y1: Int = 0, x2: Int, y2: Int, _name: String): this(_name) {
        this.sp = MyPoint(x1, y1)
        this.ep = MyPoint(x2, y2)
    }

    private fun printLine() {
        println("""
        |선종류: $strokenType, 선두께: $thick pt
        |시작점 ${sp.pos()} => 끝점 ${ep.pos()}
        |길이: ${String.format("%.4f", getDistance())} pt
        """.trimMargin())
    }

    final override fun showStatus() {     // open -> override   // final : end override
        super.showStatus()
        printLine()
    }

    fun getDistance() = Math.sqrt(
        (ep.y - sp.y) * (ep.y - sp.y).toDouble() +
        (ep.x - sp.x) * (ep.x - sp.x).toDouble())

    fun pos() = Pair(sp, ep)
}

class MyDottedLine: MyLine {
    override val strokenType: String = "dotted"
//        get() = super.strokenType

    init {
        super.thick = 2
    }

    constructor(_sp: MyPoint? = MyPoint(), _ep: MyPoint?, _name: String)
            : super(_sp, _ep, _name)         // super
    constructor(x1: Int = 0, y1: Int = 0, x2: Int, y2: Int, _name: String)
            : super(x1, y1, x2, y2, _name)
}

class MyDashedLine: MyLine {
    override val strokenType: String = "dashed"
//        get() = super.strokenType

    init {
        super.thick = 2
    }

    constructor(_sp: MyPoint? = MyPoint(), _ep: MyPoint?, _name: String)
            : super(_sp, _ep, _name)
    constructor(x1: Int = 0, y1: Int = 0, x2: Int, y2: Int, _name: String)
            : super(x1, y1, x2, y2, _name)
}


