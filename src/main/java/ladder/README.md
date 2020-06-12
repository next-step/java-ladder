## 사다리 게임 구현 기능 목록

### Domain

* Player
    * 게임 참가자 객체
    * 이름에 대한 예외 처리
        * 이름이 NULL이거나 빈 문자열이거나 5자를 넘는 경우 예외 발생

* PlayersGroup
    * 게임 참가지 객체의 리스트(List<Player>) 일급 컬렉션
    * Player들의 이름 중 중복이 있을 경우 예외 발생
    * 참가자 객체의 이름 목록을 파라미터로 받아 객체 생성
    * Player들의 이름 명단(List<String>) 반환
    * Player들 수를 반환
    
* GamePrize
    * 게임 실행 결과를 담고 있음
    * 이름이 Null이거나 빈 문자열일 경우 예외 발생

* GamePrizes
    * List<GamePrize> 일급 컬렉션
    * 개수가 게임 참가자와 일치하지 않을 경우 예외 발생

* Point
    * 사다리 한 수평 라인에서 세로선(|) 위치의 한 점을 구성하는 객체
    * 해당 부분의 x축 좌표(Index)와 해당 점에서 갈 수 있는 방향을 가짐.
        * Index에 대한 예외 처리(음수값 등)
    * Direction은 별도의 객체.
    * 처음 점을 찍는 경우 / 마지막 점을 찍는 경우 / 그 외의 경우를 구분해서 객체 생성
    * 현재 위치의 Point가 Direction에 따라 이동하면 변화된 좌표(index)를 반환
    
* Direction
    * Left, Right, Stop 3가지로 나뉨.
    * 각 상수는 index가 주어지면 해당 인덱스 좌표가 주어지면 방향에 맞게 수정시켜 리턴함.
    * index를 통한 valueOf 객체 반환 기능
    
* Line
    * 사다리의 수평 라인 한 줄을 의미하는 객체
    * 수평 라인이 존재하는 부분과 아닌 부분을 List<Point>으로 가짐
    * 생성된 Line을 구성하는 각 Point들의 정보를 담은 List<Boolean> 반환
    * parameter로 한 라인의 특정 point의 index를 받으면 해당 point를 검색해 move시킨 좌표를 반환.
    
 * DrawingLineStrategy
    * 선을 그리는 전략 인터페이스
    * RandomDrawingLineStrategy는 인자로 참가자의 수(사다리의 너비)를 받음.

* LadderFactory
    * 게임 참가자 수와 Ladder 높이를 파라미터로 받아 적합한 크기의 Ladder 생성
    * 높이가 1보다 작을 경우 예외 발생
    
* Ladder
    * 사다리 2차원 배열의 정보를 List<Line>으로 가지고 있는 일급 컬렉션.
    * 플레이어 명단과 사다리 높이를 바탕으로 사다리를 생성함.
    * 사다리의 설계도면을 List<List<Boolean>>으로 반환함
        
### View

* InputView
    * 쉼표로 구분되는 게임 참가자(Player) 명단을 입력 받음.
    * 사다리 높이를 입력 받음.
    
* OutputView
    * Ladder 객체를 바탕으로 사다리의 모습을 그림
    
### Application
