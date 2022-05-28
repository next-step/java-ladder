# 사다리 게임

## step1

### Todo

- [x] 람다 실습 1 - 익명 클래스를 람다로 전환
- [x] 람다 실습 2 - 람다를 활용해 중복 제거
- [x] map, reduce, filter 실습 1
- [x] map, reduce, filter 실습 2
- [x] 요구사항 1 - Optional을 활용해 조건에 따른 반환
- [x] 요구사항 2 - Optional에서 값을 반환
- [x] 요구사항 3 - Optional에서 exception 처리

## step2

### Todo

- [x] 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
    - [x] scanName, 사람 이름은 쉼표(,)를 기준으로 구분한다.
    - [x] class Name with max 5
    - [x] scanHeight
- [x] 사다리 게임에서 한 라인의 좌표 값을 가지는 객체를 추가해 구현해 본다.
    - [x] 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
        - |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.
        - [x] 그려진 라인은 제외하고 랜덤 가로줄 생성
    - [x] 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다. -> Line을 5자로 고정
- [x] 사람 수와 높이만큼 사다리 출력
- [x] 사람 이름 형식에 맞게 출력, players.draw()
- [x] add test cases

### Results

```
Put player names separated by ','.
q,qw,qwe,qwer,qwert
Put max height of ladders
10
  q     qw    qwe   qwer  qwert 
    |     |     |-----|     |
    |-----|     |     |     |
    |-----|     |     |     |
    |-----|     |-----|     |
    |-----|     |-----|     |
    |     |     |-----|     |
    |-----|     |     |     |
    |     |-----|     |-----|
    |     |-----|     |     |
    |     |-----|     |     |
```

### Requested changes

- [x] 개행으로 가독성 개선 (ladderApp)
- [x] Optional.ofNullable => of 로 변경 (Height)
- [x] 매직 넘버 const 선언
    - [x] MAX_PLAYER_NAME = 5, 상수 통해 예외처리 추가
    - [x] MAX_HEIGHT = 20
- [x] 입력 메시지는 Input 내에서 처리
    - [x] Height 에 대해서는 scanner.nextInt() 로 변경
- [x] 도메인이 UI에 의존적이지 않게 변경
    - [x] Line * 5 print
    - [x] Lines foreach print
- [x] 생성자를 추가하거나 전략 패턴을 적용하여 랜덤 요소분리 (Line)
    - [x] Line 수동 생성자 추가하여 테스트
- [x] Player.parse Input 으로 이동
- [x] Players.payload => Output.format, Players.draw => Output.printPlayers 로 이동
- [x] Height.lines -> Lines 의 생성자로 이동
- [ ] 검증, 비지니스 로직이 없다면 일급 컬렉션 제거 (Lines)?
    - lines 가 이동되면 로직이 생겼으니 제거 안해도 되는것인가?
- [x] add test cases

### Requested changes - phase2

- [x] User.ageIsInRange2n 내부 Optional.of 를 ofNullable 로 원복
- [x] Input 의 생성자 private 으로 변경 (java.util.Objects)
- [x] Output class 내부에서만 사용되는 메서드 private 로 변경 후 호출 순서대로 public 메서드 하단에 위치 (클린코드 5장 형식 맞추기)
- [x] Const class 의 static 변수들 각자의 위치로 분배
- [x] 불변 컬렉션 리턴
    - [x] Lines.lines
    - [x] Players.players
- [x] Lines 생성자 내부 로직을 create() 정적 팩토리 메서드로 변경
- [x] Player 생성자 내부 에러 메시지 const로 변경
    - [x] 커스텀 에외 클래스 생성
- [x] HeightTest.over20GetsError 에서 assertThatIllegalArgumentException 로 변경
    - [x] equals, hashcode 검증 테스트 추가
- [x] Line 의 검증 inspect 메서드 생성자 내에서 사용으로 통일
    - [x] Line 생성 자 내 로직 Line.create() 로 분리
    - [x] inspect 메서드 -> validate 로 이름 변경
- [x] LinesTest BDD 로 테스트 작성, 높이에 대한 검증만 수행

## Step3-execution

### Result

```
Put player names separated by ','.
pobi, honux, henry
Put Execution results separated by ','.
💎, 💣, 💰
Put max height of ladders
5
  pobi. honux henry 
    |     |     |     
    |-----|     |     
    |     |     |     
    |     |     |     
    |     |-----|     
  💎... 💣... 💰... 
Put person to show reward.
Options: pobi, honux, henry (or 'all')
henry
Ladder Result
henry: 💣
Put person to show reward.
Options: pobi, honux, henry (or 'all')
all
Ladder Result
pobi: 💰
honux: 💎
henry: 💣
```

### Todo

- [x] 실행 결과 입력 받음
- [x] 사다리 결과 아래에 실행 결과 나열
- [x] 결과를 보고 싶은 사람 입력 받음
    - [x] scanPlayerToShow
    - [x] findPlayer
- [x] 사다리 타기
    - [x] Coordinate class 생성: 사다리 현재 좌표 표시
    - [x] Ladder class 생성
        - line, coordinate
        - [x] Ladder.play(): 사다리 1턴 수행
        - [x] Ladder.plays(): 사다리 높이만큼 모두 수행
- [x] 사람수에 비해 사다리 칸(lines) 이 부족한 버그 수정
- [x] Reward 출력
    - [x] 1명의 이름 -> 1명 결과 출력
    - [x] all -> 모두의 실행 결과 출력
- [x] refactoring to remove indent

### Requested changes
- [x] 가독성을 높이기 위해 의미있는 단위로 개행
- [x] 불필요한 인터페이스 제거: Scanned