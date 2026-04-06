import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

fun main() {
    create100ThousandCoroutine()
    create100ThousandThread()
//    testSortedSetOf()
}


/**
 * 일반 함수 vs suspend function
 *
 * 일반 함수는 어디서나 호출 가능하며, delay나 suspend 같은 코루틴 기능을 쓰지 못한다.
 *
 *   :: 아래의 경우 runBlocking과 launch 기능으로 코루틴 세상을 열었기에 가능
 *
 * suspend 함수는 코루틴 내부에서만, 혹은 같은 suspend 함수 내부에서만 호출 가능
 *
 */

fun create100ThousandCoroutine() {
    val count = 100_000

    val result = runCatching { // try-catch문을 가독성 좋게 사용
        measureTimeMillis { // 얼마만큼의 ms 가 걸리는지 측정하는 메서드
            runBlocking { // 내부의 모든 코루틴이 끝날 때까지 현재 스레드를 멈추고(Blocking) 기다립니다.
                repeat(count) { // 지정된 횟수(count)만큼 반복한다.
                    launch { // 새로운 코루틴을 생성한다.
                        // : 호출 즉시 반환됩니다(비동기). 즉, 10만 번을 호출해도 10만 번 기다리는 게 아니라 순식간에 10만 개의 작업을 던져놓고 다음 코드로 넘어갑니다.
                        delay(1000L) // 코루틴이 1초 쉬는 동안, 스레드에게 다른 코루틴 처리하러 가라고 명령한다.
                    }
                }
            }
        }
    }

    /**
     * runBlocking vs coroutineScope
     * runBlocking: 스레드 내 모든 코루틴이 끝날 때까지 스레드 멈춤(약 1mb 스택메모리 유휴 자원을 낭비하는 것)
     * coroutineScope: 기다리는 동안 스레드를 양보하고 쉰다. 다른 코루틴이 해당 스레드를 사용할 수 있도록 함
     */

    result
        .onSuccess { value -> println("코루틴 10만 개 완료: $value ms") } // 1362ms
        .onFailure { exception -> println("에러: ${exception.message}") }
        .also { println("무조건 실행되는 코드. finally같은 느낌") }
}

fun create100ThousandThread() {
    val count = 100_000

    try {
        val threadTimes = measureTimeMillis {
            val threads = List(count) { // 크기가 count인 List를 만들고, 중괄호 내의 내용으로 리스트를 채운다.
                thread { // 스레드 생성
//                    Thread.startVirtualThread { // 가상 스레드 생성 - java 판 코루틴이라고 보면 됨
                        Thread.sleep(1000L) // 1초 대기 (차단)
//                    }
                }
            }
            threads.forEach { it.join() } // join()은 해당 스레드가 종료될 때 까지 메인 스레드를 멈추게 한다.
        }
        println("스레드 10만 개 완료: $threadTimes ms") // 57441ms
    } catch (e: OutOfMemoryError) {
        println("스레드는 메모리 부족으로 실패했습니다!")
    }
}

fun testSortedSetOf() {
    // 작은 수부터 정렬한다.(+ set이므로 중복제거도 됨)
    // NaN은 double에서 가장 큰 값, 무한대보다도 큰 값으로 취급된다.
    val set = sortedSetOf(Double.NaN, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0.0)
    println(set) // [-infinity, 0.0, infinity, NaN]
}

// syncronized 함수: 한 번에 한 개의 스레드만 해당 함수를 실행할 수 있도록 한다. (전통적 방식)
// 이 안에서 가상 스레드 I/O 작업 시, 실제 OS 스레드도 같이 묶여버리는 Pinning 현상이 발생한다.
// 코루틴 안에서 syncronized 사용 시 컴파일 에러 발생. 안에서 delay와 같은 suspend 함수 호출 불가함.

// 코루틴 함수에서, 한 번에 한 개의 코루틴만 함수를 실행하게 하려면?
// Mutex.withLock {} 사용(suspend 함수 내에서만 가능)
val mutex = Mutex()
var loadCount = 0

suspend fun updateProgress() {
    mutex.withLock {
        // 안전하게 데이터 수정
        loadCount++
        // 여기서 다른 suspend 함수 호출도 가능!
    }
}

// 위와 같은 방식을 MutableStateFlow로도 사용 가능
class mutatableTest {
    private val _loadCount = MutableStateFlow(0)
    val loadCountMutable = _loadCount.asStateFlow()

    fun updateTest() {
        _loadCount.update { it + 1}
    }
    // update가 안전한 이유: 작동원리
    // 1. 현재 값을 읽음
    // 2. 함수 내부 연산 수행
    // 3. 값을 바꾸기 직전 '1번에서 읽었던 값'과 '현재 값' 비교,
    // 같으면 update 수행, 다르면 1번부터 다시 수행
}





