fun main() {
    val a = Prs("안뇽", 20)
    a.introduce()
}

class Prs(val name: String, val birth: Int) {

    // 보조 생성자 오버로딩
    // 보조 생성자에서 name을 받고, 기본 생성자를 호출해준다.
    // this(args1, args2...)를 호출함으로써 기본 생성자를 호출할 수 있다.
    constructor(name: String) : this(name, 20)

    init {
        println("생성자 1을 실행합니다.")
    }

    init {
        println("생성자 2를 실행합니다.")
    }

    fun introduce() {
        println("Introduce prs")
        println("name: $name, age: $birth")
    }
}


abstract class Guitar(val stringCount: Int, val bodyShape: String, var value: Long) {
    init {
        println("Guitar class")
    }

    abstract fun introduce()
}

class Strat(stringCount: Int, value: Long) : Guitar(stringCount, "Strat", value) {
    override fun introduce() {
        println("Introduce Strat")
    }
}

