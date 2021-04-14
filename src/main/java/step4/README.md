# 4단계 - 사다리(리팩토링) 

## 기능 요구사항

- 게임 참여하는 사람의 이름 최대 5글자 부여 가능
- 사다리 출력할 시, 사람의 이름도 같이 출력
- 사람의 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 함
- 라인 겹치지 않도록 해야함
- 사다리 실행 결과를 출력
- 개인별 이름을 입력하면 개인별 결과를 출력
    - "all"을 입력 시 전체 참여자의 실행 결과를 출력
- 추가로 제공되는 객체 설계 힌트를 참고해 철저하게 TDD로 재구현


## 기능 목록
### Direction
- 각 Point의 좌/우 방향을 Direction으로 추상화 
- 각 Point의 좌/우 방향 정보를 가진다.
- 현재 Point에서 다음 Point를 생성하는 역할


### Point
- LadderLine의 두 점과 현재 위치를 Point로 추상화
- LadderLine에서 위치와 각 점의 방향을 관리


### LadderLine
- 사다리 한 Line 추상화
- 사다리 게임에서 한 Line을 LadderLine으로 이름을 붙임
- 사다리 Line의 모든 Point 초기화와 이동을 담당


### Ladder
- 사다리 게임에서의 전체 사다리
- 여러 LadderLine 가진다.
- 사람의 수 만큼 라인 생성
- 사다리 생성과 라인별 이동을 담당


### PlayerName
- Player 이름 정보를 가짐
- 이름의 길이 유효성 체크


### Player
- 게임 이용자
- 이름과 위치 정보를 가짐


### Players
- 여러 Player 가진다.
- 입력한 사람의 수 만큼 Player 생성


### Position
- index 정보를 가짐
- 유효성 체크


### Prize
- 게임 상품
- 상품과 위치 정보를 가짐


### Prizes
- 여러 Prize 가진다.
- 입력한 상품의 수 만큼 Prize 생성
- Player 수와 상품 수 체크


### PlayResult
- 게임 수행 결과
- Player 별 Prize 매칭 결과
