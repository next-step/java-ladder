# 사다리 게임
## STEP1 기능 요구사항
* 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
* 사람 이름은 쉼표(,)를 기준으로 구분한다.
* 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
* 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
  * |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

## 기능 목록
* User
  * 생성 시 이름은 최대 5글자까지 부여
  * 5글자를 넘어가거나 0글자인 경우 exception
* Users
  * User의 일급 컬렉션
* LadderGame
  * 유저와 사다리 높이를 입력 받아 사다리에게 만들 것을 요청한다. / LadderGame of(Users, 사다리 높이)
    * 유저는 Not Null & 2명 이상, 사다리 높이는 0보다 커야한다.
  * Rewards 을 입력 받아 사다리 게임을 실행하고 결과를 반환한다. / LadderGameResult start(Rewards)
    * Rewards 는 null 이 아니며 유저 수와 같아야한다.
*LadderGameResult
  NodeResult 의 일급 컬렉션
* NodeResult
  * Node & Reward 를 가진 객체
* Ladder
  * 유저 수 와 사다리 높이를 입력 받아 사다리를 만든다. / Ladder of(유저 수, 사다리 높이)
  * 유저를 받아 사다리를 실행하여 결과 Nodes를 반환한다. / Nodes exec(Users)
* Node
  * User & Position을 가진 객체
  * LadderLine을 입력받아 Link를 확인하고 움직인다 / void move(LadderLine)
* Nodes
  * Node 의 일급 컬렉션
* LadderLine
  * 유저 수를 입력 받아 LadderLine을 만든다. / LadderLine of(유저 수)
  * 유저 수를 입력 받고 유저 수 만큼(처음은 default로 DIS_CONNECT) LadderLink를 생성한다.
* LadderLink
  * LadderLink는 랜덤으로 존재 여부가 결정된다.
  * LadderLink는 이전의 LadderLink가 존재한다면 존재 할 수 없다.
* Node
  * 유저와 Position 값을 가진 사다리를 타는 객체.
  * LadderLine을 입력 받아 사다리를 타고 내려간다. / void move(LadderLine)
* LadderRewards
  * 정상적인 실행 결과
  * 유효하지 않은 실행 결과 (User.size != Result.size)
  * index를 가진 결과값 요청이 들어왔을때 그에 맞는 결과를 반환해준다.

## 플로우
1. 사다리 게임에 유저와 사다리 높이를 입력한다.
2. 만들어진 사다리에 결과를 입력한다.
3. 사다리를 실행한다.
4. 결과를 조회한다.
