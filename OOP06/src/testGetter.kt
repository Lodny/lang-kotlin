// default getter/setter
// custom getter/setter
// field keyword
// constructor order

class UrlChecker {
    private val DEF_URL = "http://www.human.com"
    var url: String = initMyUrl()       // force initialize
    var description: String? = null     // custom getter/setter
        get() = field ?: "설명이 아직 없네요."      // field keword
        set(value) {
            if (!value.isNullOrBlank())
                field = value
        }
//    val isHttp: Boolean
//        get() = url.startsWith("http://")
    val isHttp get() = url.startsWith("http://")        // 1.1      // only getter
//        set(value) {}       // error

    constructor(_url: String?) {
        url = _url ?: DEF_URL
        println("secondary 1 constructor")
    }

    init {
        println("init")
    }

    private fun initMyUrl() : String {
        println("initialize url field")
        return ""
    }

    fun showUrl() {
        println("""
            -------------------------------------------
                  URL: $url
                  설명: $description
                  http 프로토콜: ${if (isHttp) "YES" else "NO"}
            -------------------------------------------            
        """)
    }
}

fun testGetter() {
    println("> testGetter -----------------------------------------------")

    val url1 = UrlChecker("http://www.google.com")
    println("url1.url = ${url1.url}")       // default getter
    url1.description = "검색 엔진 구글입니다."
    url1.showUrl()

    val url2 = UrlChecker(null)
    println("url2.url = ${url2.url}")       // default getter
    url2.description = "휴먼 데이터 센터입니다."
    url2.showUrl()

    val url3 = UrlChecker("ftp://www.naver.com")
    url3.description = "네이버"
    url3.showUrl()


    println("> testGetter -----------------------------------------------")
    println()
}