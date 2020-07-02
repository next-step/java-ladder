# 사다리 게임

## 진행 방법

- 사다리 게임 게임 요구사항을 파악한다.
- 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
- 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
- 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다. 



## 1단계 - 자바8 스트림, 람다, Optional

## 람다 실습 1 - 익명클래스를 람다로 전환

- CarTest에서 MoveStrategy에 대한 익명 클래스로 구현하고 있는 데 람다를 적용해 구현한다.



## 람다 실습 2 - 람다를 활용해 중복 제거

Nextstep.fp.Lamda에서 sumAll, sumAllEven, sumAllOverThree method 소스 코드를 확인하고 중복 제거한다.

**힌트**

- 변경되는 부분과 변경되지 않는 부분의 코드를 분리한다.

- 변경되는 부분을 인터페이스로 추출한다.

- 인터페이스에 대한 구현체를 익명 클래스(anonymous class)로 구현해 메소드의 인자로 전달한다.

- - 구글에서 자바의 익명 클래스로 검색해 익명 클래스가 무엇인지 학습한다.

- 

- 인터페이스는 다음과 같은 형태로 추출할 수 있다. 



## Stream 메소드 실습

rc/main/resources/fp 디렉토리 아래에 있는 war-and-peace.txt 파일을 읽어 다음 요구사항을 만족하세요.



## map, reduce, filter 실습 1

List에 담긴 모든 숫자 중 3보다 큰 숫자를 2배 한 후 모든 값의 합을 구한다. 지금까지 학습한 map, reduce, filter를 활용해 구현해야 한다.

- nextstep.fp.StreamStudyTest 클래스의 sumOverThreeAndDouble() 테스트를 pass해야 한다.



## map, reduce, filter 실습 2

nextstep.fp.StreamStudy 클래스의 printLongestWordTop100() 메서드를 구현한다. 요구사항은 다음과 같다.

- 단어의 길이가 12자를 초과하는 단어를 추출한다.
- 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다.
- 단어 중복을 허용하지 않는다. 즉, 서로 다른 단어 100개를 추출해야 한다.
- 추출한 100개의 단어를 출력한다. 모든 단어는 소문자로 출력해야 한다.



## 힌트

- 단어의 길이가 12자를 초과하는 단어를 추출한다.

- 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다.

- - sorted() method 활용

- 

- 단어 중복을 허용하지 않는다. 즉, 서로 다른 단어 100개를 추출해야 한다.

- - distinct() method 활용

- 

- 추출한 100개의 단어를 출력한다. 모든 단어는 소문자로 출력해야 한다.

- - String.toLowerCase() method 활용

  

## Optional

## 요구사항 1 - Optional을 활용해 조건에 따른 반환

nextstep.optional.User의 ageIsInRange1() 메소드는 30살 이상, 45살 이하에 해당하는 User가 존재하는 경우 true를 반환하는 메소드이다.

같은 기능을 Optional을 활용해 ageIsInRange2() 메소드에 구현한다. 메소드 인자로 받은 User를 Optional로 생성하면 stream의 map, filter와 같은 메소드를 사용하는 것이 가능하다.

nextstep.optional.UserTest의 테스트가 모두 pass해야 한다.



## 힌트

- [Guide To Java 8 Optional](http://www.baeldung.com/java-optional) 문서를 참고해 Optional 사용 방법을 익힌다.
- Optional.ofNullable(user)을 활용해 User을 Optional로 생성하는 것이 가능하다.
- Optional의 map(), filter() 메소드등을 활용해 필요한 데이터를 추출
- Optional의 isPresent() 메소드 활용



## 요구사항 2 - Optional에서 값을 반환

nextstep.optional.Users의 getUser() 메소드를 자바 8의 stream과 Optional을 활용해 구현한다.

자바 8의 stream과 Optional을 사용하도록 리팩토링한 후 UsersTest의 단위 테스트가 통과해야 한다.



## 힌트

- [Guide To Java 8 Optional](http://www.baeldung.com/java-optional) 문서를 참고해 Optional 사용 방법을 익힌다.
- Optional의 orElse() 메소드 활용해 구현한다.



## 요구사항 3 - Optional에서 exception 처리

nextstep.optional.ExpressionTest의 테스트가 통과하도록 Expression의 of 메소드를 구현한다.

단, of 메소드를 구현할 때 자바 8의 stream을 기반으로 구현한다.



## 힌트

- [Guide To Java 8 Optional](http://www.baeldung.com/java-optional) 문서를 참고해 Optional 사용 방법을 익힌다.
- 자바의 enum 전체 값은 values() 메소드를 통해 배열로 접근 가능하다.
- Arrays.stream()을 이용해 배열을 stream으로 생성할 수 있다.
- 일치하는 값 하나를 추출할 때 findFirst() 메소드를 활용 가능하다.
- Optional의 orElseThrow() 메소드 활용해 구현한다.





## 2단계 사다리(생성)

## 기능 요구사항

- 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.

- 사람 이름은 쉼표(,)를 기준으로 구분한다.

- 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.

- 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.

- - |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.



## 프로그래밍 요구사항

- **자바 8의 스트림과 람다를 적용해 프로그래밍한다.**
- **규칙 6: 모든 엔티티를 작게 유지한다.** 



## 3단계 - 사다리(게임 실행)

## 기능 요구사항

- 사다리 실행 결과를 출력해야 한다.
- 개인별 이름을 입력하면 개인별 결과를 출력하고, "all"을 입력하면 전체 참여자의 실행 결과를 출력한다.

## 프로그래밍 요구사항

- 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
- 규칙 6: 모든 엔티티를 작게 유지한다.
- **규칙 7: 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.**