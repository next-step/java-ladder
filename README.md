# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## TO DO LIST(Step1)
- [x] CarTest에서 MoveStrategy에 대한 익명 클래스를 람다로 전환
- [x] fp.Lambda에서 람다를 활용해 중복 제거
- [x] fp.StreamStudy 수정
  - [x] sumOverThreeAndDouble 메소드를 stream 메소드를 활용하여 구현
  - [x] printLongestWordTop100 메소드를 stream 메소드를 활용하여 구현
- [x] optional.User.ageIsInRange1 기능을 optional을 활용하여 ageIsInRange2에 구현
- [x] optional.Users.getUser 메소드를 stream과 optional을 활용하여 구현
- [x] optional.Expression.of 메소드를 stream과 optional을 활용하여 구현

## TO DO LIST(Step2)
- [X] Name 클래스 추가
  - [x] 검증 메소드 추가
- [x] Point 클래스 추가
  - [x] 검증 메소드 추가
  - [x] 연결 여부 확인 메소드 추가
- [x] Line 클래스 추가
  - [x] 연결 메소드 추가
- [x] LinkStrategy 클래스 추가
  - [x] RandomLinkStrategy 클래스 추가
- [x] Ladder 클래스 추가
  - [x] 참여자 이름 입력 값을 Name 객체 리스트로 변환하는 메소드 추가
  - [x] 사다리 높이 입력 값에 따라 Point 객체 리스트를 생성하는 메소드 추가
  - [x] 사다리를 그려주는 메소드 추가
- [x] InputView 클래스 추가
- [x] OutputView 클래스 추가
- [x] LadderApplication 클래스 추가

## TO DO LIST(Step3)
- [x] InputView 클래스 수정
  - [x] 사다리 타기 결과 입력 메소드 추가
  - [x] 결과 확인 입력 메소드 추가
- [x] OutputView 클래스 수정
  - [x] 사다리 결과에 실행 결과 출력 추가
  - [x] 단일 결과 출력 메소드 추가
  - [x] 전체 결과 출력 메소드 추가
- [x] Prize 클래스 추가
- [x] Ladder 클래스 수정
  - [x] 실행 결과 필드 추가
  - [x] 결과 계산 메소드 추가
- [x] Line 클래스 수정
  - [x] 이동 메소드 추가
- [x] LadderApplication 클래스 수정
