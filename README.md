# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

# 1단계 - 자바8 스트림, 람다, Optional
### 람다
* 람다(lambda)
* 람다와 클로저
* 람다는 익명 함수의 다른 표현이다. 즉, 함수는 함수인데 이름이 없는 경우를 의미한다.
<pre><code>
Collection의 모든 값을 출력
// nextstep.fp.Lambda의 printAllOld method
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

for (int number : numbers) {
    System.out.println(number);
}
람다가 없던 시절
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

numbers.forEach(new Consumer<Integer>() {
    public void accept(Integer value) {
        System.out.println(value);
    }
});
람다를 활용하면…
// nextstep.fp.Lambda의 printAllLambda method
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

numbers.forEach((Integer value) -> System.out.println(value));
numbers.forEach(value -> System.out.println(value)); // Type 추론이 가능해 Type 생략 가능
numbers.forEach(System.out::println); // :: 연산자 활용 가능
= numbers.forEach(x -> System.out.println(x));
람다 문법
input arguments -> body
</code></pre>

### 람다 실습 1 - 익명 클래스를 람다로 전환
* 다음 테스트 코드에서 MoveStrategy에 대한 익명 클래스로 구현하고 있는데 람다를 적용해 구현한다.
<pre><code>
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
</code></pre>

### 람다 실습 2 - 람다를 활용해 중복 제거
<pre><code>
// nextstep.fp.Lambda의 sumAll method
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

public int sumAll(List<Integer> numbers) {
    int total = 0;
    for (int number : numbers) {
        total += number;
    }
    return total;
}
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
List에 담긴 값 중 3보다 큰 수만을 더해야 한다.
이 기능을 구현하려고 보니 앞의 요구사항 1,2와 많은 중복이 발생한다. 람다를 활용해 중복을 제거한다.

// nextstep.fp.Lambda의 sumAll, sumAllEven, sumAllOverThree method 소스 코드를 확인하고 중복 제거한다.
</code></pre>

### 힌트
* 변경되는 부분과 변경되지 않는 부분의 코드를 분리한다.
* 변경되는 부분을 인터페이스로 추출한다.
* 인터페이스에 대한 구현체를 익명 클래스(anonymous class)로 구현해 메소드의 인자로 전달한다.
* 구글에서 자바의 익명 클래스로 검색해 익명 클래스가 무엇인지 학습한다.
* 인터페이스는 다음과 같은 형태로 추출할 수 있다.

<pre><code>
public interface Conditional {
    boolean test(Integer number);
}
Conditional을 활용해 공통 메소드의 구조는 다음과 같다.
public int sumAll(List<Integer> numbers,
    Conditional c) {
    // c.test(number)를 활용해 구현할 수 있다.
}
익명 클래스를 자바 8의 람다를 활용해 구현한다.
</code></pre>

# 스트림(stream)
* map, filter, reduce
* Collection에 담긴 데이터를 처리하려면 Collection을 순회하면서 각 Element를 처리하는 것이 일반적이다. 앞으로는 순회하는 것을 잊고, Element 처리에만 집중하자.

### filter
* 요구사항은 파일 문자 중 길이가 12보다 큰 문자의 수를 구한다.

<pre><code>
// nextstep.fp.StreamStudy countWords method

String contents = new String(Files.readAllBytes(
  Paths.get("../ war-and-peace.txt")), StandardCharsets.UTF_8);
List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

long count = 0;
for (String w : words) {
  if (w.length() > 12) count++;  
}
</code></pre>

### filter 활용해 구현
<pre><code>
String contents = new String(Files.readAllBytes(
  Paths.get("../alice.txt")), StandardCharsets.UTF_8);
List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

long count = 
  words.stream().filter(w -> w.length() > 12).count();
map
List에 담긴 모든 숫자 값을 2배한 결과 List를 생성한다.

// nextstep.fp.StreamStudy 클래스의 doubleNumbers method 참고
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
List<Integer> dobuleNumbers =
  numbers.stream().map(x -> 2 * x).collect(Collectors.toList());
reduce
List에 담긴 모든 숫자의 합을 구한다.

// nextstep.fp.StreamStudy 클래스의 sumAll method 참고

List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

public int sumAll(List<Integer> numbers) {
    return numbers.stream().reduce(0, (x, y) -> x + y);
}
</code></pre>

### 다양한 stream method 실습
* src/main/resources/fp 디렉토리 아래에 있는 war-and-peace.txt 파일을 읽어 다음 요구사항을 만족하세요.

### map, reduce, filter 실습 1
* List에 담긴 모든 숫자 중 3보다 큰 숫자를 2배 한 후 모든 값의 합을 구한다. 지금까지 학습한 map, reduce, filter를 활용해 구현해야 한다.
* nextstep.fp.StreamStudyTest 클래스의 sumOverThreeAndDouble() 테스트를 pass해야 한다.

### map, reduce, filter 실습 2
* nextstep.fp.StreamStudy 클래스의 printLongestWordTop100() 메서드를 구현한다. 요구사항은 다음과 같다.
* 단어의 길이가 12자를 초과하는 단어를 추출한다.
* 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다.
* 단어 중복을 허용하지 않는다. 즉, 서로 다른 단어 100개를 추출해야 한다.
* 추출한 100개의 단어를 출력한다. 모든 단어는 소문자로 출력해야 한다.

### 힌트
* 단어의 길이가 12자를 초과하는 단어를 추출한다.
* 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다.
    * sorted() method 활용
* 단어 중복을 허용하지 않는다. 즉, 서로 다른 단어 100개를 추출해야 한다.
    distinct() method 활용
* 추출한 100개의 단어를 출력한다. 모든 단어는 소문자로 출력해야 한다.
    * String.toLowerCase() method 활용

# Optional
### 요구사항 1 - Optional을 활용해 조건에 따른 반환
* nextstep.optional.User의 ageIsInRange1() 메소드는 30살 이상, 45살 이하에 해당하는 User가 존재하는 경우 true를 반환하는 메소드이다.
* 같은 기능을 Optional을 활용해 ageIsInRange2() 메소드에 구현한다. 메소드 인자로 받은 User를 Optional로 생성하면 stream의 map, filter와 같은 메소드를 사용하는 것이 가능하다.
* nextstep.optional.UserTest의 테스트가 모두 pass해야 한다.

### 힌트
* Guide To Java 8 Optional 문서를 참고해 Optional 사용 방법을 익힌다.
* Optional.ofNullable(user)을 활용해 User을 Optional로 생성하는 것이 가능하다.
* Optional의 map(), filter() 메소드등을 활용해 필요한 데이터를 추출
* Optional의 isPresent() 메소드 활용

### 요구사항 2 - Optional에서 값을 반환
* nextstep.optional.Users의 getUser() 메소드를 자바 8의 stream과 Optional을 활용해 구현한다.
* 자바 8의 stream과 Optional을 사용하도록 리팩토링한 후 UsersTest의 단위 테스트가 통과해야 한다.

### 힌트
* Guide To Java 8 Optional 문서를 참고해 Optional 사용 방법을 익힌다.
* Optional의 orElse() 메소드 활용해 구현한다.

### 요구사항 3 - Optional에서 exception 처리
* nextstep.optional.ExpressionTest의 테스트가 통과하도록 Expression의 of 메소드를 구현한다.
* 단, of 메소드를 구현할 때 자바 8의 stream을 기반으로 구현한다.

### 힌트
* Guide To Java 8 Optional 문서를 참고해 Optional 사용 방법을 익힌다.
* 자바의 enum 전체 값은 values() 메소드를 통해 배열로 접근 가능하다.
* Arrays.stream()을 이용해 배열을 stream으로 생성할 수 있다.
* 일치하는 값 하나를 추출할 때 findFirst() 메소드를 활용 가능하다.
* Optional의 orElseThrow() 메소드 활용해 구현한다.

### Step1 리뷰 사항
* [x] [fix01][Lambda.java] stream 가독성을 위해 단계별로 구분해보기 

# 2단계 - 사다리(생성) 
### 기능 요구사항
* 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
* 사람 이름은 쉼표(,)를 기준으로 구분한다.
* 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
* 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
    * <code>|-----|-----|</code> 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

### 프로그래밍 요구사항
* 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
* 규칙 6: 모든 엔티티를 작게 유지한다.

### 실행 결과
* 위 요구사항에 따라 4명의 사람을 위한 5개 높이 사다리를 만들 경우, 프로그램을 실행한 결과는 다음과 같다.
<pre><code>
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
</code></pre>

### 힌트
* 2차원 배열을 ArrayList, Generic을 적용해 구현하면 ArrayList<ArrayList<Boolean>>와 같이 이해하기 어려운 코드가 추가된다.
* 사다리 게임에서 한 라인의 좌표 값을 가지는 객체를 추가해 구현해 본다.
<pre><code>
public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line (int countOfPerson) {
        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
    }

    [...]
}
</code></pre>
* 위와 같이 Line 객체를 추가하면 ArrayList<ArrayList<Boolean>> 코드를 ArrayList<Line>과 같이 구현하는 것이 가능해 진다.

##### Method 규칙 
* 객체를 새로 만드는 건 generate, 있는 것들을 조합하는건 make
* 상태를 만나는 건 meet, 조건(true/false)를 만나는건 is

### Step2 리뷰사항
* [x] [fix01][StringUtil.java] 자연스럽게 위에서 아래로 읽히도록 코드 가독성 개선해보기 
* [x] [fix02][InputView.java] 클래스, 상수, 전역변수, 생성자, 메소드 순서로 만들어 보기  
* [x] [fix03][Ladder.java] Max 말고 if 사용하기 (가독성 개선)  
* [ ] [fix04][AlwaysDrawingRule.java] 랜덤하게 사다리가 그려지도록 개선하기

# 3단계 - 사다리(게임 실행)
### 기능 요구사항
* 사다리 실행 결과를 출력해야 한다.
* 개인별 이름을 입력하면 개인별 결과를 출력하고, "all"을 입력하면 전체 참여자의 실행 결과를 출력한다.

### 프로그래밍 요구사항
* 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
* 규칙 6: 모든 엔티티를 작게 유지한다.
* 규칙 7: 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.

### 실행 결과
* 위 요구사항에 따라 4명의 사람을 위한 5개 높이 사다리를 만들 경우, 프로그램을 실행한 결과는 다음과 같다.
<pre><code>
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
</code></pre>

### 힌트
* 각 로직을 구현하기 위해 필요한 데이터를 가지는 객체를 분리하기 위해 노력해본다. 
* 로직 구현에 필요한 데이터를 가지는 객체를 잘 분리하면 의외로 쉽게 문제를 해결할 수 있다.
* 각 객체가 2개 이하의 인스턴스 변수만을 가지도록 구현해 본다.   
 
### Step3 리뷰 사항 
* [ ] [fix01][Ladder.java] 과도한 stream 사용을 지양할 것

### 아이템45. 스트림은 주의해서 사용하라
* 스트림은 다량의 데이터 처리 작업을 위해 jdk 1.8 부터 도입되었다. 스트림은 데이터 원소의 유무한 시퀀스를 뜻하며, 스트림 파이프라인은 이 원소들로 수행하는 연산 단계를 표현한다.
* 스트림은 어디로부터 만들 수 있는데, 가장 많이 쓰이는 곳은 컬렉션, 배열, 파일, 정규표현식 패턴 매처, 난수 생성기 등이 있다.
* 스트림은 메소드 연쇄를 지원하는 fluent API 이다.

#### 45-1. 스트림 파이프라인
* 스트림 파이프라인은 시작에서 종단 연산으로 끝나며, 그 사이에 하나 이상의 중간연산이 있을 수 있다. 중간연산은 스트림을 변환한다.
* 스트림 파이프라인은 지연 평가되며, 평가는 종단 연산이 호출될 때 이루어지며, 종단 연산에 쓰이지 않는 데이터 원소는 계산에 쓰이지 않는다. 이것은 무한 스트림을 다룰 수 있게 해주는 열쇠이다.

#### 45-2. 스트림을 과하게 쓰면 오히려 읽기 힘들다
* 먼저 스트림을 쓰지 않은 예제 코드이다.
<pre><code>
public class Anagrams {
    public static void main(String[] args) throws IOException {
        File dictionary = new File(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);

        Map<String, Set<String>> groups = new HashMap<>();
        try (Scanner s = new Scanner(dictionary)) {
            while (s.hasNext()) {
                String word = s.next();
                groups.computeIfAbsent(alphabetize(word), (unused) -> new TreeSet<>())
                    .add(word);
            }
        }

        for (Set<String> group : groups.values())
            if (group.size() >= minGroupSize)
                System.out.println(group.size() + ": " + group);
    }

    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
</code></pre>
* 스트림을 사용하여 라인수는 조금 짧아졌지만, 읽기 힘들정도로 과하게 사용한 예제이다.
<pre><code>
public class Anagrams {
    public static void main(String[] args) throws IOException {
        Path dictionary = Paths.get(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);

        try (Stream<String> words = Files.lines(dictionary)) {
            words.collect(groupingBy(word -> word.chars().sorted()
                            .collect(StringBuilder::new,
                                    (sb, c) -> sb.append((char) c),
                                    StringBuilder::append).toString()))
                    .values().stream()
                    .filter(group -> group.size() >= minGroupSize)
                    .map(group -> group.size() + ": " + group)
                    .forEach(System.out::println);
        }
    }
}
</code></pre>
* 뭐든 stream으로 푸는 것보다 적절히 분리하여(도우미 메소드. ex. alphabetize) 짧으면서도 명확하게 스트림을 사용하는 것이 좋다. 특히 람다에서는 타입이름이 생략되므로 매개변수 이름을 잘 지어서 가독성을 유지해야한다.
<pre><code>
try (Stream<String> words = Files.lines(dictionary)) {
    words.collect(groupingBy(word -> alphabetize(word)))
            .values().stream()
            .filter(group -> group.size() >= minGroupSize)
            .forEach(group -> System.out.println(group.size() + ": " + group));
}
</code></pre>
* 또한 스트림은 기본 타입 중에 int, long, double 만 지원한다. (char용 스트림은 없으니 쓰지말자)

#### 45-3. 코드블록 vs 람다블록
* 코드블록에서는 지역변수를 읽고 수정할 수 있으나, 람다 블록에서는 final 변수이거나 사실상 final 변수인 것만 읽을 수 있고(클로저, Variable capture), 지역변수를 수정하는 것은 불가능하다.
<pre><code>
ex. stream + lambda 에서 순차증가하는 방법
// 배열 이용. 멀티스레드에선 안전X
int[] count = {0};
IntStream.range(0, 1000000).forEach((i) -> {
	count[0]++;
	System.out.println(count[0]);
});

// Atomic Reference 이용. 권장
AtomicInteger count = new AtomicInteger();
IntStream.range(0, 1000000).forEach((i) -> {
	System.out.println(count.incrementAndGet());
});
</code></pre>
* 코드블록에서는 return, break, continue 문으로 바깥을 종료시키거나 건너뛰거나 하는 행위를 할 수 있지만, 람다에서는 아무것도 할 수 없다.

#### 45-4. 스트림을 사용하면 좋은 상황과 나쁜 상황
##### 45-4-1. 좋은 상황
* 원소들의 시퀀스를 일관되게 변환한다.
* 원소들의 시퀀스를 필터링한다.
* 원소들의 시퀀스를 하나의 연산을 사용해 결합한다.
* 원소들의 시퀀스를 컬렉션에 모은다.
* 원소들의 시퀀스에서 특정 조건을 만족하는 원소를 찾는다.

##### 45-4-2. 나쁜 상황
* 스트림 파이프라인이 여러 연산단계로 구성될 때, 각 단계의 값들을 동시에 접근하고자 할때
* 스트림 파이프라인은 연산이 지나가면 원래값을 잃는 구조이기 때문이다.
* cf. 매핑객체를 이용하면 방법이 있으나 지저분해짐

출처: https://sjh836.tistory.com/173

# 4단계 - 사다리(리팩토링)
### 기능 요구사항
* 기능 요구사항 3단계와 같다.
* 추가로 제공되는 객체 설계 힌트를 참고해 철저하게 TDD로 재구현해 본다.

### 객체 추출 힌트
* 사다리 한 Line 추상화
* 사다리 게임에서 한 Line을 LadderLine으로 이름을 붙이고 다음과 같이 구현
* 사다리 Line의 모든 Point 초기화와 이동을 담당
<pre><code>
import java.util.ArrayList;
import java.util.List;

import static codesquad.LadderPointGenerator.generatePoint;

public class LadderLine {
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public static LadderLine init(int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        point = initBody(sizeOfPerson, points, point);
        initLast(points, point);
        return new LadderLine(points);
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private static Point initFirst(List<Point> points) {
        Point point = Point.first(generatePoint());
        points.add(point);
        return point;
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }
}
</code></pre>

* LadderLine에 대한 테스트 코드는 다음과 같다.
<pre><code>
public class LadderLineTest {
    @Test
    public void init() {
        int sizeOfPerson = 5;
        System.out.println(LadderLine.init(sizeOfPerson));
    }

    @Test
    public void move() {
        LadderLine line = LadderLine.init(2);
        System.out.println("ladder result : " + line.move(0));
    }
}
</code></pre>

* LadderLine의 두 점과 현재 위치를 Point로 추상화
* LadderLine에서 위치와 각 점의 방향을 관리
<pre><code>
public class Point {
    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
        System.out.println("is left? " + direction.isLeft());
        System.out.println("is right? " + direction.isRight());

        if (direction.isRight()) {
            return index + 1;
        }

        if (direction.isLeft()) {
            return index - 1;
        }

        return this.index;
    }

    public Point next() {
        return new Point(index + 1, direction.next());
    }

    public Point next(Boolean right) {
        return new Point(index + 1, direction.next(right));
    }
		
    public Point last() {
        return new Point(index + 1, direction.last());
    }

    public static Point first(Boolean right) {
        return new Point(0, Direction.first(right));
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", direction=" + direction +
                '}';
    }
}
</code></pre>

* Point에 대한 테스트 코드는 다음과 같다.
<pre><code>
import org.junit.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PointTest {
    @Test
    public void first() {
        assertThat(Point.first(TRUE).move(), is(1));
        assertThat(Point.first(FALSE).move(), is(0));
    }

    @Test
    public void next_stay() {
        Point second = Point.first(FALSE).next(FALSE);
        assertThat(second.move(), is(1));
    }

    @Test
    public void next_left() {
        Point second = Point.first(TRUE).next(FALSE);
        assertThat(second.move(), is(0));
    }

    @Test
    public void next_right() {
        Point second = Point.first(FALSE).next(TRUE);
        assertThat(second.move(), is(2));
    }

    @Test
    public void next() {
        Point second = Point.first(TRUE).next();
        assertThat(second.move(), is(0));
    }
}
</code></pre>

* 각 Point의 좌/우 방향을 Direction으로 추상화
* 각 Point의 좌/우 방향 정보를 가진다.
* 현재 Point에서 다음 Point를 생성하는 역할
<pre><code>
import java.util.Objects;

import static codesquad.LadderPointGenerator.generatePoint;
import static java.lang.Boolean.FALSE;

public class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException();
        }

        this.left = left;
        this.right = right;
        System.out.println(this);
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public Direction next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public Direction next() {
        if (this.right) {
            return next(FALSE);
        }
        return next(generatePoint());
    }

    public static Direction of(boolean first, boolean second) {
        return new Direction(first, second);
    }

    public static Direction first(boolean right) {
        return of(FALSE, right);
    }
		
    public Direction last() {
        return of(this.right, FALSE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction pair = (Direction) o;
        return left == pair.left &&
                right == pair.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return "Direction{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
</code></pre>

* Direction에 대한 테스트 코드는 다음과 같다.
<pre><code>
import org.junit.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DirectionTest {
    @Test
    public void init() {
        assertThat(Direction.of(true, false), is(Direction.of(true, false)));
    }

    @Test(expected = IllegalStateException.class)
    public void init_invalid() {
        Direction.of(TRUE, TRUE);
    }

    @Test
    public void next_random_true() {
        Direction next = Direction.first(TRUE).next();
        assertThat(next, is(Direction.of(TRUE, FALSE)));
    }

    @Test
    public void next_random_false() {
        for (int i = 0; i < 100; i++) {
            Direction.first(FALSE).next();
        }
    }

    @Test
    public void next_true() {
        Direction next = Direction.of(TRUE, FALSE).next(TRUE);
        assertThat(next, is(Direction.of(FALSE, TRUE)));
    }

    @Test
    public void next_false() {
        Direction next = Direction.of(FALSE, TRUE).next(FALSE);
        assertThat(next, is(Direction.of(TRUE, FALSE)));
    }

    @Test
    public void first() {
        Direction first = Direction.first(TRUE);
        assertThat(first.isLeft(), is(FALSE));
    }

    @Test
    public void last() {
        Direction last = Direction.first(TRUE).last();
        assertThat(last, is(Direction.of(TRUE, FALSE)));
    }
}
</code></pre>
