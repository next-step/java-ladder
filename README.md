# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## 구현할 기능 목록
### 🚀 1단계 - 스트림, 람다, Optional
> **요구사항**
> - 람다 실습 
>   - 1 : `MoveStrategy`에 대한 익명 클래스를 람다로 전환
>   - 2 : 람다를 활용해 `nextstep.fp.Lambda`의 `sumAll`, `sumAllEven`, `sumAllOverThree` method 중복 제거
> - 스트림 실습
>   - 1 : `nextstep.fp.StreamStudyTest` 클래스의 `sumOverThreeAndDouble()` 테스트를 pass해야 한다.
>   - 2 : `nextstep.fp.StreamStudy` 클래스의 `printLongestWordTop100()` 메서드를 구현한다. 요구사항은 다음과 같다. 
>     - 단어의 길이가 12자를 초과하는 단어를 추출한다. 
>     - 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다. 
>     - 단어 중복을 허용하지 않는다. 즉, 서로 다른 단어 100개를 추출해야 한다. 
>     - 추출한 100개의 단어를 출력한다. 모든 단어는 소문자로 출력해야 한다.
> - Optional 실습
>   - 1 : Optional을 활용해 조건에 따른 반환
>     - `ageIsInRange1()` 메소드와 같은 기능을 `Optional`을 활용해 `ageIsInRange2()` 메소드에 구현
>   - 2 : Optional에서 값을 반환
>     - `nextstep.optional.Users`의 `getUser()` 메소드를 자바 8의 stream과 Optional을 활용해 구현
>   - 3 : Optional에서 exception 처리
>     - 자바 8의 stream을 기반으로 `nextstep.optional.ExpressionTest`의 테스트가 통과하도록 `Expression`의 `of` 메소드를 구현

구현 목록
- 람다 실습
  - [x] 실습 1
  - [x] 실습 2
- 스트림 실습
  - [x] 실습 1
  - [x] 실습 2
- Optional 실습
  - [x] 실습 1
  - [x] 실습 2
  - [x] 실습 3
