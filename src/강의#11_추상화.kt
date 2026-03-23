abstract class Animal(val name: String, val age: Int, val type: String) {
    abstract fun eat()
    fun sniff() {
        println("킁킁")
    }
}

class Dog(name: String, age: Int, type: String) : Animal(name, age, "개") {
    override fun eat() {
        println("개가 밥을 먹습니다.")
    }
}

// 인터페이스는 모든 함수가 추상화된, 순수 추상화 객체를 뜻한다.
// 따라서 구현부가 존재하면 open 클래스(오버라이딩 허용)
// 구현부가 없으면 abstract 클래스로 간주합니다.(구현 필수)

interface Runner {
    fun run() // abstract 함수로 간주
}

interface Eater {
    fun eat() {
        println("음식을 먹습니다.") // open 함수로 간주
    }
}

class Puppy : Runner, Eater {
    override fun run() {
        println("강이지가 뜁니다.") // 구현
    }

    override fun eat() {
        println("강아지가 먹습니다.") // 오버라이딩
    }
}