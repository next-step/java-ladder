# 사다리 게임

## 2단계

### 기능 목록

- 입력
  - 참여할 `사람의 이름`
    - 사람의 이름은 최소 1자, 최대 5자까지 입력할 수 있다.
    - 사람의 이름은 쉼표(`,`)를 기준으로 구분한다.
  - `사다리 높이`
    - 최소 1 이상의 숫자를 입력할 수 있다.
- 사다리
  - `|-----|-----|` 모양과 같이 가로 라인이 겹치지 않아야 한다.
- 출력
  - 참여한 `사람의 이름`
  - `사다리`
    - 높이 : `|`
    - 폭 : `-----`, 사람 이름의 길이인 최대 5자 기준

## 3단계

### 기능 목록

- 입력
  - `사다리 실행 결과`
    - 사다리 실행 결과는 최소 1자, 최대 5자까지 입력할 수 있다. (요구사항으로 명시되어 있지는 않으나, 출력 형식을 맞추기 위해서 참가자 이름과 동일한 스펙으로 설정함.)
    - 사다리 실행 결과는 쉼표(`,`)를 기준으로 구분한다.
    - 사다리 실행 결과의 수와 사람의 수는 같아야 한다.
- 출력
  - `사다리 실행 결과`
    - `사람의 이름`을 입력하면 해당 사람의 결과를 출력해야 한다.
    - 빈 문자열 또는 5자를 넘어가는 텍스트를 입력하면 오류 메시지와 함께 다시 입력하도록 해야 한다.
    - 만약 참가하지 않은 사람의 이름을 입력하면 오류 메시지와 함께 다시 입력하도록 해야 한다.
    - `all`을 입력하면 전체 참여자의 실행 결과를 출력하고, 프로그램이 종료되어야 한다.
- 사다리
  - 사다리 가로 막대가 현재 위치 기준으로 오른쪽으로 연결되어 있으면, 위치는 1 증가되어야 한다.
  - 사다리 가로 막대가 현재 위치 기준으로 왼쪽으로 연결되어 있으면, 위치는 1 감소되어야 한다.
