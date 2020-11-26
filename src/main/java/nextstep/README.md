### 다양한 stream method 실습
> src/main/resources/fp 디렉토리 아래 있는 war-and-peace.txt 파일을 읽어
> 다음 요구사항을 만족하세요.

**map, reduce, filter 실습 1**

List에 담긴 모든 숫자 중 3보다 큰 숫자를 2배한 후 모든 값의 합을 구한다.
지금까지 학습한 map, reduce, filter를 활용해서 구해야 한다.
- nuextstep.fp.StreamStudyTest 클래스의 sumOverThreeAndDouble() 테스트를 pass해야한다.

**map, reduce, filter 실습 2**

nextstep.fp.StreamStudy 클래스의 printLongestWordTop100() 메서드를 구현한다.

- 단어의 길이가 12자를 초과하는 단어를 추출한다.
- 12자가 넘는 단어중 길이가 긴 순서로 100개의 단어를 추출한다.
- 단어 중복을 허용하지 않는다. 즉 , 서로 다른 단어 100개를 추출해야 한다.
- 추출한 100개의 단어를 출력한다. 모든 단어는 소문자로 출력해야 한다.

#### 힌트
- 단어의 길이가 12자를 초과하는 단어를 추출한다.
- 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다.
    - sorted() method 활용
- 단어 중복을 허용하지 않는다. 즉, 서로 다른 단어 100개를 추출해야 한다.
    - distinct() method 활용
- 추출한 100개의 단어를 출력한다. 모든 단어는 소문자로 출력해야 한다.
    - String.toLowerCase() method 활용


#### Optional
- 요구사항 1 -Optional을 활용해 조건에 따른 반환

> nextstep.optional.User 의 ageIsInRange1() 메소드는 30살 이상, 45살 이하에 해당하는
> User가 존재하는 경우 true를 반환하는 메소드이다.
>
> 같은 기능을 Optional을 활용해 ageIsInRange2() 메소드에 구현한다. 메소드 인자로 받은 User를 
> Optional로 생성하면 stream의 map filter와 같은 메소드를 사용하는 것이 가능하다.
>
> nextstep.optional.UserTest의 테스트가 모두 pass 해야한다.

**힌트**
- Guide To Java 8 Optional 문서를 참고해 Optional 사용 방법을 익힌다.
- Optional.ofNullable(user)을 활용해 User을 Optional로 생성하는 것이 가능하다.
- Optional의 map(), filter() 메소드등을 활용해 필요한 데이터를 추출
- Optional의 isPresent() 메소드 활용

#### 요구사항 2 - Optional에서 값을 반환
> nextstep.optional.Users의 getUser() 메소드를 자바 8의 stream과 Optional을 활용해 구현한다.
>
> 자바 8의 stream과 Optional을 사용하도록 리팩토링 한 후 UsersTest의 단위 테스트가 통과해야한다.

**힌트**
- [Guide To Java 8 Optional](https://www.baeldung.com/java-optional)문서를 참고해 Optional 사용 방법을 익힌다.
- Optional의 orElse() 메소드를 활용해 구현한다.

#### 요구사항 3 - Optional에서 exception 처리
> nextstep.optional.ExpressionTest의 테스트가 통과하도록 Expression의 of 메소드를 구현한다.
>
> 단, of 메소드를 구현할 때 자바 8의 stream을 기반으로 구현한다.

**힌트**
- [Guide To Java 8 Optional](https://www.baeldung.com/java-optional)문서를 참고해 Optional 사용 방법을 익힌다.
- 자바의 enum 전체값은 values() 메소드를 통해 배열로 접근이 가능하다.
- Arrays.stream()을 이용해 배열을 stream으로 생성할 수 있다.
- 일치하는 값 하나를 추출할 때 findFirst() 메소드를 활용 가능하다.
- Optional의 orElseThrow() 메소드를 활용해 구현한다.

