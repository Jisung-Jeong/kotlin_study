
open class Animal1(val name: String, val age: Int, val type: String) {
    fun introduce() {
        println("저는 $name 이고 $age 살 $type 입니다.")
    }

    open fun eat() { // 오버라이딩 허용
        println("음식을 먹습니다.")
    }
}

// 상속 시 주의점
// 1. 서브 클래스는 수퍼 클래스와 필드명이 달라야 한다.
// 2. 서브 클래스 생성 시 반드시 수퍼 클래스의 생성자를 호출하여야 한다.

// var이나 val을 붙이면 클래스의 자체 필드가 되므로, 필드 간 중복 방지를 위해 var, val은 붙이지 않는다.
// 곧, var이나 val을 붙이면 클래스의 필드로 저장되나, 붙이지 않으면 단순 생성자에 잠깐 머물다 가는 파라미터 바구니가 된다.
class Dog(name: String, age: Int, val newVar: String) : Animal1(name, age, "개") {
    fun bark() {
        println("멍멍")
    }

    override fun eat() {
        println("개가 밥을 먹습니다.")
    }
}

class Cat(name: String, age: Int) : Animal1(name, age, "고양이") {
    fun meow() {
        println("야옹")
    }
}
