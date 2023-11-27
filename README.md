# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

----

# Step1
## Requirements

- [x] 익명 클래스를 람다로 전환한다.
  - [x] MoveStrategy에 대한 익명 클래스로 구현하고 있는 테스트를 람다를 적용한다.
- [x] 람다를 활용해 중복 제거
  - [x] LambdaTest에 있는 테스트들의 중복을 제거한다.
    - [x] sumAll(), sumAllEven(), sumAllOverThree()의 소스를 확인 후 중복제거한다.
      - [x] 변경되는 부분과 변경되지 않는 부분의 코드를 분리한다.
      - [x] 변경되는 부분을 인터페이스로 추출한다.
      - [x] 인터페이스에 대한 구현체를 익명클래스로 구현해 메소드의 인자로 전달하며 익명클래스는 람다를 활용해 구현한다.
- [x] 스트림 method 실습
  - [x] StreamStudyTest에 있는 테스트를 스트림으로 구현한다.
    - [x] sumOverThreeAndDouble 테스트를 통과해야한다.
    - [x] printLongestWordTop100 메서드를 구현해야한다.
      - [x] 단어의 길이가 12자를 초과하는 단어이여야한다.
      - [x] 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다.
      - [x] 단어 중복을 허용하지 않는다.
      - [x] 추출한 100개의 단어를 출력해야하고 모든 문자는 소문자이여야한다.
- [x] Optional을 활용해 조건에 따른 값을 반환한다.
  - [x] User의 ageIsInRange2()는 ageIsInRange1()과 결과는 같지만 메소드인자로 User를 Optional로 넘겨받는다.
    - [x] Stream의 map, filter와 같은 메소드를 사용해 구현한다.
  - [x] User의 getUser() 메소드를 stream과 Optional을 활용해 구현한다.
  - [x] ExpressionTest의 테스트가 통과가능하도록 of 메서드를 구현한다. 이때, stream을 활용한다.