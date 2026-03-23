fun main() {
    labelTest()
}

fun labelTest() {
    outer@for (i in 0..10) {
        inner@for (j in 0..10) {
            if (i == 0 && j == 3) {
                break@outer
            }
            println("i=$i, j=$j")
        }
    }
}