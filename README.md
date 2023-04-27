# 사다리 게임

## 스트림, 람다, Optional

### 람다

- [x] MoveStrategy에 대한 익명 클래스로 구현하고 있는 것을 람다를 적용해 구현한다.
- [x] nextstep.fp.Lambda의 sumAll, SumAllEven, sumAllOverThree method를 람다를 활용해 중복을 제거한다.

### 스트림

- [x] List에 담긴 숫자 중 3보다 큰 숫자를 2배한 후 모든 값의 합을 구한다.
  - [x] nextstep.fp.StreamStudyTest 클래스의 sumOverThreeAndDouble() 테스트를 pass해야 한다.
- [x] nextstep.fp.StreamStudy 클래스의 printLongestWordTop100() 메서드를 구현한다.
  - [x] 단어의 길이가 12자를 초과하는 단어를 추출한다.
  - [x] 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다.
  - [x] 단어 중복을 허용하지 않는다. 즉, 서로 다른 단어 100개를 추출해야 한다.
  - [x] 추출한 100개의 단어를 출력한다. 모든 단어는 소문자로 출력해야 한다.

### Optional

- [x] nextstep.optional.User의 ageIsInRange2() 메서드를 구현한다.
  - [x] 30살 이상, 45살 이하에 해당하는 User가 존재하는 경우 true를 반환하는 메서드를 구현한다.
  - [x] agesInRange1() 메서드와 같은 기능을 Optional을 활용해 구현한다.
  - [x] nextstep.optional.UserTest의 테스트를 모두 pass해야 한다
- [x] nextstep.optional.Users의 getUser() 메서드를 자바 8의 stream과 Optional을 활용해 구현한다.
  - [x] 자바 8의 stream과 Optional을 사용하도록 리팩토링한다.
  - [x] UsersTest의 단위 테스트를 통과해야 한다.
- [x] nextstep.optional.ExpressionTest의 테스트가 통과되도록 Expressiondml of 메서드를 구현한다.
  - [x] of 메서드를 구현할 때 자바 8의 stream을 기반으로 구현한다.
