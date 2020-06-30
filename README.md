# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

# 과제 진행 - 사다리타기
> https://edu.nextstep.camp/s/KDgLkV1d/lt/AiVYd4Ly

## 사다리타기란?
* 사다리란 2차원 상에서 점들끼리 상하좌우로 연결된 형태
  * 표현할때 좌우길이가 상대적으로 길고, 우승자를 정할때 아래에서 위로, 위에서 아래로 이동하는 방식 때문에 사다리타기라고 부르는 듯 하다
* 위에서 아래로 이동시에 좌,우로 연결된 지점에 도착할 수 있는데, 연결된 지점을 만난다면 반드시 이동해야 한다
* 연결된 지점이 없다면 다시 아래로 내려간다
* 가장 아래에 도착했을때 위치에 따른 보상이 주어진다

## 프로그래밍 요구사항
* 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다.
* indent depth는 2를 넘지 않는다.
* method 길이는 15라인을 넘지 않는다.
* 자바 코드 컨벤션을 지킨다.
* else 예약어를 쓰지 않는다.
* 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
* 규칙 6: 모든 엔티티를 작게 유지한다.
* 각 객체가 2개 이하의 인스턴스 변수만을 가지도록 구현해본다.

## 요구사항
* 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
  * 사다리 X좌표마다 "이름"을 부여할 수 있다.
  * 이름은 최대 5자
  * 사다리 출력시 이름을 같이 출력
* 사람 이름은 쉼표(,)를 기준으로 구분한다.
  * InputView에서 ","를 기준으로 이름들을 입력받는다.
* 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
  * Y좌표마다 이동할 수 있는 범위는 좌,우 중 1개 경로만 가능하다
* 사다리 실행 결과를 출력할 수 있다
  * 이름을 입력 받으면 개인별 결과를 출력한다.
  * all을 입력하면 전체 참여자의 실행 결과를 출력한다.
  
* 책임주도설계
  * 책임: 사다리게임을 해라
    * LadderGame
    * 이름을 입력 받아 User를 생성해라
      * User, Users
    * 상품을 입력 받아 Prize를 생성해라
      * Prize, Prizes
    * 사다리를 만들어라
      * Ladder
        * List<Line> lineList
      * Line
        * List<Direction> directions
      * LineCreateStrategy
        * RandomLineCreateStrategy
    * 사다리타기를 진행해라
      * Point
        * void move(Direction direction)
      * Line
        * void move(Point point)
      * Ladder
        * int getLastPosition(Point point)
    * 사다리타기의 결과를 출력하라
      * UsersPrize
        * void add(User user, Prize prize)
        * Prize getPrize(User user)
      
* TDD
- Point
    - 사다리 세로줄에서의 각 x 좌표 점
    - [X] 이동방향(Direction)에 대해 (-1,0,+1) 만큼 이동한다
- Direction
    - 이동 방향 (-1,0,+1)
    - 로직이 없는 enum 클래스는 테스트 제외
- Line
    - List<Point> 사다리의 세로줄
    - [ ] width를 입력받아 길이만큼 Direction 배열이 생성된다
    - [ ] LineCreateStrategy interface를 주입받아 생성
    - [ ] 생성 시에 width < 2 이라면 예외 발생
    - [ ] 양쪽으로 연결될 수 없음
    - [ ] 첫번째 x 좌표는 오른쪽으로 연결되면 예외 발생
    - [ ] 마지막 x 좌표는 왼쪽으로 연결되면 예외 발생
    - [ ] 특정 x 좌표에서의 다음 x 좌표를 반환한다
- RandomLineCreateStrategy
    - [ ] first 메소드는 CENTOR or RIGHT
    - [ ] body 메소드는 LEFT or CENTOR or RIGHT
    - [ ] last 메소드는 LEFT or CENTOR
- Ladder
    - List<Line> 을 가지고 있는 가로세로 연결된 사다리
    - [ ] height를 입력받아 높이만큼 Line 배열이 생성된다
    - [ ] 생성 시에 height < 1 이라면 예외 발생
    - [ ] 특정 시작점에서의 결과 도착점을 반환한다
- User, Users
    - [ ] 이름의 길이를 입력 받아 생성
    - [ ] 이름의 길이가 5자 초과하면 예외 발생
- Prize, Prizes
    - [ ] '꽝' 혹은 숫자가 들어 와야 한다
- UsersPrize
    - [ ] 유저, 결과 상품 리스트를 추가할 수 있다
    - [ ] 특정 유저에 대한 결과 상품을 반환해야 한다
