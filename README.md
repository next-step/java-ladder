# 사다리 게임

<!-- TOC -->

* [사다리 게임](#사다리-게임)
  * [진행 방법](#진행-방법)
  * [온라인 코드 리뷰 과정](#온라인-코드-리뷰-과정)
  * [Step1](#step1)
    * [요구사항](#요구사항)
    * [기능목록](#기능목록)
    * [23.11.19 추가 피드백 사항](#231119-추가-피드백-사항)
  * [Step2](#step2)
    * [프로그래밍 요구사항](#프로그래밍-요구사항)
    * [기능목록](#기능목록-1)

<!-- TOC -->

## 진행 방법

* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

---

## Step1

### 요구사항

- Lambda, Stream, Optional을 연습하자.

### 기능목록

- [X] ~~Lambda 실습 1~~
- [X] ~~Lambda 실습 2~~
- [X] ~~map, reduce, filter 실습 1~~
- [X] ~~map, reduce, filter 실습 2~~
- [X] ~~Optional 요구사항 1 - Optional을 활용해 조건에 따른 반환~~
- [X] ~~Optional 요구사항 2 - Optional에서 값을 반환~~
- [X] ~~Optional 요구사항 3 - Optional에서 exception 처리~~

### 23.11.19 추가 피드백 사항

- [X] ~~Lambda.java에서 프로덕션 코드에 있는 sumAll, sumAllEven, sumAllOverThree 코드에서 새로 만드신 sumAll 과 람다를 활용하도록 리팩터링하고,
  기존에 있던 LambdaTest 코드를 통해 기존과 동일하게 동작하는지 검증~~
- [X] ~~StreamStudy.java에서 String::toLowerCase를 호출 후 distinct() 호출로 로직 변경~~
- [X] ~~User.java에서 filter를 반복해서 사용하기보다 map 함수를 이용하도록 로직 변경~~

---

## Step2

### 프로그래밍 요구사항

- 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
- 규칙 6: 모든 엔티티를 작게 유지한다.

### 기능목록

- 사람 이름 입력
  - [ ] 사람 이름 입력 받기
  - [ ] 쉼표(,)를 기준으로 구분한다.
  - [ ] 사람 이름은 최대 5글자 까지만 허용한다.
- 사다리 높이 입력
  - [ ] 사다리 높이 입력 받기
- 사다리 출력
  - [ ] 사다리를 출력한다.
  - [ ] 사람 이름도 같이 출력한다.
  - [ ] 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 이에 맞춰야 한다.
- 사다리 제작
  - [ ] 사다리 타기가 정상적으로 되기 위해서는 라인이 겹치지 않도록 해야 한다.
    - `|-----|-----|` 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.
