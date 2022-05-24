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
- [ ] 도메인이 UI에 의존적이지 않게 변경
    - [ ] Line * 5 print
    - [ ] Lines foreach print
- [ ] 생성자를 추가하거나 전략 패턴을 적용하여 랜덤 요소분리
- [ ] Player.parse Input 으로 이동
- [ ] Player.payload Output 으로 이동
- [ ] Line 수동 생성자 추가하여 테스트
- [ ] Height.lines -> Lines.lines 이동
- [ ] 검증, 비지니스 로직이 없다면 일급 컬렉션 제거 (Lines)?
    - lines 가 이동되면 로직이 생겼으니 제거 안해도 되는것인가?
