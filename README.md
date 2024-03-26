# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)


## Todo
- 스트림과 람다로 가능한 로직은 최대한 사용해보기
- InputView
    - [ ] 문자열 입력받아 ,로 나누어 Players 반환 (IllegalArgumentException 시 재시도)
    - [ ] 최대 사다리 높이 입력받아 반환 (숫자 아닌 경우 예외처리 후 재시도)
- Player
    - [X] 매개변수로 오는 문자열(이름)이 5자 초과 시 IllegalArgumentException을 던지는 플레이어 값 객체
- Players
    - [ ] List\<Player>만을 인스턴스 변수로 가지는 일급 컬렉션 Players 구현
    - [ ] List\<Player>의 size() 위임 메서드 구현
    - [ ] 공백을 두고 모든 Player를 출력하는 toString() 재정의
- Line
    - [ ] List\<Boolean>만을 필드로 가지는 Line 객체 구현
    - [ ] 생성자의 매개변수로 참가자 수와 Line 생성 전략을 받아 List\<Boolean>에 바인딩
- PointsMakeStrategy
  - [ ] 메개변수로 Line 개수를 받아, 사다리 라인의 List\<Boolean>을 반환하는 인터페이스
  - [ ] 구현체로 RandomPointsMakeStrategy 구현
- OutputView
    - [ ] Players를 매개변수로 받아 한 줄로 출력
    - [ ] List\<Line>을 순회하며 각각의 Line에서 |를 먼저 출력하고 List\<Boolean>이 true면 '-----|', false면 '     |'를 출력