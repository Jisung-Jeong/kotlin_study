import java.util.Date

fun main() {
//    stringManage()
    testTrimIndent()
}

fun testElvisOperators() {
    /** !!
     *
     * Not Null 연산자
     *
     * 절대 null이 아닐 경우 사용됨 -> null일 경우 NPE 발생됨
     */
    val name1 = readLine()!!

    val nullableName = readLine()

    /** 1. 엘비스 연산자(?:)
     *
     * 좌측 항이 null일 때 기본값을 설정한다.
     *
     * ?. 세이프 콜.
     *
     * 엘비스 연산자와 짝꿍처럼 쓰인다.
     *
     * nullable?. 과 같이 쓸 경우, 좌측이 null이 아닐 경우만 안전하게 length를 가져오도록 한다.
     *
     * nullable이 null일 경우 그대로 null을 리턴한다. (NPE 방지)
     */
    nullableName ?: "defaultName"

    // nullableName 세이프 콜. nullableName이 null이 아닐 경우만 length 호출
    // 엘비스 연산자. length가 null이면 0 리턴
    val length = nullableName?.length?: 0


    // null이면 함수를 종료해버리기
    val name2 = readLine() ?: return

    // null이면 예외 던지기
    val name3 = readLine() ?: throw IllegalArgumentException("이름을 입력해주세요")

    println("Hello, $name1!, Today is ${Date()}")
}

fun testTrimIndent() {
    val message = """
        This is triple quote : '${"\"\"\""}'
    """
    // trimIndent란?

    println(message) // "        This is triple quote : '"""'"
    println(message.trimIndent()) // "This is triple quote : '"""'"
}

fun testLastIndex() {
    val hello = "Hello!"

    val length = hello.length // 6
    val lastIndex = hello.lastIndex // 5
}

fun stringManage() {
    val hello = "Hello!"

    println("hello.isEmpty() : ${hello.isEmpty()}") // false
    println("hello.isNotEmpty() : ${hello.isNotEmpty()}") // true

    println("hello.substring(0, hello.length) : ${hello.substring(0, hello.length)}") // Hello! 인덱스 0 부터 인덱스(length-1)까지 출력
    println("'Hello'.substring(1, 3) : ${"Hello".substring(1, 3)}")

    // drop and take
    println("'Hello'.take(3) : ${"Hello".take(3)}") // 앞에서부터 세 개 가져옴
    println("'Hello'.drop(3) : ${"Hello".drop(3)}") // 앞 세 개를 버림
    println("'Hello'.takeLast(3) : ${"Hello".takeLast(3)}") // 뒤에서 세 개를 가져옴
    println("hello.dropLast(hello.length - 1) : ${ hello.dropLast(hello.length - 1) }") // 뒤에서부터 length-1개를 버린다.

}