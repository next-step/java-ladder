# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## Step1 스트림, 람다, Optional
### 람다 실습 1 : 익명 클래스를 람다로 전환
- CarTest의 MoveStrategy에 대한 익명 클래스 구현부를 람다로 적용

### 람다 실습 2 : 람다를 활용해 중복 제거
- `nextstep.fp.Lamda`의 `sumAll`, `sumAllEven`, `sumAllOverThree` 메서드 리팩토링

### 스트림(Stream) map, reduce, filter 실습 1
- `nextstep.fp.StreamStudyTest#sumOverThreeAndDouble` 메서드의 테스트가 성공하도록 처리

### 스트림(Stream) map, reduce, filter 실습 2
- `nextstep.fp.StreamStudy#printLongestWordTop100()` 메서드 구현

### Optional 실습 1
- `User#ageIsInRange2` 메서드에 Optional을 활용해 `30살 이상, 45살 이하에 해당하는 User인 경우 true 반환` 기능 구현