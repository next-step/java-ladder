# 사다리타기 - FP, OOP

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

### Optional
- [X] Optional을 활용해 ageIsInRange2() 메소드에 구현
- [X] Optional을 사용하도록 리팩토링한 후 UsersTest의 단위 테스트가 통과
- [X] nextstep.optional.ExpressionTest의 테스트가 통과하도록 Expression의 of 메소드를 구현
