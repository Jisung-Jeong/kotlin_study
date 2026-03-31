class StudyProjectStructure {

    init {

        // 코틀린 프로젝트 패키지명 컨벤션
        // 1. 도메인을 거꾸로 배열 ex) youtube.com -> com.youtube
        // 2. 패키지명을 끝에 명시 ex) com.youtube.package
        // 3. 기능 명을 끝에 명시해 세분화
            // ex) com.youtube.package.chat
            // ex) com.youtube.package.profile
            // ex) com.youtube.package.base ....
    }

    fun `자바_차이점`() {
        // 1. 코틀린은 패키지 경로를 명시할 필요가 없다.
        // 2. 상단에 패키지명만 명시하면 경로는 컴파일러가 알아서 해준다.

        // 3. 코틀린은 파일명과 클래스명이 달라도 된다!!
        // 4. 하나의 파일 안에 클래스를 여러 개 넣어도 된다!!
        // -> 파일이나 폴더로 요소를 구분하지 않고, package 키워드로 구분하기 때문. (알면 알수록 편리하고 간결하다...)
    }

    fun how_to_import() {
        // 같은 패키지 내에서는 import 없이 사용 가능(동일 스코프)
        // 다른 패키지 쓸 경우,
        // "import 패키지 명" 과 같이 선언만 해주면 끝난다.
        // 이름이 중복되는 요소가 있다면, "패키지명 + 요소" 풀 네임을 적어주어야 한다.

        // 패키지 명을 명시하지 않으면, 'Default package' 에 소속된다.
        // Default package 에 소속된 요소들끼리 스코프를 공유한다.
    }
}