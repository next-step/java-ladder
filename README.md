# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## 구현대상 소스
### [UI]
* LadderApplication : 사다리게임 진행을 위한 UI App
* InputView : 사다리게임 실행에 필요한 정보입력을 위한 입력기능 UI view
* OutputView : 사다리 생성결과 및 게임 실행결과 출력을 위한 출력기능 UI view
### [Presentation Layer]
* LadderGameController : 사다리게임 실행 및 결과조회를 위한 API 진입소스
* LadderGameRequest : 사다리게임 참가자, 매칭결과, 사다리 생성정보 와 같이 개임실행에 필요한 입력정보를 저장하고 있는 dto 클래스
* LadderGameResponse : 사다리게임 생성 및 실행결과 정보를 저장하고 있는 출력 dto 클래스
* LadderGenerationResult : 사다리게임 생성정보를 저장하고 있는 출력 dto 클래스
* LadderLine : 사다리 한 줄 출력에 필요한 정보를 저장하고 있는 출력 dto 클래스
* LadderGameResult : 사다리게임 참가자와 게임실행결과의 매핑정보를 저장하고 있는 dto 클래스
### [Service Layer]
* LadderGameService : 사다리게임 생성 및 게임 실행결과 반환처리를 위한 서비스 클래스
### [Domain Layer]
* Participants : 사다리게임 참가자 목록을 표현하기 위한 일급컬렉션 도메인 클래스
* Participant : 사다리게임 참가자 한 명을 표현하기 위한 도메인 클래스
* Ladder : 여러 줄의 라인으로 이루어진 사다리를 표현하기 위한 도메인 클래스  
* Line : 사다리 한 줄을 표현하기 위한 도메인 클래스
* LineWriteStrategy : 사다리 한 줄의 가로선을 그리는 전략을 나타내는 전략 인터페이스
* RandomLineWriteStrategy : 무작위로 가로선을 그리는 전략을 구현한 구현체 클래스
* Point : 사다리 이동 위치를 표현하기 위한 좌표 클래스
* Direction : 좌표의 방향을 표현하기 위한 클래스. 좌·우측 방향을 표현할 수 있다 
* MatchingItems : 사다리게임 실행 결과를 표현하기 위한 도메인 클래스