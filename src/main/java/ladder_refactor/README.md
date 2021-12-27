# 사다리타기 (refactor 버전)

## 사다리 타기 기능 목록

### controller 패키지

- Game: 게임 실행 클래스
    - 입력 기능 호출
    - 출력 기능 호출


### domain 패키지

- Ladder: 사다리 클래스
    - 여러 LadderLine 이 모여져 이루어진 사다리 입니다.
    - 사다리 이동 결과를 반환합니다.
    

- LadderLine : 사다리 한줄 클래스
    - 사다리 Line의 모든 Point 초기화와 이동을 담당합니다.
    

- Point : LadderLine에서의 위치와 각 점의 방향을 관리합니다.


- Direction : Point의 좌우 방향을 나타냅니다.
    - 각 Point의 좌/우 방향 정보를 가집니다.
    - 현재 Point 에서 다음 Point 를 생성합니다.
    

- LadderPointGenerator : 랜덤으로 포인트의 방향값을 반환합니다.


- Players : 플레이어 목록
- Player : 플레이어 정보


- Answers : 사용자가 입력한 결과 목록


- Height : 사다리 높이 정보



### exception 패키지

- LadderInputException : 입력값 오류 반환 클래스


### view 패키지

- InputView: 입력지시문 출력 및 입력값 받는 클래스
- ResultView: 출력결과 클래스