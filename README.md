# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## 사다리 미션 요구사항
- Domain
  - [X] 가로라인을 담당하는 클래스(Line)의 구현
     - [X] 라인이 겹침방지 기능 구현
  - [X] 가로라인 여러개를 담당하는 일급콜렉션(Ladder)의 구현
- View
  - [X] 입력 클래스(InputView) 구현
     - [X] 사람 이름 입력 기능 구현
     - [X] 사람 이름 쉼표(,)를 기준으로 구분 기능 구현
  - [X] 출력 클래스(ResultView) 구현
     - [X] 사다리와 사람 이름 출력 기능 구현
- Controller
  - [X] 입력과 출력을 제어하는 클래스(LadderGameController)의 구현 
