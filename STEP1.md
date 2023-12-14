
## step1 기능분해
### lambda
* [X] MoveStrategy-> CarTest 익명 클래스 람다로 전환
* [X] Lambda.sumAll 메소드 람다를 활용해
* [X] Lambda.sumAllEven 메소드 람다로 전환
* [X] Lambda.sumAllOverThree 메소드 람다로 전환
* [X] nextstep.fp.Lambda의 sumAll, sumAllEven, sumAllOverThree method 소스 코드를 확인하고 중복 제거
### Stream
* map, reduce, filter 실습 1
    * [X] List에 담긴 모든 숫자 중 3보다 큰 숫자를 2배 한 후 모든 값의 합을 구한다. 지금까지 학습한 map, reduce, filter를 활용해 구현해야 한다.
    * [X] nextstep.fp.StreamStudyTest 클래스의 sumOverThreeAndDouble() 테스트를 pass해야 한다.
* nextstep.fp.StreamStudy 클래스의 printLongestWordTop100() 메서드를 구현한다. 요구사항은 다음과 같다.
    * [X] 단어의 길이가 12자를 초과하는 단어를 추출한다. -> filter length > 12
    * [X] 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다. -> Sorted(lengths)
    * [X] 단어 중복을 허용하지 않는다. 즉, 서로 다른 단어 100개를 추출해야 한다. -> string 이라서 distinct 필요 , limit
    * [X] 추출한 100개의 단어를 출력한다. 모든 단어는 소문자로 출력해야 한다. -> toLowerCases
### Optional
* 요구사항 1 - Optional을 활용해 조건에 따른 반환
* nextstep.optional.User의 ageIsInRange1() 메소드는 30살 이상, 45살 이하에 해당하는 User가 존재하는 경우 true를 반환하는 메소드이다.
* [X] 같은 기능을 Optional을 활용해 ageIsInRange2() 메소드에 구현한다. 메소드 인자로 받은 User를 Optional로 생성하면 stream의 map, filter와 같은 메소드를 사용하는 것이 가능하다.
* [X] nextstep.optional.UserTest의 테스트가 모두 pass해야 한다.
* 요구사항 2 - Optional에서 값을 반환
* [X] nextstep.optional.Users의 getUser() 메소드를 자바 8의 stream과 Optional을 활용해 구현한다.
* [X] 자바 8의 stream과 Optional을 사용하도록 리팩토링한 후 UsersTest의 단위 테스트가 통과해야 한다.
* 요구사항 3 - Optional에서 exception 처리
* [X] nextstep.optional.ExpressionTest의 테스트가 통과하도록 Expression의 of 메소드를 구현한다.
* [X] 단, of 메소드를 구현할 때 자바 8의 stream을 기반으로 구현한다.

## step1 추가보완사항
* [X] @FunctionalInterface 활용
