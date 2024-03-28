# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

---
## Step1 스트림, 람다, Optional
### 람다 실습 1 : 익명 클래스를 람다로 전환
- CarTest의 MoveStrategy에 대한 익명 클래스 구현부를 람다로 적용

### 람다 실습 2 : 람다를 활용해 중복 제거
- `nextstep.fp.Lamda`의 `sumAll`, `sumAllEven`, `sumAllOverThree` 메서드 리팩토링

### 스트림(Stream) map, reduce, filter 실습 1
- `nextstep.fp.StreamStudyTest#sumOverThreeAndDouble` 메서드의 테스트가 성공하도록 처리

### 스트림(Stream) map, reduce, filter 실습 2
- `nextstep.fp.StreamStudy#printLongestWordTop100()` 메서드 구현

### Optional 실습 1 - Optional을 활용해 조건에 따른 반환
- `User#ageIsInRange2` 메서드에 Optional을 활용해 `30살 이상, 45살 이하에 해당하는 User인 경우 true 반환` 기능 구현

### Optional 실습 2 - Optional에서 값을 반환
- `getUser()` 메서드를 stream과 Optional을 활용해 반환하도록 처리

### Optional 실습 3 - Optional에서 exception 처리
- `ExpressionTest`의 테스트가 통과하도록 of 메서드 구현

---
## Step2 사다리 생성
### 1. 기능 요구사항
- 사다리 게임에 참여하는 사람들의 이름을 입력받는다.
  - 사람 이름은 최대 5글자
  - ','를 기준으로 입력 받는다.
- 최대 사다리 높이를 입력받는다.
  - 사다리 높이가 0인 경우, 게임을 진행할 수 없으므로 종료시킨다.
- 사다리 생성
  - 입력 받은 사다리 높이 만큼 생성되어야 한다
  - 입력 받은 사람들의 이름 중 최대 길이에 맞춰 사다리 폭이 조정되어야 한다.
  - 사다리의 발판(?)은 연속해서 등장해서는 안된다.

### 2. 프로그래밍 요구사항
- `Stream`과 `Lambda`를 적용한다.
- 모든 엔티티를 작게 유지한다.