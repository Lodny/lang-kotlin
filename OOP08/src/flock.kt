internal const val LENGTH = 20       // 각도는 아직

enum class Color(val hexColor:String) {
    RED("FF0000"), GREEN("00FF00"), BLUE("0000FF"),
    BLACK("000000"), YELLOW("FFFF00"), WHITE("FFFFFF"),
}

enum class Status(val exp:String) {
    NONE("비행 시작 전"), READY("새총 위에 준비된"), SHOT("발사된"),
    FLYING("날아가는"), CRASHED("충돌한"), END("비행을 완료한"),
}

abstract class Flock {
    lateinit var name: String
    open val color: Color = Color.RED
    var power: Double = 10.0
    open val weight: Double = 1.1
    var status: Status = Status.NONE
    open val type: String = "Red"    // 신규 추가

//    constructor(name: String): this() {
//        this.name = name
//    }

    protected fun getRandom(max: Int = 10) = (Math.random() * max).toInt() + 1
    protected fun getDamage() = power * weight * getRandom()

    override fun toString(): String {
        return "${status.exp} '$name' ${type}새(power=$power, weight=$weight)"
    }

    // 새총 위에 올려지다
    fun readyForShoot() {
        println("step1: ${this}가 새총위에 올려지다.")
        this.status = Status.SHOT
    }

    // 고무줄을 당기다
    fun adjustAngleLength() {
        println("step2: ${this}가 고무줄이 당겨져 발사되다.")
        this.power += getRandom(LENGTH) * this.weight
        println("\t>> 결정된 power: $power")
        this.status = Status.SHOT
    }

    // 발사되어 날아가다
    abstract fun flyAfterShoot()

    // 장애물에 부딪혀 충격을 주다
    abstract fun crashWithDamage()

    // 비행을 마치다
    fun landingForEnd() {
        println("step5: ${this}가 비행을 마치다.")
        println("-".repeat(80) + "\n")
        this.status = Status.END
    }
}