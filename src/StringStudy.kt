import java.util.Date

fun main() {
    stringManage()
}

fun testElvisOperators() {
    val name1 = readLine()!! // !!는 절대 null이 아닐 경우 사용됨 -> null일 경우 NPE 발생됨

    val nullableName = readLine()

    // 대처방안.
    // 1. 엘비스 연산자(?:) null일 때 기본값 주기
    nullableName?: "defaultName"

    val length = nullableName?.length?: 0 // nullableName null 일 경우, length도 null이므로 0을 반환.

    // null이면 함수를 종료해버리기
    val name2 = readLine() ?: return

    // null이면 예외 던지기
    val name3 = readLine() ?: throw IllegalArgumentException("이름을 입력해주세요")

    println("Hello, $name1!, Today is ${Date()}")
}

fun testTrimIndent() {
    val message = """
        This is triple quote : '${"\"\"\""}'
    """.trimIndent()

    println(message)
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