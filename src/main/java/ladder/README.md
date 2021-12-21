# 사다리타기

## 사다리 타기 기능 목록

### controller 패키지

- Game: 게임 실행 클래스
  - 입력 기능 호출
  - 출력 기능 호출


### domain 패키지

- Ladder: 사다리 클래스
  - 여러 Line 이 모여져 이루어진 사다리 입니다.


- Line : 사다리 한줄 클래스
  - 여러 Point 들이 모여 이루어진 한줄 입니다.


- Point: Line 을 이루는 한점 클래스
  - 사다리 라인중 한 지점을 의미합니다.
  - 다음 지점으로 이동하는 방향 정보를 가지고 있습니다.
  - 방향을 가진 Point 를 조건에 따라 생성할 수 있습니다.


- Way: 방향 enum 클래스
  - 아래, 왼쪽, 오른쪽 정보를 가지고 있습니다.
  

- Height: 사다리 높이 클래스
  - 최소 1 이상의 사다리 높이 유효성 검증을 실시합니다.


- Location: 위치 정보를 나타내는 클래스


- Players: 플레이어 목록 클래스


- Player: 플레이어 클래스


- Answers: 사용자가 입력한 결과 목록 클래스


### exception 패키지

- PlayerException : 플레이어 정보 오류 반환 클래스

- HeightException : 사다리 높이 오류 반환 클래스

- ResultException : 결과 오류 반환 클래스


### view 패키지

- InputView: 입력지시문 출력 및 입력값 받는 클래스
- ResultView: 출력결과 클래스