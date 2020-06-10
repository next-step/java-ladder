# Step1

* 람다 실습
  * CarTest 내부의 익명 클래스 사용 부분을 람다로 변경
  * nextstep.fp.Lambda의 sumAll, sumAllEven, sumAllOverThree method 소스 코드에서 중복을 제거 (람다를 활용)
  * 변경되는 부분을 인터페이스로 추출한다
* 스트림 실습
  * nextstep.fp.StreamStudyTest 클래스의 sumOverThreeAndDouble() 테스트를 pass해야 한다.
  * nextstep.fp.StreamStudy 클래스의 printLongestWordTop100() 메서드를 구현한다. 요구사항은 다음과 같다.
     * 단어의 길이가 12자를 초과하는 단어를 추출한다.
     * 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다.
     * 단어 중복을 허용하지 않는다. 즉, 서로 다른 단어 100개를 추출해야 한다.
     * 추출한 100개의 단어를 출력한다. 모든 단어는 소문자로 출력해야 한다.
* Optional 실습
  * nextstep.optional.User > ageIsInRange2() 메소드 구현
     * nextstep.optional.UserTest의 테스트가 모두 pass해야 한다.
  * nextstep.optional.Users의 getUser() 메소드를 자바 8의 stream과 Optional을 활용해 구현한다.
  * nextstep.optional.ExpressionTest의 테스트가 통과하도록 Expression의 of 메소드를 구현한다.
  
각 요구사항을 만족한 뒤 힌트와 상세 요구사항을 만족하는지 확인하고 커밋하자
