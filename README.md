# 사다리타기 - FP, OOP
## 1단계 - 스트림, 람다, Optional
### 1단계 피드백
- [x] 스트림을 사용할 때는 연산 순서를 고려해서 사용하라
- [x] 에러 메세지는 항상 구체적으로 작성하라

## 2단계 - 사다리(생성)
### 기능 요구사항
- 사다리 게임에 참여하는 사람의 이름은 최대 5글자. 사다리를 출력할 때 사람 이름도 같이 출력
- 사람 이름은 쉼표(,)를 기준으로 split
- 라인이 겹치지 않도록 한다
### 프로그래밍 요구사항
- 자바8의 스트림과 람다를 적용해 프로그래밍한다
- 규칙 6: 모든 엔티티를 작게 유지한다

### 기본 구조
tdd를 통한 개발을 할 때 도메인, 요구 사항에 대한 명확한 이해가 있어야 하기 때문에 기본 구조를 파악하고 목록을 작성한다
- 참가자의 수(n)만큼 세로선(`|`)이 생긴다. 즉, 사다리의 간격은 (n-1)개이다. 
- 사다리의 너비는 참가자의 수(n)에 따라 결정난다.
- 사다리는 가로선(`-----`)을 통해 경로를 생성한다.
  - 이 때, 가로선은 두 개의 세로선 사이에 생긴다.
  - 가로선이 생겼다면, 그 다음 공간(두 세로선 사이)에는 빈 공간이 되어야 한다.
### class 구성(의존방향의 가장 마지막 노드부터)
- `Point`: 사다리의 가로선의 존재를 나타내는 객체 
- `Line`: 사다리의 한 줄을 나타내는 객체
- `Ladder`: 사다리를 나타내는 객체
- `LadderGame`: 사다리게임을 나타내는 객체
- `InputView`: 사용자 입력을 나타내는 객체
- `OutputView`: 출력 부분을 나타내는 객체 
- `Person`: 참가자를 나타내는 객체 
### 기능 구현 목록
- [x] Line 객체를 초기화했을 때, 참가자의 수에 따라 리스트의 크기가 설정된다(ex. 참가자의 수가 3이라면 길이는 (3 - 1) * 5 만큼 생긴다)
- [x] Line 객체를 초기화했을 때, 앞 부분이 가로선이 생겼다면 그 다음 부분은 공백이 된다
- [x] 0명이거나 음수를 입력했을 때, IllegalArgumentException을 반환한다 
- [x] Ladder 객체를 초기화했을 때, 입력한 사다리 높이에 따라 Line 객체가 생성된다
- [x] 사다리 높이가 0이거나 음수를 입력했을 때, IllegalArgumentException을 반환한다
- [x] 참가자는 이름을 갖는다
- [x] 참가자의 이름을 공백이나 null을 입력했을 때, IllegalArgumentException을 반환한다
- [x] 참가자의 이름은 NAME_LENGTH_STANDARD를 초과할 수 없다. 초과한다면 IllegalArgumentException을 반환한다 
### 2단계 피드백
- [x] 사다리 높이를 포장하라
- [x] 참가자 수를 포장하라
- [x] 유효성 검사를 막하지 말고 올바른 곳에서 하도록 하라
- [x] 하드코딩을 하지말고 메서드로 따로 빼서 무엇을 의미하는건지 명확히하라
- [x] 사용하지 않는 클래스는 프로덕션 코드말고 테스트에 위치시켜라

## 3단계 - 사다리(게임 실행)
### 기능 요구사항
- 사다리 실행 결과를 출력해야 한다.
- 개인별 이름을 입력하면 개인별 결과를 출력하고, "all"을 입력하면 전체 참여자의 실행 결과를 출력한다.
### 프로그래밍 요구사항
- 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
- 규칙 6: 모든 엔티티를 작게 유지한다.
- 규칙 7: 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
### 기능 구현 목록
- executionResult
  - [x] 입력받을 때 null 또는 공백이면 예외를 반환한다 
  - [x] 실행 결과의 수(,를 기준으로 나눈 수)가 참여자의 수와 다를 때 예외를 반환한다
  - [x] ,로 나뉘었을 때, 각 단어가 null 또는 공백이면 예외를 반환한다 
- Person
  - [x] 각각 int형 포지션을 갖는다
  - [x] 포지션이 음수면 예외를 반환한다 
  - [x] 포인트(Point)의 값(true/false)에 따라 사람(Person)의 position이 바뀐다
- Rung
  - [x] boolean값을 갖는다
  - [x] 이전(i - 1) 점이 존재하는지 검증한다   
- Rungs
  - [x] 점들이 각각 true인지 false인지 검증한다  
- Ladder
  - [x] 점들이 각각 true인지 false인지 검증한다 

### 3단계 피드백
- [x] 부정형(isNotFirstPosition)으로 물어보라
- [x] Person#crossLadder(..) 에 별도로 예외 메시지를 작성하라
- [x] 값을 꺼내려하지말고 rung 객체로 판별하게 하라

## 4단계 - 리팩터링(4단계)

### In -> Out 방식 TDD

#### Direction
- [x] true false 일 때, 움직이면 -1
- [x] false true 일 때, 움직이면 +1
- [x] false false 일 때, 그대로
- [x] true true 일 때, 예외 반환
- [x] 첫 번째 Direction은 무조건 left가 false
- [x] 첫 번째 다음의 Direction은 left는 기존의 right
- [x] 마지막 Direction은 무조건 right가 false
- [x] first 다음부터 true다음엔 무조건 false
#### Rung
- [x] rung 0이고 false true 일 때, 움직이면 +1  
- [x] rung 0이고 false false 일 때, 움직이면 0
- [x] rung 1이고 true false 일 때, 움직이면 0
- [x] rung 1이고 false true 일 때, 움직이면 2
- [x] rung 1이고 false true 일 때, 움직이면 2
- [x] rung 1이고 이전의 값이 true일 때, next는 무조건 false 
#### Line
- [x] position이 Rung의 list에 따라 움직인다 
- [x] Rung의 list는 참가자 수에 따라 결정된다
#### Ladder
- [x] position이 Line list에 따라 움직인다 
- [x] Line의 list는 height에 따라 결정된다 
#### LadderGame

### 책임 주도 설계
- in-out방식으로 일차적으로 개발했을 때, 책임이 너무 많은 객체가 생겼음(ex. Ladder, Line)
- 책임을 분리하기 위해 책임 주도 설계를 진행함

- 사다리를 타게하고 참가자의 결과를 도출하라
  - 사다리를 생성하라
    - LadderCreator#create(int height, int countOfPeople)
    - LineCreator#create(int countOfPeople)
  - 사다리를 타게하라(사다리게임을 실행하라)
    - Ladder#game() 
    - Line#move(int position)
  - 참가자의 결과를 도출하라
    - LadderResult#add(int resultPosition)
