import java.io.*

enum class Monster {
    WaterMon, FireMon, EarthMon, WindMon
}

enum class Clan {
    DarkSide, LightSide
}

// property : 선언시 또는 init {} 안에서 초기화를 해야 한다. -> lateinit
class Player {
    lateinit var nick: String       // lateinit for var
    lateinit var leadMonster: Monster

    // by lazy : 단 한번 호출 ( val : readonly ), 처음 참조시
    val clan: Clan by lazy {
        // clan 결정 init delegated
        this.selectClan()
    }

    private fun selectClan() : Clan {
        var mySide: Clan = Clan.DarkSide

        Clan.values().forEach {
            println("${it.ordinal}: ${it.name} 진영 \t")
        }
        print(">> 진영을 선택: ")

        // try도 expression이 가능
        try {
            val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
            val sel = br.readLine()
            if (sel == "1") mySide = Clan.LightSide
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return mySide
    }

    override fun toString(): String {
        return "Player(nick='$nick', leadMonster=$leadMonster, clan=$clan"
    }
}

fun lateinitTest() {
    println("> lateinitTest -----------------------------------------------")

    val p1: Player = Player()
    p1.nick = "guest" + (Math.random() * 1000000).toInt()       // setter
    p1.leadMonster = Monster.FireMon
    println(p1.nick)            // UninitializedPropertyAccessException: lateinit property nick has not been initialized
    println(p1.leadMonster)

//    p1.clan = Clan.LightSide        // error val readonly
//    p1.clan
    println("p1.clan이 아직 초기화 되지 않은 시점")
    println("p1.clan = ${p1.clan}")
    println("플레이어: ${p1}")      // toString()

    println("> lateinitTest -----------------------------------------------")
    println()
}