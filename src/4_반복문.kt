fun main() {
    labelTest()
}

fun labelTest() {
    outer@for (i in 0..10) { // 마지막 포함
        inner@for (j in 0..10) {
            if (i == 0 && j == 3) {
                break@outer
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
}

fun testRepeat() {
    var test : String = "*"

    println(test.repeat(5)) // *****
    println(test.repeat(0)) // 빈 문자열
    println(test.repeat(-1)) // 음수면 Error
}