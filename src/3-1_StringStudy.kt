fun main() {
    testLines()
//    testTrim()
}

fun testLines() {
    var test : String

    test = "Hello World\nHelloooooo World\nHeeeellllloooo Wooorld"

    test
        .lines() // Stream<String> 을 반환한다, 개행문자 기준으로 자른다.
        .forEach(System.out::println)
}

fun testTrim() {
    /** JAVA 11
     * trim()은 ASCII 공백만 제거하지만,
     * strip()은 유니코드 공백도 제거한다.

     * strip() : 앞뒤 공백 제거
     * stripLeading() : 왼쪽 공백 제거
     * stripTrailing() : 오른쪽 공백 제거

     * var test : String = "   Hello World "

     * println("test.strip(): " + test.strip() )
     * println("test.stripLeading(): " + test.stripLeading() )
     * println("test.strip(): " + test.stripTrailing() )
     */

    /** Kotlin
     *
     * strip보다 더 강력한 기능의 동일한 이름의 함수들을 제공한다. (유니코드 포함)
     *
     * trim(): 양쪽 공백 제거
     *
     * trimStart(): 앞쪽 공백 제거
     *
     * trimEnd(): 뒤쪽 공백 제거
     */

    val test = "   Hello World "

    println(test.trim()) // "Hello World"
    println(test.trimStart()) // "Hello World "
    println(test.trimEnd()) // "   Hello World"
}


// JAVA 21 : var과 val 지원!
//fun testStringTemplates() {
//    val name : String = "Hello World" // val: 불변 변수, var: 가변 변수
//    println(STR."Hello $name!")
//}