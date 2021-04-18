fun mapTest() {
    println("> mapTest -----------------------------------------------")

    val students = mapOf("Alice" to 23, "John" to 21, "Peter" to 23, "Anna" to 25, "Gildong" to 30, "Alice" to 22, "Alice" to 20)
    val stMap: Map<String, Int> = students

    println("students = ${students}")
    println("stMap = ${stMap}")
    println("stMap[\"Alice\"] = ${stMap["Alice"]}")
    println("stMap[\"Elle\"] = ${stMap["Elle"]}")
    println("stMap.get(\"Elle\") = ${stMap.get("Elle")}")
//    println("stMap.getValue(\"Elle\") = ${stMap.getValue("Elle")}")         // NoSuchElementException : Key Elle is missing in the map.

    val studentScores: Map<String, Float>
        = mapOf("Alice" to 4.3f, "John".to(3.2f), Pair("Peter", 3.5f))      // infix : to , to(), Pair(==Entry)
    println("studentScores = ${studentScores} with size ${studentScores.size}")
    println("studentScores.keys = ${studentScores.keys}")
    println("studentScores.values = ${studentScores.values}")

    val studentScores2: MutableMap<String, Float>
        = mutableMapOf("Alice" to 4.3f, "John".to(3.2f), Pair("Peter", 3.5f))      // infix : to , to(), Pair(==Entry)
    studentScores2["Peter"] = 4.0f
    studentScores2["Anna"] = 4.5f       // set(), put()
    studentScores2["Gildong"] = 2.2f
    studentScores2["Gildong2"] = 1.2f       // put()
    studentScores2.remove("John")

    println("studentScores2 = ${studentScores2} with size ${studentScores2.size}")
    println("studentScores2.keys = ${studentScores2.keys}")
    println("studentScores2.values = ${studentScores2.values}")


    checkEmail(null)
    checkEmail("")
    checkEmail("drinkjuice@")
    checkEmail("@naver.com")
    checkEmail("drinkjuice@naver.com")

    println("> mapTest -----------------------------------------------")
    println()
}

const val NOT_FOUND_AT = -1
fun checkEmail(email: String?): Boolean {
    if (email == null) {
        println("이메일 주소가 누락.")
        return false
    }

    val atPos = email.indexOf('@')
    if (atPos in arrayOf(NOT_FOUND_AT, 0, email.lastIndex)) {
        println("이메일 주소가 잘못 되었습니다.")
        return false
    }

    val key = email.substring(0..atPos-1)       // Range
    val value = email.substring(atPos+1..email.lastIndex)

    println("atPos = ${atPos}")
    println("key = ${key}, value = ${value}")

    return true
}