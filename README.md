# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## 1단계
- [x] 람다
  - [x] 실습 1
  - [x] 실습 2
- [x] 스트림
  - [x] map, reduce, filter 실습 1
  - [x] map, reduce, filter 실습 2
- [x] Optional
  - [x] Optional을 활용해 조건에 따른 반환
  - [x] Optional에서 값을 반환
  - [x] Optional에서 exception 처리
## 2단계
- [x] LadderLine 구현
- [x] LadderLineGenerator 구현
- [x] LadderGame, Ladder 구현
- [x] Players 구현
- [x] Views 구현
- [x] LadderGameApplication 구현
- [x] 리팩토링
  - [x] Player 구현
  - [x] Views 리팩토링
    - [x] LottoGameApplication 에서 메소드 분리
    - [x] ResultView 기능 단위로 메소드 분리
  - [x] Height 구현
- [x] 피드백
  - [x] Player
    - [x] 상수 추가
    - [x] isEmpty / isBlank 선택
  - [x] LadderLineGenerator
    - [x] 상수 추가
    - [x] 테스트 편의 위해 인터페이스 도입
  - [x] Ladder
    - [x] LadderLine 리스트 반환 메소드 추가 
  - [x] LadderLine
    - [x] is -> has
    - [x] 조건문 통합
## 3단계
- [ ] 사다리 게임 결과 표시
  - [x] LadderGame에 결과 추가
  - [x] Ladder에서 사다리 진행 결과 확인
  - [x] LadderGame에서 사다리 게임 실행
    - [ ] 리팩토링
      - [x] Position 구현
      - [x] setPosition 제거
      - [ ] LadderGameResult.getResultFor 리팩토링