package shapes


val POINT: String = "점"
val LINE: String = "선"
val TRIANGLE: String = "삼각형"
val RECTANGLE: String = "사각형"

val BLACK: String = "0x000000"
val RED: String = "0xFF0000"
val GREEN: String = "0x00FF00"
val BLUE: String = "0x0000FF"


//
open class MyShape(val type: String? = null) {      // open
    var name: String? = null
    var color: String = BLACK

    open fun showStatus() {
        println("""
            |*Shape*
            |이름: $name
            |타입: $type, 색상: $color
        """.trimMargin())               // trimMargin()
    }

}