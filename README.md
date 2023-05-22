# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## 2단계 - 사다리(생성) 기능 요구사항
- 도메인
  - Player
    - [x] 사다리 게임에 참여하는 사람들의 이름을 받아서 멤버들을 생성할 수 있다.
    - [x] 참여하는 사람의 이름이 5글자가 넘어가면 예외를 던진다.
  - LadderRow
    - [ ] 주어진 width만큼의 line 생성 여부를 LineStrategy 에 따라 결정한다.
    - [ ] 단, 연달아 line을 생성하지 않는다.
  - Ladder
    - [ ] 요청받은 사다리 높이(height)만큼 사다리를 만들 수 있다.
