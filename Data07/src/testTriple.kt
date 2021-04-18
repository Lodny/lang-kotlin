fun tripleTest() {
    println("> tripleTest -----------------------------------------------")

    val backpack1 = Pair(10, "검정색 백팩")
    println("backpack1.toString() = ${backpack1.toString()}")
    println("backpack1.javaClass = ${backpack1.javaClass}")
    println("backpack1.first = ${backpack1.first}")
    println("backpack1.second = ${backpack1.second}")

    val backpack2 = Triple(20, "분홍색 숄더백", 200.99f)
    println("backpack2.toString() = ${backpack2.toString()}")
    println("backpack2.javaClass = ${backpack2.javaClass}")
    println("backpack2.first = ${backpack2.first}")
    println("backpack2.second = ${backpack2.second}")
    println("backpack2.third = ${backpack2.third}")

    println()
    // member data class
    val mb0 = Member()
    val mb1 = Member(2, "안나", 2.0, 21, true, "anna", "abcd")
    val mb2 = Member(name="길동", loginName="gildong", activityPoints = 99.9)

    mb2.age = mb2.age + 1   // getter / setter
    mb2.password = "gggg"

    val mb3 = mb2.copy()    // copy
    val mb4 = mb2.copy(name = "손오공", loginName = "son1")

    println()
    val memberMgr = MemberManager()
    memberMgr.joinMember(mb0)
    memberMgr.joinMember(mb1)
    memberMgr.joinMember(mb2)
    memberMgr.joinMember(mb3)
    memberMgr.joinMember(mb4)
    memberMgr.showAllMembers()


    println("> tripleTest -----------------------------------------------")
    println()
}