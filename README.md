# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)
***

# 1단계 - 자바8 스트림, 람다, Optional

## 기능 정의
* Lambda
  - [x] CarTest 익명 클래스를 람다식으로 변경
  - [x] Lambda 람다를 활용해 중복 제거
* Stream
  - [x] sumOverThreeAndDouble 테스트 패스
  - [x] printLongestWordTop100 구현
* Optional
  - [x] Optional을 활용해 조건에 따른 반환
  - [x] Optional에서 값을 반환
  - [x] Optional에서 exception 처리
  - [x] Optional에서 타입 변경

***

# 2단계 - 사다리(생성)

## 기능 정의

* 사다리
  - [x] 참여인원의 이름은 최대 5글자로 제한
  - [ ] 참여인원의 이름은 콤마(,)로 구분
  - [ ] 사다리의 라인은 연속될 수 없다
* 화면
  - [ ] 참여인원의 이름을 입력 받는다
  - [ ] 사다리 출력시 이름 출력 후 사다리 출력