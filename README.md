# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

* 프로젝트 기능
* domain
  * LadderGame
    * Variables
      * Participants participants
      * Lines lines
    * Functions
      * String view() : 사다리 String 리턴
      * Participants participants() : 참가자 리스트 리턴
  * Lines
    * Variables
      * List<Line> lines
    * Functions
      * String toLadderLines() : 사다리 String 생성 및 리턴
  * Line
    * Variables
      * List<Edge> edges
    * Functions
      * String toLadderLine() : edge(가로선) 생성
  * Edge
    * Variables
      * boolean linked
    * Functions
      * Edge next(LineStrategy) : LineStrategy 에 따라 edge 생성
      * Edge unlink() : unlinked edge 리턴
      * String edge() : linked 여부에 따라 edge 모양 리턴
  * Participants
    * Variables
      * List<Participant> participants
  * Participant
    * Variables
      * String name
  * LineStrategy (interface)
    * boolean isLinkable() : 구현체에 따라 edge 의 link 여부 리턴
  * RandomLineStrategy implements LineStrategy
    * boolean isLinkable() : 랜덤으로 edge 의 link 여부 리터
* view
  * InputView
    * inputParticipants : 참가자 이름 입력
    * inputLadderHeight : 사다리 높이 입력
  * ResultView
    * printResult : 실행결과 출력
    * printParticipants : 참가자 이름 출력
* exceptions
  * ExceededMaxLengthException
