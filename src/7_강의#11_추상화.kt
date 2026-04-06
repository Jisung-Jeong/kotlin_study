abstract class Animal2(val name: String, val age: Int, val type: String) {
    // 추상 메서드가 있는 클래스는, 추상 클래스가 된다.
    // 따라서 클래스와 메서드 둘 다 abstract 키워드를 써준다.
    abstract fun eat()

    // open 안썼으므로 오버라이드 불가능
    fun sniff() {
        println("킁킁")
    }
}

class Dog2(name: String, age: Int, type: String) : Animal1(name, age, "개") {
    // 추상 클래스를 상속받아, 추상 메서드를 구현 시, override 키워드를 써준다.
    override fun eat() {
        println("개가 밥을 먹습니다.")
    }
//    오버라이딩 안 되는데 재정의 시, 컴파일 에러 발생
//    fun sniff() {
//        println("킁킁")
//    }
}

// 인터페이스는 모든 함수가 추상화된, 순수 추상화 객체를 뜻한다.
// 따라서 구현부가 존재하면 open 클래스(오버라이딩 허용)
// 구현부가 없으면 abstract 클래스로 간주합니다.(구현 필수)

interface Runner {

    // abstract 함수로 간주. 따라서 구현 필수
    fun run()
}

interface Eater {
    fun eat() {
        println("음식을 먹습니다.") // open 함수로 간주
    }

    fun howToEat() // abstract 함수로 간주
}


class Puppy : Runner, Eater {
    override fun run() {
        println("강이지가 뜁니다.") // 구현
    }

    override fun eat() {
        println("강아지가 먹습니다.") // 오버라이딩
    }

    override fun howToEat() {
        println("러너가 먹는 방법")
    }
}