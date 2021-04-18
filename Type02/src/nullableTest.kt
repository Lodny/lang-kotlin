fun nullableTest() {
    println("> nullableTest -----------------------------------------------")

    var a: String = "ABCD"      // non-null type
//    a = null      // Null can not be a value of a non-null type String
    var b: String? = "XYZ"      // ? : nullable type
    b = null      // correct

    println("a.length = ${a.length}")
//    println("b.length = ${b.length}")       // Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type String?
    println("b?.length = ${b?.length}")     // safe call : ?.
//    println("b!!.length = ${b!!.length}")   // null이라도 감수하겠다.

    println("b.length 길이 => ${
        if (b != null) b.length         // smart cast : ?. -> .
        else "length를 알 수 없음"
    }")

    println("b?.length ?: length\"를 알 수 없음\" ㅣ = ${b?.length ?: "length를 알 수 없음"}")         // Alvis operator?:

    println(joinForm("홍길동", 33))
    println(joinForm(null, 22))
    println(joinForm(null, 22) ?: "가입 내용 누락.")

    println("> nullableTest -----------------------------------------------")
    println()
}

fun joinForm(name: String?, age: Int): String? {
    val result = if (name != null) "$name 가입 ($age 세)"
                else null

    return result
}