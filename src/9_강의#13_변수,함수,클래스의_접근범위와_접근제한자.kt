class StudyScopeAndAccessModifier {

    init {
        /** Scope
         *
         * 변수, 함수, 클래스와 같은 멤버들을
         *
         * 서로 공유하여 사용할 수 있는 '범위'를 지정해 둔 단위
         *
         * 지역변수 전역변수 생각하면 된다!
         *
         */

        // 한 스코프 안에선 특정한 import 선언 없이도 자신들끼리 요소의 공유가 가능하다.

        // 패키지 명을 명시하지 않으면, 'Default package 스코프' 에 소속된다.

        /**
         * 스코프 외부에서 내부로 접근하려면 "참조 연산자"를 사용하여야 한다.(접근 제한자)
         */

    }

    fun packageScope() {
        /** 패키지 스코프
         *
         * 1. public(Default): 어떤 패키지에서도 접근 가능
         *
         * 2. internal : 같은 모듈 내에서만 접근 가능
         *
         * 3. private : 같은 파일 내에서만 접근 가능
         *
         * ~protected~는 패키지 스코프에선 사용하지 않는다.
         */
    }

    fun classScope() {
        /** 클래스 스코프
         *
         * 1. public(Default) : 클래스 외부에서도 늘 접근 가능
         *
         * 2. private : 클래스 내부에서만 접근 가능
         *
         * 3. protected : 클래스 자신, 그리고 상속받은 클래스에서만 접근 가능
         *
         * ~internal~은 클래스 스코프에선 사용하지 않는다.
         */
    }
}

val a  = "패키지 스코프"

class B {
    fun print() {
        println(a)
    }
}

fun main() {
    println(a)
    println(B().print())
}