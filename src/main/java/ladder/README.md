## 사다리 게임 구현 기능 목록

### Domain

* Player
    * 게임 참가자 객체
    * 이름에 대한 예외 처리
        * 이름이 NULL이거나 빈 문자열이거나 5자를 넘는 경우 예외 발생

* PlayersGroup
    * 게임 참가지 객체의 리스트(List<Player>) 일급 컬렉션
    * 참가자 객체의 이름 목록을 파라미터로 받아 객체 생성

* Point
    * 사다리 한 수평 라인의 한 점을 구성하는 객체
    * 해당 부분에 값이 존재하는지 아닌지(boolean)를 결정함.
    * 난수를 받아 객체 생성 시, 해당 부분에 값이 존재하는지 아닌지를 결정함.

* Line
    * 사다리의 수평 라인 한 줄을 의미하는 객체
    * 수평 라인이 존재하는 부분과 아닌 부분을 List<Point>으로 가짐
 
 * DrawingLineStrategy
    * 선을 그리는 전략 인터페이스
    * RandomDrawingLineStrategy는 인자로 참가자의 수(사다리의 너비)를 받음.

* LadderFactory
    * 게임 참가자 수와 Ladder 높이를 파라미터로 받아 적합한 크기의 Ladder 생성

* Ladder
    * 사다리 2차원 배열의 정보를 List<Line>으로 가지고 있는 일급 컬렉션.
    * 플레이어 명단과 사다리 높이를 바탕으로 사다리를 생성함.
        
### View

* InputView
    * 쉼표로 구분되는 게임 참가자(Player) 명단을 입력 받음.
    * 사다리 높이를 입력 받음.
    
### Application
