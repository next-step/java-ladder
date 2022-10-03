# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

# 람다, 스트림, Optional
## 기능 및 프로그래밍 요구사항
* [ ] CarTest의 익명 클래스를 람다로 전환한다.
* [ ] LambdaTest의 중복을 람다를 사용해 제거한다.
  * List의 담긴 값 중 3보다 큰 수만을 더해야 한다.
  * [ ] 변경되는 부분과, 변경되지 않는 부분의 코드를 분리한다. 
  * [ ] 변경되는 부분을 인터페이스로 추출하고, 구현체를 람다를 사용해 익명 클래스로 구현한다. 
* [ ] StreamStudyTest에서 map, reduce, filter를 실습한다.
  * [ ] List에 담긴 모든 숫자 중 3보다 큰 숫자를 2배한 후 총합을 구한다. map, reduce, filter를 사용한다.
  * [ ] printLongestWordTop100() 메서드를 구현한다.
    * [ ] 단어의 길이가 12자를 초과하는 단어를 추출한다.
    * [ ] 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다.
    * [ ] 단어 중복을 허용하지 않는다. 즉, 서로 다른 단어 100개를 추출해야 한다.
    * [ ] 추출한 100개의 단어를 출력한다. 모든 단어는 소문자로 출력해야 한다.
* [ ] Optional 
  * [ ] Optional을 사용해 ageIsInRange2()를 구현한다.
    * User의 ageIsInRange1() 메소드는 30살 이상, 45살 이하에 해당하는 User가 존재하는 경우 true를 반환하는 메소드이다.
    * 메소드 인자로 받은 User를 Optional로 생성하면 stream의 map, filter와 같은 메소드를 사용하는 것이 가능하다.
    * Optional.ofNullable(user)을 활용해 User을 Optional로 생성하는 것이 가능하다.
    * Optional의 map(), filter() 메소드등을 활용해 필요한 데이터를 추출
    * Optional의 isPresent() 메소드 활용
  * [ ] Users의 getUser() 메소드를 자바 8의 stream과 Optional을 활용해 구현한다.
    *  Optional의 orElse() 메소드 활용해 구현한다.
  * [ ] Expression의 of 메소드를 Stream을 사용해 구현한다. 
    * Optional의 orElseThrow() 메소드 활용해 구현한다.
    * 일치하는 값 하나를 추출할 때 findFirst() 메소드를 활용 가능하다.
  * [ ] UserTest의 테스트가 모두 pass해야 한다.
