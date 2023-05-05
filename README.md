# 사다리타기 - FP, OOP

---
## Step2 - 사다리(생성)
### 기능 요구사항
- 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
- 사람 이름은 쉼표(,)를 기준으로 구분한다.
- 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
- 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
    - |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

### 구현 목록

---

## Step1 - 스트림, 람다, Optional
### Step1 1차 피드백 수정
- [X] 람다 실습 2 - 람다를 활용해 중복 제거 의 요구조건을 충족
- [X] DEFAULT_SUM 은 오히려 가독성을 해치는 일
- [X] 함수명에서 even임을 명시했기 때문에 n % 2 == 0 이 더 직관적
- [X] OVER_CONDITION도 마찬가지
- [X] StreamStudy.java 중복이 존재

---

### 람다 실습 1 - 익명 클래스를 람다로 전환
- [X] MoveStrategy에 대한 익명 클래스로 구현하고 있는데 람다를 적용해 구현

### 람다 실습 2 - 람다를 활용해 중복 제거
- [X] 람다를 활용해 중복을 제거

### 다양한 stream method 실습
- [X] List에 담긴 모든 숫자 중 3보다 큰 숫자를 2배 한 후 모든 값의 합을 구한다.
- [X] nextstep.fp.StreamStudy 클래스의 printLongestWordTop100() 메서드를 구현
- [X] nextstep.fp.StreamStudy 클래스의 printLongestWordTop100() 메서드를 구현

### Optional
- [X] Optional을 활용해 ageIsInRange2() 메소드에 구현
- [X] Optional을 사용하도록 리팩토링한 후 UsersTest의 단위 테스트가 통과
- [X] nextstep.optional.ExpressionTest의 테스트가 통과하도록 Expression의 of 메소드를 구현
