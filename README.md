# 사다리 게임

## STEP2 사다리 생성

### 기능 요구사항

 * [x] 사다리 게임에 참여하는 사람에 이름을 최대5글자
   * [x] 이름 클래스에서 길이 검증
   * [x] 이름을 갖고 있는 플레이어
       * [x] 플레이의 수~~(=레일의 수)~~는 2보다 커야함. (사다리를 구성해야하므로)
       * [x] 플레이어들의 일급 컬랙션
   * [ ] 플레이어 수를 나태내는 클래스
   * [x] ~~플레이어 만큼의 레일(사다리의 세로)~~
   * [x] 레일들을 갖고 있는 사다리
       * [x] ~~레일~~사다리의 높이는 0보다 커야 함
       * [x] 사다리 생성시 레일에 가로 라인이 있는 지점을 지정
       * [x] 가로 라인이 있는 지점을 정하는 방법을 전략패턴으로 분리
   * [x] 사다리의 높이 만큼의 라인들(사다리의 가로)
     * 사다리의 세로가 갖고 있는 정보는 공통이거나(높이) 중복됨(플레이어)
     * 개념적으론 사다리가 레일 객체들을 들고있는것이 자연스럽지만, 로직상으로는 라인을 객체로 만드는 것이 자연스러움
     * [ ] 사다리의 가로 라인이 겹치지 않아야 함
 * [x] 입력받은 사람수와 높이로 사다리를 생성
 * [x] 사다리를 출력할 때 사람 이름도 같이 출력
 * [ ] 사라리를 출력
 * [ ] 사람 이름은 쉼표(,)를 기준으로 구분
 * [ ] 사다리 폭은 사람 이름 길이인 5자보다 넓어야함
   * [ ] 가로 길이는 view에서 결정

### 프로그래밍 요구사항

 * 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
 * 규칙 6: 모든 엔티티를 작게 유지한다.

## STEP1  자바8 스트림, 람다, Optional

### Lambda
* [x] CarTest 테스트 코드에서 MoveStrategy의 구현을 람다를 적용해 구현
* [x] 람다를 활용해 중복 제거
  * [x] nextstep.fp.Lambda#sumAll
  * [x] nextstep.fp.Lambda#sumAllEven
  * [x] nextstep.fp.Lambda#sumAllOverThree

### Stream
* [x] List에 담긴 모든 숫자 중 3보다 큰 숫자를 2배 한 후 모든 값의 합 구현
* [x] nextstep.fp.StreamStudy 클래스의 printLongestWordTop100() 메서드를 구현
  * [x] 단어의 길이가 12자를 초과하는 단어를 추출
  * [x] 길이가 긴 순서로 추출
  * [x] 서로 다른 단어 100개를 추출
  * [x] 모든 단어는 소문자로 출력

### Optional
* [x] nextstep.optional.User#ageIsInRange2() 메소드를 Optional을 활요해 구현
* [x] nextstep.optional.User#getUser() 메소드를 Optional을 활요해 구현
* [x] nextstep.optional.Expression#of 메소드를 구현
* [x] nextstep.optional.ComputerStoreTest 테스트를 통과하도록 수정

## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)