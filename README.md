# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## STEP01 
### TODO

**람다**
 - [x] 익명 클래스를 람다로 전환한다.
 - [x] 람다를 활용해 중복을 제거한다.

**스트림**
 - [x] map, reduce, filter등 다양한 stream method를 실습해본다.

**Optional**
 - [x] Optional을 활용해 조건에 따라 반환하는 로직을 실습해본다.
 - [x] Optional에서 값을 반환하는 로직을 실습해본다.
 - [x] Optional에서 Exception 처리하는 로직을 실습해본다.
 
 - [x] ComputerStore의 getVersionOptional 로직 완성. (여러 단계의 객체탐색을 if중첩문 -> Optional 체이닝으로 구현)
 
 - **step01 pr :** https://github.com/next-step/java-ladder/pull/555
 ## STEP02
 ### TODO
 - [x] 참여할 사람 이름을 입력 받는다.(이름은 쉼표(,)로 구분)
 - [x] 사람의 이름은 최대 5글자 까지 입력받을 수 있다.
 - [x] 사다리의 폭은 사람 이름의 최대(5자) 기준 이다.
 - [x] 사다리의 라인이 겹치지 않도록 해야 한다. (ex - |-----|-----| 모양과 같으면 어느 방향으로 이동할지 알 수 없음.)
 - [x] 최대 사다리 높이를 입력받는다.
 - [x] 사람 이름과 사다리를 출력한다.
 
 ### Programing needs
  - JAVA8의 스트림과 람다를 적용해 프로그래밍 하기.
  - Entity를 가능한 작게 유지한다.

- **step02 pr :** https://github.com/next-step/java-ladder/pull/563
 ## STEP03
 ### TODO
 - [x] 참여할 사람 & 사다리 높이를 입력받는 로직 사이에 사다리 실행 결과를 입력 받는로직을 추가 한다.
 - [x] 사다리 결과에 실행 결과도 같이 출력한다.
 - [x] 사다리 게임 수행 결과를 보고싶은 사람을 입력 받는다.
 - [ ] 해당하는 사람의 게임 수행 결과를 보여준다.
 - [ ] all 입력시 모든 실행 결과를 보여준다.
 
 ### Programing needs
  - JAVA8의 스트림과 람다를 적용해 프로그래밍 하기.
  - Entity를 가능한 작게 유지한다.
  - 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.