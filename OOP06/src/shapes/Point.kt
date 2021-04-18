package shapes

// inheritance
class MyPoint(var x: Int = 0, var y: Int = 0, name: String = "원점") : MyShape(POINT) {
    init {
        super.name = name           // super
    }

    fun printPoint() {
        println("pt(x, y) => ($x, $y)\n")
    }

    fun pos() = Pair(this.x, this.y)        // Pair
}