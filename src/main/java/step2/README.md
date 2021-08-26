# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## 1단계 - 자바8 스트림, 람다, Optional
### 기능 요구사항
* [X] lambda - 익명 클래스를 람다로 전환
* [X] lambda - 람다를 활용해 중복 제거
* [X] stream - map, reduce, filter 실습 1
* [X] stream - map, reduce, filter 실습 2
* [X] Optional - Optional을 활용해 조건에 따른 반환
* [X] Optional - Optional에서 값을 반환
* [X] Optional - Optional에서 exception 처리

## 2단계 - 사다리(생성)
### 기능 요구사항
* 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
* 사람 이름은 쉼표(,)를 기준으로 구분한다.
* 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
* 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
  * |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

### 프로그래밍 요구사항
* 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
* 규칙 6: 모든 엔티티를 작게 유지한다.

### TODO
* [X] User 도메인 클래스 생성, 이름에 대한 유효성 검사를 적용한다.
  * [X] 이름은 빈값이거나 NULL 이면 안된다.
  * [X] 이름의 길이제한은 1~5글자이다.
* [X] Users 도메인 클래스 생성. 사용자 입력값을 구분자로 나누어 List<User>로 저장한다.
* [X] Point 도메인 클래스 생성. 선 유무 인스턴스 변수를 가진다.
* [X] LadderGenerationStrategy, LadderRandomGenerationStrategy 전략패턴 추가
* [X] Line 도메인 클래스 생성. List<Point>를 가진다. 이전 Line의 Point를 가져와 자신의 Point에 반영한다.
* [ ] Controller, View를 생성한다.
