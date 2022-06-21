# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

* 프로젝트 기능
* domain
  * LadderGame
    * Participants participants
    * LadderInfo ladderInfo
  * LadderInfo
    * int height
    * int numberOfParticipants
    * Lines lines
  * Lines
    * List<Line> lines
  * Line
    * Variables
      * List<Point> points
    * Functions
      * makePoints() : edge(가로선) 생성
  * Point
    * Variables
      * boolean linked
    * Functions
      * Point randomLink(...) : 좌우 가로선에 따라 가로선 랜덤 생성 
  * Participants
    * Variables
      * List<Participant> participants
  * Participant
    * Variables
      * String name
* view
  * InputView
    * inputParticipants : 참가자 이름 입력
    * inputLadderHeight : 사다리 높이 입력
  * ResultView
    * printResult : 실행결과 출력
    * printParticipants : 참가자 이름 출력
* exceptions
  * ExceededMaxLengthException
