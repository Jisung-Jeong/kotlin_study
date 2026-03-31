/** 스코프 함수란?
 * 함수형 언어의 특징을 좀 더 편하게 사용하도록 기본 제공되는 함수
 *
 * :: 클래스의 인스턴스를 스코프 함수에 전달하면
 *    인스턴스의 속성이나 메서드를 더 편리하게 사용 가능하다.
 */

/** 스코프 함수의 종류
 * apply
 * run
 * with
 * also
 * let
 */

// 1. apply
// 인스턴스 생성 후, 변수에 담기 전 초기화 과정에서 많이 사용됨
fun main() {
    // apply를 사용하여, a.name과 같은 참조 연산자 없이도 사용 가능
    // 또한 apply는 자기 자신을 반환하므로, 이렇게 생성된 인스턴스를 바로 변수에 담을 수 있음
    var a = Book("Kotlin", 10000).apply {
        name = "[초특가]" + name
        discount()
    }

    // main함수와 외부 스코프에서 인스턴스의 변수, 함수를 조작하므로
    // 코드가 깔끔해진다는 장점이 있다.
}

class Book(var name: String, var price: Int) {
    fun discount() {
        price -= 2000
    }
}

// 2. run
// apply 처럼 스코프 내에서 참조 연산자를 사용하지 않아도 된다. (다만, 메인함수에 변수명이 중복될 경우, 메인함수가 우선된다.)
// 인스턴스를 반환하는 것이 아니라, "마지막 줄" 을 반환한다.
val price = Book("Kotlin", 10000).run {
    discount() // price -= 2000
    price // 8000
}
// 따라서 이미 인스턴스가 만들어진 후에,
// 인스턴스의 변수나 함수를 스코프 내에서 사용해야 할 때 유용하다.


// 3. with
// run 과 동일한 기능을 가지지만, 인스턴스를 참조 연산자 대신 파라미터로 받는다.
val book = Book("Kotlin", 10000)
val priceWith = with(book) {
    discount()
    println(price)
}

// 4. also, let
// also는 apply와 같은 기능, let은 run과 같은 기능을 가진다.
// 다만 인스턴스를 파라미터로 받아 it으로 사용 가능하다.
// -> 같은 이름의 변수가 스코프 바깥에 중복된 경우, 혼란 방지 가능하다.
fun testAlsoAndLet() {
    val price = 1000

    val book = Book("Kotlin", 10000)

    // ====== let =====

    book.run {
        discount()
        println(price) // testAlsoAndLet의 price 변수가 출력된다.
    }

    book.let {
        it.discount()
        println(it.price) // book의 price가 출력된다.
    }

    // ====== also =====

    book.apply {
        discount()
        println(price) // testAlsoAndLet의 price 변수가 출력된다.
    }

    book.also {
        it.discount()
        println(it.price) // book의 price가 출력된다.
    }

}