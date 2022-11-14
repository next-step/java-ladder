# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## 2단계 - 사다리(생성)

### 기능 요구사항
- 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
- 사람 이름은 쉼표(,)를 기준으로 구분한다.
- 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
- 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
  - |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

```
참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)
pobi,honux,crong,jk

최대 사다리 높이는 몇 개인가요?
5

실행결과

pobi  honux crong   jk
    |-----|     |-----|
    |     |-----|     |
    |-----|     |     |
    |     |-----|     |
    |-----|     |-----|

```

## 3단계 - 사다리(게임 실행)

### 기능 요구사항

- 사다리 실행 결과를 출력해야 한다.
- 개인별 이름을 입력하면 개인별 결과를 출력하고, "all"을 입력하면 전체 참여자의 실행 결과를 출력한다.

### 프로그래밍 요구사항

- 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
- 규칙 6: 모든 엔티티를 작게 유지한다.
- 규칙 7: 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.

```
참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)
pobi,honux,crong,jk

실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)
꽝,5000,꽝,3000

최대 사다리 높이는 몇 개인가요?
5

사다리 결과

pobi  honux crong   jk
    |-----|     |-----|
    |     |-----|     |
    |-----|     |     |
    |     |-----|     |
    |-----|     |-----|
꽝    5000  꽝    3000

결과를 보고 싶은 사람은?
pobi

실행 결과
꽝

결과를 보고 싶은 사람은?
all

실행 결과
pobi : 꽝
honux : 3000
crong : 꽝
jk : 5000
```

### 요구사항 정리

- [x] 참가자 이름을 입력 받는다.
  - 공백, null 안됨
  - 참가자 이름 2개 이상
  - ,로 구분해서 입력
- [x] 사다리 높이를 입력 받는다.
  - 높이는 1 이상
- [x] 사다리를 생성한다.
  - 사다리 라인이 이어졌는지 상태 값을 행렬로 가진다.
  - 사다리 행렬의 행은 높이 만큼 있다.
  - 사다리 행렬의 열은 참가자 - 1 만큼 있다.
  - 사다리 라인은 무작위로 그린다.
  - 단, 한 행에서 연속적으로 라인을 그릴 수 없다.
- [ ] 참가자 별 사다리 결과를 구한다.

Player 참가자

- [x] 이름은 공백이거나 null 일 수 없다.
- [x] 이름은 최대 5글자 이다.
- [ ] 사다리와 자신의 시작 위치를 받아 마지막 위치를 구한다.

Players

- [x] 문자열로 참가자 목록을 입력 받으면, 콤마를 기준으로 파싱해 Player를 생성한다.
- [ ] 사다리와 결과값을 받아 게임 실행 결과를 구한다.

Result 결과

- [ ] 공백이거나 null 일 수 없다.
- [ ] 플레이어 이름별 결과 값을 가진다.

Height 사다리 높이

- [x] 높이는 1보다 작을 수 없다.

Width 사다리 너비

- [x] 사다리 너비를 구한다. (참가자수 - 1)
- [x] 너비는 1보다 작을 수 없다.

Ladder 사다리

- [x] 사다리 라인의 상태 값을 행렬로 가진다.
- [x] 사다리 라인의 상태는 랜덤으로 정해진다.

Ladder : List<Line>

- [x] 높이 만큼 사다리 라인을 생성한다.

Line : List<Point>

- [x] 사다리의 한 행에 연속된 라인을 그릴 수 없다.
- [x] 너비 만큼 사다리 열을 생성 한다.
  - [x] 사다리 라인 유무를 랜덤으로 생성 한다.
- [ ] 받은 위치와 받은 위치 - 1 중 Point 상태가
  - 받은 위치가 true : 현재 위치 + 1
  - 받은 위치 - 1 이 true : 현재 위치 - 1
  - 둘다 false : 현재 위치 유지

Point 상태 값 - 사다리 라인 유무

- [x] 라인이 존재하면 true 이고, 존재하지 않으면 false 이다.
- [x] 이전 라인 값이 true 이면 다음 라인 값을 false로 생성 한다.

RandomValueGenerator

- [x] 랜덤으로 상태 값을 생성한다. true/false