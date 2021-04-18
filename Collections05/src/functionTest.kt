fun functionTest() {
    println("> functionTest -----------------------------------------------")

    joinToGuild(null)
    joinToGuild("Alice")
    joinToGuild("Alice")
    joinToGuild("Anna", 5)
    joinToGuild("John", 10, 1)
    joinToGuild("Angela", 33, 4)
    joinToGuild("Bob", 40, 3, 2.0f)
    
    joinToGuild("Peter", stat = 10.99f)     // named parameter
    joinToGuild("Gildong", stat = 7.7f, type = 2)       // named parameter, no order

    println("starGuild.toList().joinToString(\"\\n\") = ${starGuild.toList().joinToString("\n")}")

    println()

    varargFunc(1, 2, 3, 4, 5)
    println()

    putIceCreams("Frank", "체리맛", "초코맛", "딸기맛")
    putIceCreams("Susan", "체리맛", "바닐라맛", "바나나맛", "메론맛")
    putIceCreams("Frank", "오랜지맛", "쿠키맛")
    putIceCreams("Frank", "파인애플맛")
    println("basket = \n${basket.toList().joinToString("\n")}")
    println()

    // view : read-only
    val checkoutBasket: Map<String, String> = basket
//    checkoutBasket["Frank"] = "abc"     // immutable
    putIceCreams("Frank", "허니초코맛")
    val bonusIceCreaams = arrayOf("bn땅콩맛", "bn호두맛", "bn고구마맛")
    putIceCreams("Susan", "호박맛", *bonusIceCreaams, "당근맛")       // * : spread operator

    for (b in checkoutBasket) {
        println("${b.key} => ${b.value}")
    }

    println("> functionTest -----------------------------------------------")
    println()
}

val basket = mutableMapOf<String, String>()
fun putIceCreams(customer: String, vararg ic: String) {
    if (ic.isEmpty()) return        // isEmpty()

    val ics = basket[customer]
    basket[customer] = (if (ics == null) "" else "$ics,") + ic.joinToString(",")        // Map[key], template string
}

// 가변인자 vararg
// 0 ~ n개 인자
fun varargFunc(vararg numbers: Int) {
    println("numbers.javaClass = ${numbers.javaClass}")     // class [I -> integer array
    println("numbers.sum() = ${numbers.sum()}")
    println("numbers.average() = ${numbers.average()}")
    println("numbers.asList() = ${numbers.asList()}")       // asList()
    println("numbers.size = ${numbers.size}")
}


//val starGuild: MutableMap<String, String> = HashMap()
val starGuild = mutableMapOf<String, String>()
fun joinToGuild(nick: String?, level: Int = 1, type: Int = 0, stat: Float = 1.0f) {     // default value
    val playerTypes = arrayOf("검사", "마법사", "궁수", "성직자", "도적")
    val name = nick ?: "dummy"          // ?: -> Alvis operator ( if null )
    val typeNumber = if (type in 0..playerTypes.lastIndex) type else 0
    val member = "플레이어 $name: level $level, type ${playerTypes[typeNumber]}, stat $stat"

    // join
    if (starGuild.containsKey(name)) println("$name 플레이어 이미 가입됨.")
    else starGuild.put(name, member)
}

