fun main() {
    labelTest()
}

// 레이블(label@)을 이용하여 반복문에 이름을 붙여줄 수 있다.
// 사용 시에는 @label과 같이 사용한다.
fun labelTest() {
    out@for (i in 0..10) { // 마지막 포함
        inner@for (j in 0..10) {
            if (i == 0 && j == 3) {
                break@out
            }
            println("i=$i, j=$j")
        }
    }

    // until문
    for (i in 0 until 11) { // 마지막 제외
        // 10번 실행
    }

    // repeat문
    repeat(10) {
        // 10번 실행
        println("$it 번")
    }

    // downTo문 (역순)
    for (i in 10 downTo 0) {
        // 10번 실행
    }

    // step 간격 조정
    for (i in 1..10 step 2) {
        // 5번 실행
        // 1, 3, 5, 7, 9
    }

    // 문자열로 비교
    for (i in 'a'..'e') {
        println(i)
    }
}

fun testRepeat() {
    var test : String = "*"

    println(test.repeat(5)) // *****
    println(test.repeat(0)) // 빈 문자열
    println(test.repeat(-1)) // 음수면 Error
}