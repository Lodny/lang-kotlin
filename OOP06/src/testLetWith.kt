import java.util.*

//public inline fun <T,R> T.let(block: (T) -> R): R = block(this)
//public inline fun <T,R> with(receiver: T, block: T.() -> R): R = receiver.block()

internal class LicenseKey(var issuedBy: String? = null,
                          var description: String? = null,
                          var issuedNumber: Int = 0,
                          var words: Int = 4) {
    var key: String? = null
        private set
    var issuedWhen: Date? = null

    fun generate() {
        this.key = getLicenseKey(issuedBy ?: "tester", words)
    }
}

internal fun printLicenseKey(lcKey: LicenseKey?, issuer: String, order: Int, desc: String) {
//    lcKey.let({   })
    lcKey?.let {
        it.issuedWhen = Date()
        it.issuedBy = issuer
        it.issuedNumber = order
        it.description = desc

        it.generate()

        val br = "=".repeat(56)     // repeat
        println("""
            |$br
            |          *** License Key ***
            |     issued by ${it.issuedBy} at ${it.issuedWhen}
            |     serial 00000${it.issuedNumber}
            |     
            |     ${it.key}
            |     
            |     desc: ${it.description}
            |$br
            """.trimMargin())
    } ?: println("lcKey is null")
}

internal fun printLicenseKey2(lcKey: LicenseKey?, issuer: String, order: Int, desc: String) {

    if (lcKey == null) {
        println("lcKey is null!")
        return
    }

    // smart null ?
    with(lcKey) {
        issuedWhen = Date()
        issuedBy = issuer
        issuedNumber = order
        description = desc

        generate()

        val br = "=".repeat(56)     // repeat
        println("""
            |$br
            |          *** License Key ***
            |     issued by ${issuedBy} at ${issuedWhen}
            |     serial 00000${issuedNumber}
            |     
            |     ${key}
            |     
            |     desc: ${description}
            |$br
            """.trimMargin())
    }
}

fun letWithTest() {
    println("> letWithTest -----------------------------------------------")

    printLicenseKey(null, "gildong", 1, "길동이 테스트 키")
    println()
    printLicenseKey(LicenseKey(), "alice", 2, "게임앱 구매 키")
    println()
    printLicenseKey2(LicenseKey(), "john", 3, "미디어서버 설치 키")


    println("> letWithTest -----------------------------------------------")
    println()
}