# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## Step2 
### 기능 요구사항
* 사다리 게임에 참여하는 사람의 이름은 최대 5글자이며, 사다리 출력 시 이름도 같이 출력한다. 
* 사람 이름은 쉼표(,)로 구분한다. 
* 사다리 타기의 라인이 겹치지 않도록 해야 한다. 
### 기능 구현 
* UI
  * 참여할 사람 이름 입력받기 : InputView
  * 최대 사다리 높이 입력받기 : InputView
  * 사다리 출력하기 : ResultView
* Domain
  * 사다리 게임 진행하기 : LadderGame
  * 사다리게임 참가자들 : Participants
  * 사다리 구조 : Ladder
  * 사다리 가로선 : Line
  * 사다리 생성 : LadderGenerator

## Step3
### 기능 요구사항
* 사다리 실행 결과를 출력해야 한다.
* 개인별 이름을 입력하면 개인별 결과를 출력하고, "all"을 입력하면 전체 참여자의 실행 결과를 출력한다. 
### 기능 구현
* UI
  * 사다리 실행 결과 입력받기 : InputView 
  * 사다리 실행 결과 출력하기 : ResultView
* Domain
  * 사다리를 실행하기 : LadderExecutor
  * 사다리 결과 저장 : Results

