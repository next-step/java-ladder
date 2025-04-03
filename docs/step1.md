## 기능 구현 명세 (람다)
- [x] CarTest 테스트 코드에서 MoveStrategy에 대한 익명 클래스를 람다로 변경
- [x] nextstep.fp.Lambda의 sumAll, sumAllEven, sumAllOverThree method 소스 코드를 확인하고 중복 제거

## 힌트
변경되는 부분과 변경되지 않는 부분의 코드를 분리한다.
변경되는 부분을 인터페이스로 추출한다.
인터페이스에 대한 구현체를 익명 클래스(anonymous class)로 구현해 메소드의 인자로 전달한다.
구글에서 자바의 익명 클래스로 검색해 익명 클래스가 무엇인지 학습한다.
인터페이스는 다음과 같은 형태로 추출할 수 있다.

## 기능 구현 명세 (스트림)
- [x] nextstep.fp.StreamStudyTest 클래스의 sumOverThreeAndDouble() 테스트를 pass
- [x] nextstep.fp.StreamStudy 클래스의 printLongestWordTop100() 메서드를 구현

## 힌트
단어의 길이가 12자를 초과하는 단어를 추출한다.
12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다.
sorted() method 활용
단어 중복을 허용하지 않는다. 즉, 서로 다른 단어 100개를 추출해야 한다.
distinct() method 활용
추출한 100개의 단어를 출력한다. 모든 단어는 소문자로 출력해야 한다.
String.toLowerCase() method 활용

## 기능 구현 명세 (Optional)
- [x] ageIsInRange1() 메소드와 같은 기능을 하는 ageIsInRange2() 메소드를 구현
  - [x] nextstep.optional.UserTest의 테스트가 모두 pass
- [x] nextstep.optional.Users의 getUser() 메소드를 자바 8의 stream과 Optional을 활용해 구현
  - [x] UsersTest의 단위 테스트가 통과
- [ ] nextstep.optional.ExpressionTest의 테스트가 통과하도록 Expression의 of 메소드를 구현

## 힌트
Guide To Java 8 Optional 문서를 참고해 Optional 사용 방법을 익힌다.
자바의 enum 전체 값은 values() 메소드를 통해 배열로 접근 가능하다.
Arrays.stream()을 이용해 배열을 stream으로 생성할 수 있다.
일치하는 값 하나를 추출할 때 findFirst() 메소드를 활용 가능하다.
Optional의 orElseThrow() 메소드 활용해 구현한다.
