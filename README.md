# 사다리 게임
## Step2 > 사다리(생성)
### 피드백 반영
- 부 생성자가 주 생성자를 호출하도록 구현한다.
- 사다리 생성 역할을 하는 `LaddersFactory`를 생성한다.
  - `LaddersFactory` (추상), `RandomLaddersFactory` (구현체)

추가 리팩터링 >
- `LadderFactory`, `LadderLineGenerator`는 `LadderGameInterface`에서 결정하도록 한다.

### 기능 요구사항
- 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
- 사람 이름은 쉼표(,)를 기준으로 구분한다.
- 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다. 
- 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다. 
- 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

### 프로그래밍 요구사항
- 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
- 규칙 6: 모든 엔티티를 작게 유지한다.

### 세부 구현 사항
1. `LadderGameInterface` : 클라이언트로부터 호출되며, `xxxView` 클래스 및 `LadderGame` 클래스와 메세지를 주고받는다.
2. `LadderGame` : 사다리 게임 객체. `LadderGameInterface` 로부터 요청받는다.
   - `ladders` : `Ladders` 객체로, 한 게임에 대한 전체 사다리.
   - `maxHeight` : 사다리 최대 높이.
   - `participants` : 컬렉션 타입의 참가자들 이름.
3. `Ladders` : 사다리 객체의 일급 컬렉션 클래스로, size는 **참석자/사다리 수 - 1 개**만큼 생성된다.
   - `ladders` : `Ladder` 타입의 컬렉션
4.`Ladder` : 사다리 객체. 
   - `position` : `Integer`. 사다리의 순서를 의미하며, `0`부터 `참석자/사다리 수 - 1` 까지의 값이다.
   - `lines` : `Lines` 
5. `Lines` : 사다리의 라인들 생성 여부 컬렉션을 감싼 일급 컬렉션    ex) 5층의 사다리 중 라인 3개 생성 : [true, false, true, false, true]
6. `LadderLinesGenerator`, `RandomLadderLinesGenerator`
   - 라인들은 0부터 사다리 최대 높이(`maxHeight`)-1 사이에서 세팅되거나 세팅되지 않는다.
   - 최초 `Ladder`를 제외하고 이전 position에서 사다리가 놓인 위치는 제외하고 사다리를 랜덤으로 놓는다.
   - 마지막 position의 `Ladder`는 라인이 세팅되지 않는다. (모두 False 세팅)
7. `OutputView`
   - 사용자 이름과 사다리를 출력한다.
   - 사다리는 사다리 최대 높이 만큼, 사다리 갯수만큼 순회하며 출력한다.  (5개의 하이픈 '-' 혹은 공백으로 출력한다.)
8. `InputView`
   - 참여자 이름을 입력받는다.
     - 5자 초과한 이름이 있으면 에러를 발생시킨다.
   - 사다리 최대 높이를 입력받는다.


## Step1 > Stream, Lambda, Optional
### 세부 구현 사항
- [x] 익명 클래스를 람다로 전환한다.
- [x] 공통되는 부분을 함수형 인터페이스로 추출하여 익명 클래스로 구현한다.
- 학습한 map, reduce, filter를 활용해 아래 문제를 해결한다.
  - [x] `nextstep.fp.StreamStudyTest` 클래스의 `sumOverThreeAndDouble()` 테스트를 통과한다.
  - [x] `nextstep.fp.StreamStudy` 클래스의 `printLongestWordTop100()` 메서드를 구현한다.
- 자바 8의 stream과 Optional을 활용해 아래 문제를 해결한다. 
  - [x] `nextstep.optional.User`의 `ageIsInRange2()` 메서드 테스트를 통과한다.
  - [x] `nextstep.optional.Users`의 `getUser()` 메서드 테스트를 통과한다.
  - [x] `nextstep.optional.Expression`의 `of()` 메서드 테스트를 통과한다.

> 알게된 내용
> - `Stream`의 `findAny()` 메서드가 `Optional` 객체를 반환한다.
> - `Optional.ofNullable()`로 감싸고 나서 `filter()` 메서드로 조건절 체크를 할 수 있다.
> - `reduce()` : 스트림의 원소들에 대해 reduction을 수행한다.

## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)
