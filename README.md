# 사다리 게임

## Step1 > Stream, Lambda, Optional
### 세부 구현 사항
- [x] 익명 클래스를 람다로 전환한다.
- [x] 공통되는 부분을 함수형 인터페이스로 추출하여 익명 클래스로 구현한다.
- 학습한 map, reduce, filter를 활용해 아래 문제를 해결한다.
  - [x] `nextstep.fp.StreamStudyTest` 클래스의 `sumOverThreeAndDouble()` 테스트를 통과한다.
  - [x] `nextstep.fp.StreamStudy` 클래스의 `printLongestWordTop100()` 메서드를 구현한다.
- 자바 8의 stream과 Optional을 활용해 아래 문제를 해결한다. 
  - [x] `nextstep.optional.User`의 `ageIsInRange2()` 메서드 테스트를 통과한다.
  - [x] `nextstep.optional.Users`의 `getUser()` 메서드 테스트를 통과한다.
  - [x] `nextstep.optional.Expression`의 `of()` 메서드 테스트를 통과한다.

> 알게된 내용
> - `Stream`의 `findAny()` 메서드가 `Optional` 객체를 반환한다.
> - `Optional.ofNullable()`로 감싸고 나서 `filter()` 메서드로 조건절 체크를 할 수 있다.
> - `reduce()` : 스트림의 원소들에 대해 reduction을 수행한다.

## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)
