# 사다리 게임

| 2단계 - 사다리(생성), 3단계 - 사다리(게임 실행), 4단계 - 사다리(리팩토링)

## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)


## 📍**1단계 - 자바8 스트림, 람다, Optional**

#### 람다(lambda)

- 람다 실습 1 - 익명 클래스를 람다로 전환
- 람다 실습 2 - 람다를 활용해 중복 제거

#### 스트림(stream)
| map, filter, reduce

- map, reduce, filter 실습 1
- map, reduce, filter 실습 2

#### Optional

- 요구사항 1 - Optional을 활용해 조건에 따른 반환
- 요구사항 2 - Optional에서 값을 반환
- 요구사항 3 - Optional에서 exception 처리

## 📍**2단계 - 사다리(생성)**

![](https://i.ibb.co/bvyW6cQ/image.png)

**기능 요구사항**
- 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
- 사람 이름은 쉼표(,)를 기준으로 구분한다.
- 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
- 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
  - |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

**기능 구현사항**
- Line 객체 생성 각 포인트마다 `이동 가능여부(Boolean)`를 가진 `List<Boolean> points` 객체를 가진다
- Line 일급 컬렉션 생성
- MoveStrategy 인터페이스 생성 `boolean` 값을 리턴하는 `isMovable` 메소드 생성
- LadderMoveStrategy 객체 생성 MoveStrategy를 상속하여 `isMovable` 메소드구현 -> `랜덤 boolean 값을 생성`하여 리턴
- Ladder 객체에서 `인원수`, `높이` 상태값을 받아 `MoveStrategy` 구현한 메소드를 실행하여 `Line` 을 생성한다
- Ladder 객체에서 Line 생성시 `이전 생성값(boolean)`을 비교하여 중복 생성되지 않도록 한다
- User 객체에서 입력값(이름)의 길이가 1 ~ 5자 에 포함되지 않을 경우 입력을 다시 받도록 한다
- Ladder 객체에서 입력값(높이)가 최소 1이상 이여야 하며 1이상이 아닐 경우 입력을 다시 받도록 한다
- ResultView 객체에서 입력값(이름)의 길이가 5자 미만이면 String.format을 이용하여 자리 수를 맞춰 표시하도록 한다
- Ladder 테스트 케이스 추가
  - LadderStub 클래스 추가 (Ladder 상속) `moveRule` 메소드 구현(() -> true)
  - 이동가능 여부를 참으로 할 경우 결과값 확인(첫번째 무조건 true, 마지막 무조건 false)
- Line 테스트 케이스 추가
  - 오른쪽으로 이동 가능한지 확인
- 도메인 객체 throwException 테스트 케이스 추가

<br>
