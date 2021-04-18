fun listTest() {
    println("> listTest -----------------------------------------------")

    val myFriends = listOf("John", "Elle", "Bob", "Anna", "Bob")
    val frList: List<String> = myFriends
    println("myFriends list = ${myFriends}")

    for ((i, fr) in frList.withIndex())
        println("frList[$i] = ${fr}")

    println("frList[0] = ${frList[0]} ${frList.get(0)}")
    println("frList indexOf Bob = ${frList.indexOf("Bob")}")
    println("frList lastIndexOf Bob = ${frList.lastIndexOf("Bob")}")

    println("frList.subList(3, 5) = ${frList.subList(3, 5)}")

    // mutable
//    frList[4] = "Bob jr"            // err : immutable
    val myNewFriends = myFriends.toMutableList()
    myNewFriends.add("Alice")
    myNewFriends.set(myNewFriends.lastIndexOf("Bob"), "Bob Jr")
    myNewFriends.removeAt(2)
    println("myNewFriends = ${myNewFriends} - ${myNewFriends.size}명")

    val muStr = """
        |A generic ordered
        |collection of elements
        |that supports adding
        |and removing elements.""".trimMargin()
    println(muStr)

//    val words: List<String> = muStr.split(' ', '\n').sorted()
//    val words: List<String> = muStr.split(' ', '\n').sortedBy { it.length }
    val words: List<String> = muStr.split(' ', '\n').sortedByDescending { it.length }
    for ((i, w) in words.withIndex())
        println("words[$i] = ${w}")

    println("> listTest -----------------------------------------------")
    println()
}