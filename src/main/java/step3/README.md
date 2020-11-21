# 사다리(게임 실행)

## 기능 요구사항
* 사다리 실행 결과를 출력해야한다.
* 개인별 이름을 입력하면 개인별 결과를 출력하고, "all"을 입력하면 전체 참여자의 실행 결과를 출력한다.
    
## 프로그래밍 요구사항
* 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
* 규칙 6: 모든 엔티티를 작게 유지한다.
* 규칙 7: 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다. 

## 힌트
* 각 로직을 구현하기 위해 필요한 데이터를 가지는 객체를 분리하기 위해 노력해본다. 로직 구현에 필요한 데이터를 가지는 객체를 잘 분리하면 의외로 쉽게 문제를 해결할 수 있다.
* 각 객체가 2개 이하의 인스턴스 변수만을 가지도록 구현해 본다.

##구조도
```
.
├── main
│     ├── java
│     │     └── step3
│     │         ├── Main.java
│     │         ├── README.md
│     │         ├── controller
│     │         │     └── LadderGameController.java
│     │         ├── domain
│     │         │     └── ladder
│     │         │         ├── Ladder.java //사다리 객체
│     │         │         ├── LadderGame.java // 사다리 게임 유틸 객체
│     │         │         ├── LadderGameResults.java //사다리 게임 결과객체
│     │         │         ├── LadderPlayers.java//사다리게임 참가자 목록
│     │         │         ├── LadderResults.java//사다리게임 결과(당첨 항목) 객체
│     │         │         ├── Line.java
│     │         │         ├── Player.java
│     │         │         ├── Point.java
│     │         │         └── dto
│     │         │             ├── LadderBuildDTO.java // 사다리 생성용 DTO
│     │         │             ├── LadderDrawDTO.java // 사다리 게임 정보 DTO
│     │         │             ├── LadderGameInformationDTO.java // 게임진행에 필요한 정보 DTO
│     │         │             ├── LadderResultDTO.java //좌표값에 해당하는 당첨결과 DTO
│     │         │             ├── LinePointsDTO.java //사다리게임 라인 DTO
│     │         │             └── PlayerWinningInfo.java //참가자 당첨결과 정보 DTO
│     │         ├── exceptions
│     │         │     ├── OutOfRangePlayerNameException.java
│     │         │     └── OutOfRangePositionException.java
│     │         ├── strategy
│     │         │     ├── MakeLadderLineStrategy.java
│     │         │     └── MakeLineStrategy.java
│     │         ├── type
│     │         │     └── DirectionType.java //사다리게임 방향 타입 ENUM
│     │         └── view
│     │             ├── ConsoleViewImpl.java
│     │             ├── InputView.java
│     │             ├── LadderGameInputView.java
│     │             ├── LadderGameResultView.java
│     │             ├── ResultView.java
│     │             └── View.java
└── test
    └── java
        └── step3
            ├── JoinePersonTest.java
            ├── LadderGameTest.java
            ├── LadderResultTest.java
            └── MakeLadderTest.java

```

