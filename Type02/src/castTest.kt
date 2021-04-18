fun smartTest() {
    println("> smartTest -----------------------------------------------")

    whichType("ABCDEFG")
    whichType(123)
    whichType(-10)
    whichType(3.14f)
    whichType(true)

    println("> smartTest -----------------------------------------------")
    println()
}
fun whichType(data: Any) {

    if (data is String) {
        val result: String = data as String
        println("result.length = ${result.length}")

        // smart cast automatic : 위에서 확인했기 때문에 String
        println("data.length = ${data.length}")
    } else if (data is Int) {
        val result: Int = data as Int
        println("result * 2 = ${result * 2}")

        // smart cast automatic : 위에서 확인했기 때문에 Int
        println("data * 2 = ${data * 2}")
    } else {
        println("$data 는 String형도 아니고 Int형도 아니다. = ${data.javaClass} 형이다.")

//        val result = data as Float            // ClassCastException
        val result = data as? Float             // as?  -> safe cast (nullable cast)
        println("강제로 Float로 변환 = ${result}")
    }
}