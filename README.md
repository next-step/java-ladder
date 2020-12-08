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
- 게임 참여자를 입력안할 경우 -> `IllegalArgumentException` 이 발생한다
- 게임 참여자를 최대 5자 기준으로 입력가능하며 이탈시 -> `IllegalArgumentException` 이 발생한다
- 게임 보상을 입력할 시에 빈 값을 입력할 경우 -> `IllegalArgumentException` 이 발생한다
- 사람수, 사다리 높이 값을 입력받아 `Lines` 객체를 생성한다 사다리의 높이가 1보다 작은경우 -> `IllegalArgumentException` 이 발생한다
- `Line` 생성시 `Point`의 첫번째 ~ 마지막 객체를 생성한다 첫번째의 왼쪽 상태값과, 마지막의 오른쪽 상태값은 `false` 고정이다
- `Pointer`의 이동여부를 판별하는 것은 전략패턴을 구현한 `NextBoolean` 에서 `boolean` 값을 주입 받아 판별한다
- `Pointer` 의 상태값 `left`,`right`의 `boolean` 값으로 현재위치에서 이동할 위치로 `+1` 하거나 `-1` 하여 이동된 위치를 계산한다
- 게임 결과값을 검색할때 검색할 단어에 Null 또는 공백이 오는 경우 -> `NullPointerException` 이 발생한다
- 게임 결과값은 `all` 또는 `유저명` 으로 조회가능하다

<br>
