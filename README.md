# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## 1단계 - 자바8, 스트림, 람다, Optional

- `람다`와 `클로저`
    - `람다`는 `익명 함수`의 다른 표현
    - 함수는 함수인데 이름이 없는 경우

### 람다(lambda)
- `익명 클래스`로 구현된 코드를 `람다`로 수정
- `람다`를 활용한 중복 데이터 제거

- 힌트
  - `변경되는 부분`과 `변경되지 않는 부분`의 코드를 분리한다.
  - `변경되는 부분`을 인터페이스로 추출한다.
  - `인터페이스`에 대한 `구현체`를 `익명 클래스(anonymous class)`로 구현해 `메소드의 인자`로 전달한다.
  - 구글에서 자바의 익명 클래스로 검색해 `익명 클래스`가 무엇인지 학습한다.

### 스트림(stream)
- map, filter, reduce
- 앞으로는 순회하는 것을 잊고, Element 처리에만 집중하자.

- 실습 1
  - List에 담긴 모든 숫자 중 `3보다 큰 숫자`를 `2배` 한 후 `모든 값의 합`을 구한다. 
  - 지금까지 학습한 `map`, `reduce`, `filter`를 활용해 구현해야 한다.

- 실습 2
  - `단어의 길이가 12자를 초과`하는 단어를 추출한다.
  - 12자가 넘는 단어 중 `길이가 긴 순서로 100개`의 단어를 추출한다.
  - `단어 중복을 허용하지 않는다`. 즉, `서로 다른 단어 100개`를 추출해야 한다.
  - 추출한 100개의 단어를 출력한다. `모든 단어는 소문자로 출력`해야 한다.

### Optional
- `요구사항1: Optional을 활용해 조건에 따른 반환`
  - ageIsInRange1() 메소드는 `30살 이상, 45살 이하`에 해당하는 `User가 존재하는 경우 true를 반환`하는 메소드
  
  - 힌트
    - [Guide To Java 8 Optional](https://www.baeldung.com/java-optional) 문서를 참고해 Optional 사용 방법을 익힌다.
    - Optional.ofNullable(user)을 활용해 User을 Optional로 생성하는 것이 가능하다.
    - Optional의 map(), filter() 메소드등을 활용해 필요한 데이터를 추출
    - Optional의 isPresent() 메소드 활용

- `요구사항2: Optional에서 값을 반환`
  - getUser() 메소드를 자바 8의 stream과 Optional을 활용해 구현
  - 자바 8의 stream과 Optional을 사용하도록 리팩토링

  - 힌트
    - [Guide To Java 8 Optional](https://www.baeldung.com/java-optional) 문서를 참고해 Optional 사용 방법을 익힌다.
    - Optional의 orElse() 메소드 활용해 구현한다.
  

- `요구사항3: Optional에서 exception 처리`
  - Expression의 of 메소드를 구현
  - 단, of 메소드를 구현할 때 자바 8의 stream을 기반으로 구현한다.

  - 힌트
    - [Guide To Java 8 Optional](https://www.baeldung.com/java-optional) 문서를 참고해 Optional 사용 방법을 익힌다.
    - 자바의 `enum` 전체 값은 `values()` 메소드를 통해 배열로 접근 가능하다.
    - `Arrays.stream()`을 이용해 배열을 stream으로 생성할 수 있다.
    - 일치하는 값 하나를 추출할 때 `findFirst()` 메소드를 활용 가능하다.
    - Optional의 `orElseThrow()` 메소드 활용해 구현한다.

## 2단계 - 사다리 (생성)
- 기능 요구사항
  - 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
  - 사람 이름은 쉼표(,)를 기준으로 구분한다.
  - 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
  - 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
    - |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

- 프로그래밍 요구사항
  - 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
  - 규칙 6: 모든 엔티티를 작게 유지한다.

- 실행 결과
```text
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

- 힌트
  - 2차원 배열을 ArrayList, Generic을 적용해 구현하면 ArrayList<ArrayList<Boolean>>와 같이 이해하기 어려운 코드가 추가된다.
  - 사다리 게임에서 한 라인의 좌표 값을 가지는 객체를 추가해 구현해 본다.

```java
public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line (int countOfPerson) {
        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
    }
    // ...
}
```

- 생각나는 추가 조건
  - 게임은 2명 이상이어야 사다리가 만들어진다.
  - 높이는 0이상만 가능하다.

- 요구사항 스케치
  - 참여자 -> 이름
  - 사다리높이
  - 참여자 + 사다리 높이 -> 사다리
  
- Line 만들기

  ```text
    user1 user2 user3
    |-----|-----|
    |-----|-----|
  ```

- 다시 생각하기
  - 라인이 겹치지 않도록 해야 한다.
  - 라인을 중복하지않게 하기 위한 방법 최선인가?
