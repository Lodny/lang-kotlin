import java.io.BufferedReader
import java.io.InputStreamReader

fun identityTest() {
    println("> identityTest -----------------------------------------------")

    val mb5 = Member()
    val mb6 = Member()

    if (mb5.equals(mb6)) println("mb5와 mb6는 내용이 equals() 같습니다.")

    if (mb5 == mb6) println("mb5와 mb6는 내용이 == 같습니다.")
    if (mb5 != mb6) println("mb5와 mb6는 내용이 != 같지 않습니다.")

    if (mb5 === mb6) println("mb5와 mb6는 내용과 주소도 === identical 같습니다.")
    if (mb5 !== mb6) println("mb5와 mb6는 내용이나 주소가 !== identical 같지 않습니다.")

    val br: BufferedReader = BufferedReader(
        InputStreamReader(System.`in`)      // ` : because in keyword
    )
    println("** 로그인 체크 **")
    print(">> login: ")
    val login = br.readLine()

    println("> identityTest -----------------------------------------------")
    println()
}