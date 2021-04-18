// private, protected, internal, public
// declaring scopes
// top-level declaration & import

// 주어긴 길이만큼 대문자 + 숫자로 이루어진 임의이 코드 문자열을 생성하는 클래스
// 26 + 10 임의 생성 => 중복 허용

private const val LicenseName = "Cocopalm"
internal const val LicenseName2 = "Cocopalm2"

fun getCode(pre: String?, len: Int?) = Code(pre ?: "", len ?: 8)._c

internal fun getLicenseKey(lcpre: String? = "", count: Int = 4): String {
    var str: String = ""
    repeat(4) {
        str += getCode("", 8)
    }

    return lcpre + str
}

private class Code(pre: String = "", len: Int = 8) {
    val _c : String
    init {
        _c = pre + "_" + generateCode(len)
    }

    private fun generateCode(upto: Int): String {
        val chars = CharArray(upto)
        val nums = ('0'..'9').toList()
//        val alphas = ('A'..'Z').toList()
        val alphas = CharRange('A', 'Z').toList()
        val alphaNums = nums + alphas
        for (i in 0 until upto) {       // until
            val ran = (Math.random() *  alphaNums.size).toInt()
            chars[i] = alphaNums[ran]
        }

        return chars.joinToString("")
    }
}


fun testVisibility() {
    println("> testVisibility -----------------------------------------------")

    println("Code() = ${Code()._c}")
    println("Code('good') = ${Code("good")._c}")
    println("Code('long') = ${Code("long", 16)._c}")

    println("> testVisibility -----------------------------------------------")
    println()
}