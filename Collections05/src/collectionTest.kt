import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

fun collectionTest() {
    println("> collectionTest -----------------------------------------------")

    val mySet: HashSet<Char> = hashSetOf()
    val myList: ArrayList<Char> = arrayListOf()
    val myMap: HashMap<String, Char> = hashMapOf()

    mySet.add('A')
    myList.add('B')
    myMap.put("first", 'C')

    myList.set(0, 'D')          // update
    mySet.remove('A')    // delete
    myMap.clear()

    println("mySet = ${mySet}, myList = ${if (myList.isEmpty()) "none" else myList.get(0)}")
    println("myMap[\"first\"] = ${myMap["first"]}")

    println()

    makeEventTicket()


    println("> collectionTest -----------------------------------------------")
    println()
}

fun makeEventTicket() {
    val eventTitles = listOf("요리 축제", "장난감 전시회", "패션 런어웨이", "프로야구", "음악회")
    val eventRanks: HashMap<Char, Int> = hashMapOf<Char, Int>()
    eventRanks.put('N', 1000)       // normal : 1000
    eventRanks.put('H', 3000)
    eventRanks.put('F', 5000)
    eventRanks.put('S', 10000)       // super : 10000

    println("eventTitles = ${eventTitles}")
    println("eventRanks = ${eventRanks}")

    // Tickets
    var cash = 20000
    val ticketList = arrayListOf<Map<String, Any?>>()

    while (cash > 0) {
        val rEvent: Int = (Math.random() * eventTitles.size).toInt()
        val rRankRumber: Int = (Math.random() * 100).toInt() + 1        // 1 ~ 100
        val rRank: Char = when (rRankRumber) {
            in 91..100 -> 'S'
            in 71..90 -> 'F'
            in 41..70 -> 'H'
            else -> 'N'
        }
        println("eventRanks[rRank] = ${eventRanks[rRank]}")

        if (cash < eventRanks.getValue(rRank)) break

        // 발권
        val ticket = mapOf(
            "title" to eventTitles[rEvent],
            "rank" to rRank,
            "price" to eventRanks[rRank],
            "date" to Date()
        )
//        cash -= eventRanks[rRank]     // ???
        cash -= eventRanks.getValue(rRank)

//        println("ticket = ${ticket}")

        ticketList.add(ticket)
    }

    println("티켓발권리스트")
    println("ticketList = ${ticketList.joinToString("\n")}")

//    ticketList.forEach { printTicket(it)}
    for ((i, pt) in ticketList.withIndex())
        printTicket(pt, i + 1)
}

fun printTicket(ticket: Map<String, Any?>, num: Int) {
    val df = java.text.SimpleDateFormat("yyyy년 MM월 dd일")
    val printed = """
    ========================================================
    ***   티켓   ***     [00${num}]
    '${ticket["title"]}' event
            rank ${ticket["rank"]} / ${ticket["price"]}원
    ${df.format(ticket["date"])} 까지          
    ========================================================        
    """
    println(printed)
}