interface Accelerator {
    val MORE_POWER_WEIGHT       // = 3 : error : interface
        get() = Math.random() * 10 + 1.0      // 불리는 순간에 계산되는 식
    fun acceleratorSpeed()
}

class Chuck(_name: String): Flock(), Accelerator {
    init {
        super.name = _name
        power = 9.0
        status = Status.NONE
    }

    override val color: Color = Color.YELLOW
    override val weight: Double = 1.2
    override val type: String = "Chuck"

    // 척새 고유 기능 from Accelerator
    override fun acceleratorSpeed() {
        this.power += MORE_POWER_WEIGHT * power
        println("\t>> ${this}가 비행 가속도를 받아서 파워가 ${String.format("%.2f", power)}로 증가한다.")
    }

    // 발사되어 날아가다
    override fun flyAfterShoot() {
        println("step3: ${this}가 공중으로 날아가다.")
        acceleratorSpeed()      // 고유기능 호출
        this.status = Status.FLYING
    }

    // 장애물에 부딪혀 충격을 주다
    override fun crashWithDamage() {
        println("step4: ${this}")
        println("\t>> 입힌 총 대미지: ${String.format("%.2f", getDamage())} 점 ")
        this.status = Status.CRASHED
    }
}



// interface : 모든 함수가 abstract
interface Spliter {
    fun splitBirds()
    fun splitDamage(vararg birds: String)
}

class Blues(_name: String): Flock(), Spliter {          // inheritance : Flock(), Spliter
    init {
        super.name = _name
        super.power = 8.0
//        color = Color.BLUE      // err val
//        weight = 1.3            // err val
    }

    override val color: Color = Color.BLUE
    override val weight: Double = 1.3
    override val type: String = "Blues"


    // 블루새의 고유한 기능들
    override fun splitBirds() {
        println("\t>> 짐, 제이크, 제이 세마리 새들로 분리되어 날아간다. ")
    }

    override fun splitDamage(vararg birds: String) {
        for (bird in birds) {
            println("\t>> '${this}가 장애물에 부딪혀 충격을 주다.")
            println("\t>> 입힌 총 대미지: ${String.format("%.2f", getDamage())} 점 ")
        }
    }

    // 발사되어 날아가다
    override fun flyAfterShoot() {
        println("step3: ${this}가 공중으로 날아가다.")
        splitBirds()
        this.status = Status.FLYING
    }

    // 장애물에 부딪혀 충격을 주다
    override fun crashWithDamage() {
        println("step4: ${this}")
        splitDamage("Jim Blue새", "Jake Blue새", "Jay Blue새")
        this.status = Status.CRASHED
    }
}

class Red(_name: String): Flock() {     // : Any
    init {
        super.name = _name
    }

    // 발사되어 날아가다
    override fun flyAfterShoot() {
        println("step3: ${this}가 공중으로 날아가다.")
        this.status = Status.FLYING
    }

    // 장애물에 부딪혀 충격을 주다
    override fun crashWithDamage() {
        println("step4: ${this}가 장애물에 부딪혀 충격을 주다.")
        println("\t>> 입힌 총 대미지: ${String.format("%.2f", getDamage())} 점 ")
        this.status = Status.CRASHED
    }
}



fun angryTest() {
    println("> angryTest -----------------------------------------------")

//    val bird1 = Red("길동")
//    println("bird1 = ${bird1}")     // toString()
//    bird1.readyForShoot()
//    bird1.adjustAngleLength()
//    bird1.flyAfterShoot()
//    bird1.crashWithDamage()
//    bird1.landingForEnd()

//    val bird1 = Flock()     // error : abstract class

    println()
//    listOf(Red("길도"), Red("영희"), Red("꺽정")).forEach {
//        it.readyForShoot()
//        it.adjustAngleLength()
//        it.flyAfterShoot()
//        it.crashWithDamage()
//        it.landingForEnd()
//    }

//    listOf(Blues("철수"), Blues("안나"), Blues("대산"))
//        .forEach {
//            with(it) {
//                readyForShoot()
//                adjustAngleLength()
//                flyAfterShoot()
//                crashWithDamage()
//                landingForEnd()
//            }
//        }

//    listOf(Chuck("John"), Chuck("Elle"), Chuck("Mike"))
//        .forEach {
//            with(it) {
//                readyForShoot()
//                adjustAngleLength()
//                flyAfterShoot()
//                crashWithDamage()
//                landingForEnd()
//            }
//        }

    // Polymorphism
    listOf(Red("길동"), Blues("안나"), Chuck("Mike"))
        .forEach {
            with(it) {
                readyForShoot()         // Flock
                adjustAngleLength()     // Flock
                flyAfterShoot()         // override fun
                crashWithDamage()       // override fun
                landingForEnd()         // Flock
            }
        }


    println("> angryTest -----------------------------------------------")
    println()
}