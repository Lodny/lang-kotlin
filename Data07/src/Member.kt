// data class
    // getter/setter
    // toString()
    // equals()
    // hashCode()
    // copy

// data class
data class Member(var id: Int = 0,
                  var name: String = "no name",
                  var activityPoints: Double = 1.0,
                  var age: Int = 20,
                  var premiumLevel: Boolean = false,
                  var loginName: String = "guest",
                  var password: String = "1234")

enum class Membership(var aPoint: Double = 0.0, val desc: String = "기본 회원등급") {
    BASIC,
    FAMILY(3000.0, "가족 회원등급"),
    PREMIUM(5000.0, "프리미엄 회원등급"),
    VIP(10000.0, "최고 회원등급");            // ;  <- 구분 하기 위해 필요

    fun showCard() {
        println("""
        ====================================
            ${this.name} Membership
            $desc
            point: $aPoint, ${this.ordinal + 1} of ${Membership.values().size} 
        ====================================
        """.trimIndent())
    }
}

class MemberManager {
    private val memberList = ArrayList<Member>()

    fun joinMember(newMb: Member) {
        when {
            newMb.loginName.isBlank() -> {
                println("error: 로그인 아이디가 빈문자열.")
                return
            }
            newMb.loginName.length < 4 || newMb.loginName.length > 10 -> {
                println("error: 로그인 아이디 길이는 4~10만 가능.")
                return
            }
            newMb.loginName.equals("guest") -> {}
            else -> {
                println("정상 로그인 아이디: ${newMb.loginName} - ${newMb.hashCode()}")
            }
        }
        newMb.id = memberList.size + 1
        this.memberList.add(newMb)

    }

    fun showAllMembers() {
        println("=".repeat(110))
        println("     회원 리스트 (총 ${memberList.size}명)")
        this.memberList.forEach {
            println(it)     // toString()
        }
        println("=".repeat(110))
    }
}