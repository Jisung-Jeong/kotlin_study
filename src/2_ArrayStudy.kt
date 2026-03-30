fun main() {
//    typedArray()
//    arrayManage()
    compareOperator()
}

fun createArray() {
    val a = emptyArray<String>()
    val b = arrayOf("Hello", "World") // 타입추론: Array<String>()
    val c = arrayOf(1, 2, 3) // 타입추론: Array<Int>()
}

fun lambdaAndArray() {
    val size = readLine()!!.toInt() // 반드시 입력은 int 형으로
    // !!: Not-Null 연산자
    // null.toInt() 시 에러 남.
    // 그러나 확실히 값이 존재할 때 !!를 써서 에러가 나지 않음을 확신시켜준다.

    val squares = Array(size) { // size 만큼 array에 중괄호 내부 내용을 add한다.
        (it + 1) * (it + 1) // it는 자동 생성되는 변수로, 인덱스를 나타낸다.
    }
}

fun typedArray() {
    var byteArray = ByteArray(5)
    byteArray = byteArrayOf()

    var shortArray = ShortArray(5)
    shortArray = shortArrayOf(1, 2, 3)

    var intArray = IntArray(5)
    intArray = intArrayOf(1, 2, 3)

    var longArray = LongArray(5)
    longArray = longArrayOf(1, 2, 3)

    var floatArray = FloatArray(5)
    floatArray = floatArrayOf(1f, 2f, 3f)

    var doubleArray = DoubleArray(5)
    doubleArray = doubleArrayOf(1.0, 2.0, 3.0)

    var charArray = CharArray(5)
    charArray = charArrayOf('a', 'b', 'c')

    var booleanArray = BooleanArray(5)
    booleanArray = booleanArrayOf(true, false, true)
}

fun arrayManage() {
    // 코틀린의 변수는 참조형 변수이다.
    // squares라는 변수에 배열의 주소를 가져다 붙이는 형식
    val squares = arrayOf(1, 2, 3, 4)
    squares.size // 4
    squares.lastIndex // 3
    squares[2] // 3

    // 얕은 복사
    val squaresCopy = squares // 두 변수가 같은 배열을 바라보게 됨 (squaresCopy === squares)
    squares[0] // 1
    squaresCopy[0] // 1

    // 깊은 복사
    val squaresRealCopy = squares.copyOf() // 별도의 배열이 생성됨 copyOf의 인자는 배열의 크기를 지정.
    // ex) squares.copyOf(2) = [1, 2] 뒤가 잘림
    // ex2) squares.copyOf(5) = [1, 2, 3, 4, 0] 없는 부분은 0으로 대체
    squaresRealCopy[0]++
    println("squaresRealCopy[0] : ${squaresRealCopy[0]}") // 2
    println("squares[0] : ${squares[0]}") // 1
}

fun differentTypeOfArray() {
    val a = arrayOf(1, 2, 3)
    // a = arrayOf("one", "two", "three") // 다른 타입은 넣지 못한다.
    // + 불변 변수로 선언하여, 애초에 변수에 다른 값을 재할당하지 못한다.

    //Any는 데이터 타입의 최상위(어느 데이터든 다 들어갈 수 있음)
    var anyArr : Array<Any> = arrayOf(1, "awd", 3.2, 4)
}

fun testVariance() {
    val strings = arrayOf("a", "b", "c")

    // val objects: Array<Any> = strings // Error!
    // objects에서 array를 읽기 전용으로만 쓴다고 하면, out을 붙이는 조건으로 가능하다.
    val objects: Array<out Any> = strings
    println(objects[0])
    // objects[0] = "2" // Error!
}

fun addInArray() {
    val a: Array<Int> = arrayOf(1, 2, 3)
    println("a + 4 : ${a + 4}") // arrayOf(1, 2, 3, 4)
    println("a + arrayOf(5, 6) : ${a + arrayOf(5, 6)}") // arrayOf(1, 2, 3, 4, 5, 6)
}

fun compareOperator() {
    val a: Array<Int> = arrayOf(1, 2, 3)
    val b: Array<Int> = arrayOf(1, 2, 3)

    // 배열에서의 ==, != 는 주소를 비교한다.
    // 내용을 비교하려면 contentEquals()를 써야 한다.
    println("a == b : ${a == b}") // false
    println("a.contentEquals(b) = ${a.contentEquals(b)}") // true
}