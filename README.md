# 사다리 게임

## Step1 자바8 스트림, 람다, Optional

* [X] Lambda
* [X] Stream
* [X] Optional

## Step2 사다리(생성)

### 기능 요구사항

* 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
* 사람 이름은 쉼표(,)를 기준으로 구분한다.
* 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
* 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
* |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

### 프로그래밍 요구사항

* 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
* 규칙 6: 모든 엔티티를 작게 유지한다.

### 파생 요구사항(설계)

* User
  * [X] 이름 길이는 최대 5자 조건을 검증하는 역할
* Users
  * [X] 최소 인원 검증 역할
  * [X] 게임에 참여하는 유저들을 관리하는 역할
  * [X] 인원 수 getter
* InputParser
  * [X] ,로 인풋을 분리하는 기능 `String -> <List>String`
* HorizontalLine
  * [X] 지정된 길이 만큼, true 가 2개 이상 연속되지 않은 `List<boolean>` 를 변환하는 역할
  * [X] Line 의 `List<Boolean>` 반환 기능
* Ladder
  * [X] 사다리 높이 만큼 `HorizontalLine` 을 생성하는 역할
  * [X] ResultView 용 출력 데이터 생성 하는 역할
  * [X] 각 `HorizontalLine`에 layout을 바꾸도록 요청하는 역할
* ResultView
  * [ ] User 에 대해
  * [ ] `List<List<boolean>>` 을 사다리로 출력하는 역할
* InputView
  * [X] User 정보 입력 받는 기능
  * [X] 사다리 높이 입력 받는 기능
