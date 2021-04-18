package shapes

class MyTriangle : MyShape {
    val pts: ArrayList<MyPoint> = ArrayList()
    val lines: ArrayList<MyLine> = ArrayList()

    constructor(pt0: MyPoint, pt1: MyPoint, pt2: MyPoint, _name: String) : super(TRIANGLE) {
        name = _name
        pts.add(pt0)
        pts.add(pt1)
        pts.add(pt2)
        lines.add(MyLine(pt0, pt1, "삼각형의 변1"))
        lines.add(MyLine(pt1, pt2, "삼각형의 변2"))
        lines.add(MyLine(pt2, pt0, "삼각형의 변3"))
    }

    constructor(pts: Array<MyPoint>, _name: String) : super(TRIANGLE) {
        name = _name
        if (pts.size != 3) throw IllegalAccessException("접이 3개가 아님.")
        this.pts.addAll(pts)
        (1..3).mapTo(lines) {
            MyLine(pts[it-1], pts[ if (it == 3) 0 else it ], "삼각형의 변$it")
        }
    }

    final override fun showStatus() {
        super.showStatus()
        printTriangle()
    }

    fun pos() = Triple(pts[0], pts[1], pts[2])

    fun getArea(): Double {
        val ds = doubleArrayOf(lines[0].getDistance(), lines[1].getDistance(), lines[2].getDistance() )
        val s = ds.sum() / 2
        val area = Math.sqrt(
            s * (s - ds[0]) * (s - ds[1]) * (s - ds[2])
        )

        return area
    }

    private fun printTriangle() {
        println("""
            |점0: ${pts[0].pos()} => 점1: ${pts[1].pos()} => 점2: ${pts[2].pos()}
            |넓이: ${String.format("%.4f", getArea())} t^2 
        """.trimMargin())
    }
}