// default primary constructor
//class Student {}
//class Student public constructor() {}
//class Student private constructor() {}

//class Student(name: String?, age: Int, score: Float = 1.0f) {
//    val realName: String = name ?: "guest"
//    val email: String = "$realName@school.org"
//    val joinedAge: Int = age
//    var realScore: Float = score
//
//    fun showStatus() {
//        val status = """
//            ===          학생 재학증명          ===
//                 이름: $realName
//                 나이: $joinedAge 세
//                 학점: $realScore pt
//                 이메일: ${this.email}
//
//            =====================================
//        """
//        println(status)
//    }
//}

// change 1
class Student(val name: String?, val age: Int, var score: Float = 1.0f) {
//    val realName: String = name ?: "guest"
    val email: String = "$name@school.org"
//    val joinedAge: Int = age
//    var realScore: Float = score
    private val scholarship: Boolean = (age <= 20) && (score >= 3.8f)       // private : can not see out

    fun showStatus() {
        val status = """
            ===          학생 재학증명          ===
                 이름: $name             ${if(scholarship) "*장학생*" else ""}
                 나이: $age 세
                 학점: $score pt
                 이메일: ${this.email}
                 
            =====================================
        """
        println(status)
    }
}

// init
// secondary constructor
// property, init, secondary constructor order is important!!!
class Professor(_name: String, _age: Int = 30) {
    var name: String? = null
    val age: Int = _age

    init {
        // init for primary constructor
//        name = if (_name.isNotEmpty() && _name.isNotBlank()) _name else "Guest"
        name = if (_name.isNotBlank()) _name else "Guest"
        println("$name 교수님($age) 인스턴스")
    }

    var major: String = "인문학"
    constructor(_name: String, _age: Int, _major: String) : this(_name, _age) {
        println("Secondary 1 Constructor")
        this.major = _major
    }

    var fav: Double = 30.0
    constructor(_name: String, _age: Int, _major: String, fav: Double) : this(_name, _age, _major) {
        println("Secondary 2 Constructor")
        this.fav = fav
    }

    fun showStatus(num: Int) {
        val status = """
            === $num 교수 재직증명 ===
            이름: $name   ${if(fav >= 50) "**우수교수**" else ""}
            나이: $age
            전공: $major
            평가: $fav
            ========================
        """
        println(status)
    }
}

fun testConstructor() {
    println("> testConstructor -----------------------------------------------")

    val s1 = Student("Gildong", 22)
    val s2: Student = Student(null, 10, 2.0f)
    val s3 = Student("Yui", 19, 4.0f)
    val s4 = Student("Johm", 20, 3.3f)

//    s1.email = "king@school.org"        // err : val : read only
    s1.score = 2.9f     // set

    s1.showStatus()
    s2.showStatus()
    s3.showStatus()
    s4.showStatus()
    println()

    val p1 = Professor("David", 39)
    val p2 = Professor("Alice")
    val p3 = Professor("Park", 45, "경제학")
    val p4 = Professor("Susan", 22, "법학", 50.0)

    println()
    val pfs = arrayListOf(p1, p2, p3, p4)
    var itor = pfs.iterator()
    var num = 1
    while (itor.hasNext()) {
        var pf: Professor = itor.next()
        pf.showStatus(num++)
    }
//    p1.showStatus(1)
//    p2.showStatus(2)
//    p3.showStatus(3)
//    p4.showStatus(4)


    println("> testConstructor -----------------------------------------------")
    println()
}