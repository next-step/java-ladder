# 1단계 - 자바8 스트림, 람다, Optional

## 람다

---

### 람다와 클로저

람다는 익명 함수의 다른 표현이다. 즉, 함수인데 이름이 없는 경우를 의미한다.

### Collection의 모든 값을 출력

```java
// nextstep.fp.Lambda의 printAllOld method
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

for (int number : numbers) {
    System.out.println(number);
}
```

### 람다가 없던 시절

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

numbers.forEach(new Consumer<Integer>() {
    public void accept(Integer value) {
        System.out.println(value);
    }
});
```

### 람다를 활용하면

```java
// nextstep.fp.Lambda의 printAllLambda method
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

numbers.forEach((Integer value) -> System.out.println(value));
numbers.forEach(value -> System.out.println(value)); // Type 추론이 가능해 Type 생략 가능
numbers.forEach(System.out::println); // :: 연산자 활용 가능
numbers.forEach(x -> System.out.println(x));
```

### 람다 실습 1 - 익명 클래스를 람다로 전환

- [x] 다음 테스트 코드에서 MoveStrategy에 대한 익명 클래스로 구현하고 있는데 람다를 적용해 구현한다.

```java
// nextstep.fp.CarTest의 이동, 정지 method
public class CarTest {
    @Test
    public void 이동() {
        Car car = new Car("pobi", 0);
        Car actual = car.move(new MoveStrategy() {
            @Override
            public boolean isMovable() {
                return true;
            }
        });
        assertEquals(new Car("pobi", 1), actual);
    }

    @Test
    public void 정지() {
        Car car = new Car("pobi", 0);
        Car actual = car.move(new MoveStrategy() {
            @Override
            public boolean isMovable() {
                return false;
            }
        });
        assertEquals(new Car("pobi", 0), actual);
    }
}
```

### 람다 실습2 - 람다를 활용해 중복 제거

```java
// nextstep.fp.Lambda의 sumAll method
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

public int sumAll(List<Integer> numbers) {
    int total = 0;
    for (int number : numbers) {
        total += number;
    }
    return total;
}
```

```java
// nextstep.fp.Lambda의 sumAllEven method
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

public int sumAllEven(List<Integer> numbers) {
    int total = 0;
    for (int number : numbers) {
        if (number % 2 == 0) {
            total += number;
        }
    }
    return total;
}
```

List에 담긴 값 중 3 보다 큰 수만을 더해야 한다.  
이 기능을 구현하려고 앞의 요구사항 1, 2와 많은 중복이 발생한다.

// nextstep.fp.Lambda의 sumAll, sumAllEven, sumAllOverThree method 소스 코드를 확인하고 중복 제거한다.

#### 힌트

- 변경되는 부분과 변경되지 않는 부분의 코드를 분리한다.
- 변경되는 부분을 인터페이스로 추출한다.
- 인터페이스에 대한 구현체를 익명 클래스(anonymous class)로 구현해 메소드의 인자로 전달한다.
- 구글에서 자바의 익명 클래스로 검색해 익명 클래스가 무엇인지 학습한다.
- 인터페이스는 다음과 같은 형태로 추출할 수 있다.

```java
public interface Conditional {
    boolean test(Integer number);
}
```

- Conditional을 활용해 공통 메소드의 구조는 다음과 같다.

```java
public int sumAll(List<Integer> numbers,
    Conditional c) {
    // c.test(number)를 활용해 구현할 수 있다.
}
```

- 익명 클래스를 자바 8의 람다를 활용해 구현한다.

## 스트림(Stream)

---

### map, filter, reduce
Collection에 담긴 데이터를 처리하려면 Collection을 순회하면서 각 Element를 처리하는 것이 일반적이다.  
앞으로는 순회하는 것을 잊고, Elemnt 처리에만 집중하자.
#### filter
요구사항은 파일 문자 중 길이가 12보다 큰 문자의 수를 구한다.
```java
// nextstep.fp.StreamStudy countWords method

String contents = new String(Files.readAllBytes(
  Paths.get("../ war-and-peace.txt")), StandardCharsets.UTF_8);
List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

long count = 0;
for (String w : words) {
  if (w.length() > 12) count++;  
}
```
#### filter 활용해 구현
```java
String contents = new String(Files.readAllBytes(
  Paths.get("../alice.txt")), StandardCharsets.UTF_8);
List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

long count = 
  words.stream().filter(w -> w.length() > 12).count();
```
#### map
List에 담긴 모든 숫자 값을 2배한 결과 List를 생성한다.
```java
// nextstep.fp.StreamStudy 클래스의 doubleNumbers method 참고
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
List<Integer> dobuleNumbers =
  numbers.stream().map(x -> 2 * x).collect(Collectors.toList());
```
#### reduce
List에 담긴 모든 숫자의 합을 구한다.
```java
// nextstep.fp.StreamStudy 클래스의 sumAll method 참고

List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

public int sumAll(List<Integer> numbers) {
    return numbers.stream().reduce(0, (x, y) -> x + y);
}
```
### 다양한 stream method 실습
> src/main/resources/fp 디렉토리 아래에 있는 war-and-peace.txt 파일을 읽어 다음 요구사항을 만족하세요.
#### map, reduce, filter 실습1
- [x] List에 담긴 모든 숫자 중3 보다 큰 숫자를 2배한 후 모든 값의 합을 구한다.  
지금까지 학습한 map, reduce, filter를 활용해 구현해야 한다.
    - nextstep.fp.StreamStudyTest 클래스의 sumOverThreeAndDouble() 테스트를 pass해야 한다.
 
#### map, reduce, filter 실습2
- [x] nextstep.fp.StreamStudy 클래스의 printLongestWordTop100() 메서드를 구현한다. 요구사항은 다음과 같다.
  - 단어의 길이가 12자를 초과하는 단어를 추출한다.
  - 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다.
  - 단어 중복을 허용하지 않는다. 서로 다른 단어 100개를 추출해야 한다.
  - 추출한 100개의 단어를 출력한다. 모든 단어는 소문자로 출력해야 한다.
#### 힌트
- 단어 길이가 12자를 초과하는 단어를 추출한다.
- 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다.
  - sorted() 활용
- 단어 중복을 허용하지 않는다. 즉 서로 다른 단어 100개를 추출해야 한다.
  - distinct() 활용
- 추출한 100개의 단어를 출력한다. 모든 단어는 소문자로 출력해야 한다.
  - String.toLowerCase() 활용

## Optional

---

### 요구사항 1 - Optional을 활용해 조건에 따른 반환
> nextstep.optional.User의 ageIsInRange1() 메소드는 30살 이상, 45살 이하에 해당하는 User가 존재하는 경우 true를 반환하는 메소드이다.
같은 기능을 Optional을 활용해 ageIsInRange2() 메소드에 구현한다. 메소드 인자로 받은 User를 Optional로 생성하면 stream의 map, filter와 같은 메소드를 사용하는 것이 가능하다.
nextstep.optional.UserTest의 테스트가 모두 pass해야 한다.

#### 힌트
- [Guide To Java8 Optional]() 문서를 참고해 Optional 사용 방법을 익힌다.
- Optional.ofNullable(user)을 활용해 User을 Optional로 생성하는 것이 가능하다.
- Optional의 map(), filter() 메서드등을 활용해 필요한 데이터를 추출
- Optional의 isPresent() 메서드 활용

### 요구사항 2 - Optional에서 값을 반환
> nextstep.optional.Users의 getUser() 메소드를 자바 8의 stream과 Optional을 활용해 구현한다.
자바 8의 stream과 Optional을 사용하도록 리팩토링한 후 UsersTest의 단위 테스트가 통과해야 한다.

#### 힌트
- [Guide To Java8 Optional]() 문서를 참고해 Optional 사용법을 익힌다.
- Optional의 orElse() 메서드를 활용해 구현한다.

### 요구사항 3 - Optional에서 exception 처리
> nextstep.optional.ExpressionTest의 테스트가 통과하도록 Expression의 of 메소드를 구현한다.
단, of 메소드를 구현할 때 자바 8의 stream을 기반으로 구현한다.

#### 힌트
- [Guide To Java8 Optional]() 문서를 참고해 Optional 사용법을 익힌다.
- Java의 enum 전체 값은 values() 메서드를 통해 배열로 접근이 가능하다.
- Arrays.stream() 메서드를 이용해 배열을 stream으로 생성할 수 있다.
- 일치하는 값 하나를 추출할 때 findFirst() 메서드를 활용할 수있따.
- Optional의 orElseThrow() 메서드를 활용해 구현한다.

# 2단계 - 사다리(생성)
 
---

## 기능 요구사항
- 사다리 게임에 참여하는 사람에 이름을 최대 5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
- 사람 이름은 쉼표(,)를 기준으로 구분한다.
- 사람 이름을 5자 기준으로 출력하기 떄문에 사다리 폭도 넓어져야 한다.
- 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야한다.
  - `|-----|-----|` 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 있다.
  
## 프로그래밍 요구사항
- 자바8의 스트림과 람다를 적용해 프로그래밍 한다.
- 규칙 6 : 모든 엔티티를 작게 유지한다.

### 실행 결과
- 위 요구사항에 따라 4명의 사람을 위한 5개 높이의 사다리를 만들 경우, 프로그램을 실행한 결과는 다음과 같다.
```java
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

## 힌트
- 2차원 배열을 ArrayList, Generic을 적용해 구현하면 `ArrayList<ArrayList<Boolean>>` 와 같이 이해하기 어려운 코드가 추가된다.
- 사다리 게임에서 한 라인의 좌표 값을 가지는 객체를 추가해 구현해 본다.
```java
public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line (int numberOfParticipant) {
        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
    }

    [...]
}
```
- 위와 가이 Line 객체를 추가하면 `ArrayList<ArrayList<Boolean>>` 코드를 `ArrayList<Line>`과 같이 구현할 수 있다.

## 요구사항 분리 하기
1. 사다리 포인트 생성  
   → 실질적으로 사다리의 라인을 그릴지 말지 결정하는 요소로써 변경 가능성이 있을 거라고 예상과 테스트 용이성으로 인해 `interface` 로 생성
2. 이동 방향 결정
   왼쪽으로 갈지 오른쪽으로 갈지, 아래로 갈지 방향 결정을 한다.  
   왼쪽과 현재의 라인이 그어진 여부를 알 수 있다.  
   → 왼쪽으로 이동  
   → 오른쪽으로 이동  
   → 제자리(이동하지 않음)  
   → 왼쪽, 오른쪽 모두 이동할 수 없다.  
3. 포인트 생성 및 이동 하기    
   → 위치 이동하기(상세한 이동 테스트는 위에 2번 이동 방향 결정에서 했기 때문에 안함)  
   → 생성자로 할 수 있지만 API 사용 시 편의성 및 오용 방지를 위해 강제하는 기능들  
   → 첫 번째 포인트 생성  
   → 다음 포인트 생성_이전 위치가 선이 있을 경우  
   → 다음 포인트 생성_이전 위치가 선이 없을 경우  
   → 마지막 포인트 생성  
4. 라인 생성(가로)   
5. 라인의 각 포인트 이동
6. 사다리 생성   
7. 이름 생성  
   → 최대 5자  
   → 최소 1자  
   → 공란 불가
8. 참가자 목록 생성  
   → 쉼표로 참가자 이름을 구분한다.  
   → 최소 2명 이상
9. 사다리 높이 생성  
   → 10 초과 시 예외  
   → 1 미만 시 예외  
10. 사다리 그리기(UI)  
   → 스프링의 RestController 방식으로 Controller 구현  
     대략적으로 느낌만 살려봄. UI를 완전히 분리하고 싶어서.
    
# 3단계, 4단계 - (게임 실행, 리팩토링)

---
## 요구사항
- 사다리 실행 결과를 출력해야 한다.
- 개인별 이름을 입력하면 개인별 결과를 출력하고, “all”을 입력하면 전체 참여자의 실행 결과를 출력한다.

## 프로그래밍 요구사항
- 자바 8의 스트림과 람다를 적용한다.
- 규칙 6 : 모든 엔티티를 작게 유지한다.
- 규칙 7 : 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.

### 실행 결과
- 요구사항에 따라 4명의 사람을 위한 5개의 높이 사다리를 만들 경우, 프로그램을 실행한 결과는 다음과 같다.
```java
참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)
pobi,honux,crong,jk

실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)
꽝,5000,꽝,3000

최대 사다리 높이는 몇 개인가요?
5

사다리 결과

pobi  honux crong   jk
    |-----|     |-----|
    |     |-----|     |
    |-----|     |     |
    |     |-----|     |
    |-----|     |-----|
꽝    5000  꽝    3000

결과를 보고 싶은 사람은?
pobi

실행 결과
꽝

결과를 보고 싶은 사람은?
all

실행 결과
pobi : 꽝
honux : 3000
crong : 꽝
jk : 5000
```
### 힌트
- 각 로직을 구현하기 위해 데이터를 가지는 객체를 분리하기 위해 노력 해본다. 로직 구현에 필요한 데이터를 가지는  
  객체를 잘 분리하면 쉽게 문제를 해결할 수 있다.
- 각 객체가 2개 이하의 인스턴스 변수만을 가지도록 구현해 본다.

## 요구사항 분리 하기
1. 결과 입력  
   → 쉼표(,) 구분자로 결과를 생성한다.  
   → index로 결과 검색  
2. 당첨된 사다리 결과  
   → 결과 생성  
   → 생성한 결과 반환  
3. 반환된 결과에서 각 참가자의 결과 검색  
   → dugi → 꽝  
   → all → 모든 참가자의 결과  