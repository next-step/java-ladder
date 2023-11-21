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
    * [23.11.20 추가 피드백 사항](#231120-추가-피드백-사항)

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
  - [X] ~~사람 이름 입력 받기~~
  - [X] ~~쉼표(,)를 기준으로 구분한다.~~
  - [X] ~~사람 이름은 최대 5글자 까지만 허용한다.~~
- 사다리 높이 입력
  - [X] ~~사다리 높이 입력 받기~~
  - [X] ~~사다리 높이는 1이상의 값을 가진다.~~
- 사다리 만들기
  - [X] ~~사람 이름 및 사다리 높이를 이용해서, 사다리를 만든다.~~
- 사다리 출력
  - [X] ~~사다리 한줄을 출력한다.~~
  - [X] ~~사다리 모든 줄을 출력한다.~~
  - [X] ~~사람 이름도 같이 출력한다.~~
  - [X] ~~사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 이에 맞춰야 한다.~~
- 사다리 제작
  - [X] ~~사다리 타기가 정상적으로 되기 위해서는 라인이 겹치지 않도록 해야 한다.~~
    - `|-----|-----|` 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

### 23.11.20 추가 피드백 사항

> ※ `Domain`
> 1. 다른 의존성에 영향을 받지 않고, 입출력의 형식에 의존하지 않도록 순수하게 유지를 하자.
> 2. 환경이 달라지더라도 도메인은 재사용이 가능하도록 구현하자
> 3. `toString`은 출력 포맷을 맞추기 위한 목적이 아니라, 개발자가 디버깅이나 로그를 남기는 과정에서 활용할 수 있는 형태로 구현하는 것을 추천
> 4. 테스트를 위해 프로덕션 코드를 변경하는 것은 지양하자.

- [X] ~~UserInput에서 사용하는 LadderHeight, UserNames를 Domain 패키지로 이동~~
- [X] ~~input 패키지에서 domain 패키지를 참조하는 방향으로만 의존성이 발생하도록 구현~~
- 출력 형식을 만드는 일은 Formatter 클래스에서 구현
  - [X] ~~Ladder 클래스~~
  - [X] ~~UserNames 클래스~~
- [X] ~~adjustContinuousTrue의 로직 일부 변경~~
- [X] ~~getPoints 메서드 접근제어자 변경~~
- [X] ~~generateLadderPointString 메서드에서 사용하는 5라는 MagicNumber에 의미를 부여하자. (이름의 최대 길이라는 의미 부여 필요)~~
- 출력결과를 미션 내용에 맞춰서 변경 필요
  - [X] ~~UserName 출력 결과 : 왼쪽 정렬 -> 오른쪽 정렬~~
  - [X] ~~사다리를 최대 이름 길이에 맞춰서 이동~~
- [X] ~~사다리 생성 전략의 Class를 IntFunction<Boolean>에서 Supplier<Boolean>으로 변경~~
  - 테스트 코드는 알려준 코드로 변경하기

---

## Step3

### 프로그래밍 요구사항

- Step 2의 프로그래밍 요구사항 유지
- 규칙 7: 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.

### 기능목록

- [X] ~~사다리 결과를 입력~~
- [X] ~~사다리 게임 진행 (어떤 사람이 어떤 결과를 얻게 되었는지)~~
- 사다리 실행 결과를 출력
  - [X] ~~개인별 이름을 입력하면 개인별 결과를 출력~~
  - [X] ~~"all"을 입력하면 전체 참여자의 실행 결과를 출력한다.~~

### 23.11.21 추가 피드백 사항

- [X] move 메서드 내에서 사용되는 private 메서드의 배치를 move 메서드 내에서 사용되는 순서로 변경 <br />
  (클린 코드 책의 "위에서 아래로 코드 읽기: 내려가기 규칙" 챕터를 참고)
- [ ] LadderResult의 field에 private 추가
- [ ] UserResult의 !isSameSize를 부정문으로 표현하기
- [ ] 5글자 이하로 구성되어 있는지 검증하는 부분을 조금 더 가독성 있게 코드 바꾸기
- [ ] 사다리의 각 점(세로줄과 가로줄이 만나는 지점)이 왼쪽/연결 없음/오른쪽 상태를 나타내도록 할 수 있을지 생각해보기
- [ ] Test의 Common 클래스에서 각 메서드를 통해 생성되는 다리의 형태를 한 눈에 들어오도록 표현할 수 있는 방법을 추가 <br />
  (간단한 내용이라면 문서를 통해 빠르게 사용법을 알려주는 것도 좋을 것 같다.)
