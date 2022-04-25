# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

### step 1. 자바8 스트림, 람다, Optional
1. 람다 - 익명 클래스를 람다로 변환
2. 람다 - 람다를 활용해 중복 제거
   1. List 에 담긴 값 중 3보다 큰 수만을 더해야 한다.
   2. suAll, sumAllEven, sumAllOverThree method 소스 코드를 확인하고 중복 제거!
3. 스트림 - map, reduce, filter 실습 1
   1. List 에 담긴 모든 숫자 중 3보다 큰 숫자를 2배 한 후 모든 값의 합을 구함
      1. 학습한 map, reduce, filter 를 활용
4. 스트림 - map, reduce, filter 실습 2
   1. nextstep.fp.StreamStudy 클래스의 printLongestWordTop100() 메서드를 구현
      1. 단어의 길이가 12자를 초과하는 단어 추출
      2. 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어 추출
      3. 단어 중복을 허용하지 않음. -> 서로 다른 단어 100개 추출
      4. 추출한 100개의 단어를 출력. -> 모든 단어는 소문자로 출력
5. Optional
   1. nextstep.optional.User 의 ageIsInRange1() 메서드를 Optional 을 활용해 ageIsInRange2() 메소드로 구현
      1. nextstep.optional.UserTest 의 테스트가 모두 pass 해야 한다.
   2. nextstep.optional.Users 의 getUser() 메서드를 stream 과 Optional 을 활용해 구현
      1. 자바 8 stream 과 Optional 을 사용하도록 리팩토링한 후에 UsersTest 의 단위 테스트 통과
   3. nextstep.optional.ExpressionTest 의 테스트가 통과하다록 Expression 의 of 메서드를 구현
   4. of 메서드를 구현할 때 자바 88의 stream 을 기반으로 구현

### step 2. 사다리(생성)
0. refactoring list
   1. sumAll, sumAllEven, sumAllOverThree 다시 구현하기
   2. @FunctionalInterface 사용하기! (제약)
      1. https://zzang9ha.tistory.com/303
   3. 클래스 내부의 상수 접근제한자 private 으로 수정
   4. 불필요한 import 줄이기
      1. https://milenote.tistory.com/25
   5. findFirst & findAny 의 차이점 인지하기
      1. https://codechacha.com/ko/java8-stream-difference-findany-findfirst/
   6. 정렬 실수 (현재: 작은 순서부터되어 있음, 수정: 긴 순서부터 출력되도록)
   7. map 을 통해 age 를 가져온 후에 필터 처리..!
   8. `ofNullable 자체가 null 에 대해 안정성을 보장하기 때문에 null 검증은 필요하지 않다!`