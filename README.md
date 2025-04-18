# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

---
## STEP1. 스트림, 람다, Optional
### 람다
- [x] 람다 실습 1
  > - 익명 클래스를 람다로 전환 : nextstep.fp.CarTest 이동, 정지 method
- [x] 람다 실습 2 
  > - 람다를 활용해 중복 제거 : nextstep.fp.Lambda의 sumAll, sumAllEven, sumAllOverThree method
- [x] 힌트
  > - 변경되는 부분과 변경되지 않는 부분의 코드를 분리한다.
  > - 변경되는 부분을 인터페이스로 추출한다.
  > - 인터페이스에 대한 구현체를 익명 클래스(anonymous class)로 구현해 메소드의 인자로 전달한다.
  >   - 구글에서 자바의 익명 클래스로 검색해 익명 클래스가 무엇인지 학습한다.
  > - 인터페이스는 다음과 같은 형태로 추출할 수 있다.
  >     ```java
  >     public interface Conditional {
  >         boolean test(Integer number);
  >     }
  >     ```
  > - Conditional을 활용해 공통 메소드의 구조는 다음과 같다.
  >     ```java
  >     public int sumAll(List<Integer> numbers,
  >         Conditional c) {
  >         // c.test(number)를 활용해 구현할 수 있다.
  >     }
  >     ```
  > - 익명 클래스를 자바 8의 람다를 활용해 구현한다.

### 스트림
- [x] map, reduce, filter 실습 1 
  > - List에 담긴 모든 숫자 중 3보다 큰 숫자를 2배 한 후 모든 값의 합을 구한다. 지금까지 학습한 map, reduce, filter를 활용해 구현해야 한다.
  > - nextstep.fp.StreamStudyTest 클래스의 sumOverThreeAndDouble() 테스트를 pass해야 한다.
- [x] map, reduce, filter 실습 2
  > - src/main/resources/fp 디렉토리 아래에 있는 war-and-peace.txt 파일을 읽어 다음 요구사항을 만족하세요.
  > - nextstep.fp.StreamStudy 클래스의 printLongestWordTop100() 메서드를 구현한다.
  > - 단어의 길이가 12자를 초과하는 단어를 추출한다.
  > - 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다.
  > - 단어 중복을 허용하지 않는다. 즉, 서로 다른 단어 100개를 추출해야 한다.
  > - 추출한 100개의 단어를 출력한다. 모든 단어는 소문자로 출력해야 한다.
- [x] 힌트
  > - 단어의 길이가 12자를 초과하는 단어를 추출한다.
  > - 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다.
  >   - sorted() method 활용
  > - 단어 중복을 허용하지 않는다. 즉, 서로 다른 단어 100개를 추출해야 한다.
  >   - distinct() method 활용
  > - 추출한 100개의 단어를 출력한다. 모든 단어는 소문자로 출력해야 한다.
  >   - String.toLowerCase() method 활용

### Optional
- [x] 요구사항 1 - Optional을 활용해 조건에 따른 반환
  > - nextstep.optional.User의 ageIsInRange1() 메소드는 30살 이상, 45살 이하에 해당하는 User가 존재하는 경우 true를 반환하는 메소드이다.
  > - 같은 기능을 Optional을 활용해 ageIsInRange2() 메소드에 구현한다. 메소드 인자로 받은 User를 Optional로 생성하면 stream의 map, filter와 같은 메소드를 사용하는 것이 가능하다.
  > - nextstep.optional.UserTest의 테스트가 모두 pass해야 한다.
- [x] 요구사항 2 - Optional에서 값을 반환
  > - nextstep.optional.Users의 getUser() 메소드를 자바 8의 stream과 Optional을 활용해 구현한다.
  > - 자바 8의 stream과 Optional을 사용하도록 리팩토링한 후 UsersTest의 단위 테스트가 통과해야 한다.
- [x] 요구사항 3 - Optional에서 exception 처리
  > - nextstep.optional.ExpressionTest의 테스트가 통과하도록 Expression의 of 메소드를 구현한다.
  > - 단, of 메소드를 구현할 때 자바 8의 stream을 기반으로 구현한다.
- [x] 힌트
  > - Guide To Java 8 Optional 문서를 참고해 Optional 사용 방법을 익힌다.
  > - Optional.ofNullable(user)을 활용해 User을 Optional로 생성하는 것이 가능하다.
  > - Optional의 map(), filter() 메소드등을 활용해 필요한 데이터를 추출
  > - Optional의 isPresent() 메소드 활용
  > - Optional의 orElse() 메소드 활용해 구현한다.
  > - 자바의 enum 전체 값은 values() 메소드를 통해 배열로 접근 가능하다.
  > - Arrays.stream()을 이용해 배열을 stream으로 생성할 수 있다.
  > - 일치하는 값 하나를 추출할 때 findFirst() 메소드를 활용 가능하다.
  > - Optional의 orElseThrow() 메소드 활용해 구현한다.

### 코멘트
- [x] 함수형 인터페이스는 애너테이션 `@FunctionalInterface`으로 선언

---
## STEP2. 사다리(생성)
### 기능 요구사항
> - 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
> - 사람 이름은 쉼표(,)를 기준으로 구분한다.
> - 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
> - 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
    >   - |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

- [x] 사다리 게임에 참여하는 사람의 이름은 최대 5글자이다.
- [x] 사다리 게임에 참여하는 사람의 이름은 쉼표(,)를 기준으로 구분한다.
- [x] 사다리 게임은 참여하는 사람의 이름과 최대 사다리 높이를 전달받는다.
- [x] 사다리 타기는 (참여하는 사람의 수 - 1) 만큼 라인이 생성된다.
- [x] 사다리 타기는 라인이 겹치지 않는다.
- [x] 사다리는 랜덤값 등 사다리 생성 전략 따라서 생성한다.
- [x] 사다리의 폭은 최대 글자 수 만큼으로 출력한다.

### 프로그래밍 요구사항
> - 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
> - 규칙 6: 모든 엔티티를 작게 유지한다.

실행 결과
```
참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)
pobi,honux,crong,jk

최대 사다리 높이는 몇 개인가요?
5

실행결과

pobi  honux crong   jk
    |-----|     |-----|
    |     |-----|     |
    |-----|     |     |
    |     |-----|     |
    |-----|     |-----|
```

### 힌트
> - 2차원 배열을 ArrayList, Generic을 적용해 구현하면 ArrayList<ArrayList<Boolean>>와 같이 이해하기 어려운 코드가 추가된다.
> - 사다리 게임에서 한 라인의 좌표 값을 가지는 객체를 추가해 구현해 본다.
> - 아래와 같이 Line 객체를 추가하면 ArrayList<ArrayList<Boolean>> 코드를 ArrayList<Line>과 같이 구현하는 것이 가능해 진다.

```java
public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line (int countOfPerson) {
        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
    }

    [...]
}
```

### 코멘트
- [x] 사소하지만 컨벤션을 준수하면 좋겠네요
- [x] InputView > `inputNames()` 입력 책임에 맞게 이름을 리스트로 제공해 주면 어떨까요? 그러면 비즈니스 로직에서 파싱할 필요가 없어져서 로직에만 집중할 수 있습니다.
- [x] OutputView > `printLadders()` depth가 깊어보이는데 스트림과 메소드 추출을 활용하면 좋겠습니다!
- [x] LineTest > `getLine()` 대신 `new Line()`으로 비교해 볼 수 있게 만들어봐도 좋겠네요
- [x] Lines > `validLadderLength()` 양수 값 객체를 만드는 방법도 있겠네요! `규칙 6: 모든 엔티티를 작게 유지한다.` 
- [x] LadderFactory > 상태를 가지는 대신 Factory가 객체를 생성해주는 방향으로 만들어보면 어떨까요? `var ladder = factory.rungs(names, hieght)`
- [x] Line > `createLine()` boolean 연산 값이 참일 때 라인 요소를 false로 세팅하네요. 가독성에 신경써서 이게 어떤 작업인지 메소드 이름을 통해 표현해 보면 좋겠습니다!
- [x] Ladder > 여러 라인을 반환하는데 List<List<Boolean>>으로 내보내는 것이 오히려 캡슐화를 깨뜨리는 행위이지 않을까요? lines를 게터로 제공하고 View에서 게터를 이용하여 사다리의 출력 포맷을 결정하는 게 좋을 것 같아요
- [ ] Line > 구성하는 요소(boolean)도 객체로 래핑해 보면 어떨까요?
