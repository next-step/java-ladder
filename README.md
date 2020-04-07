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
  * 생성 시 사람 이름은 쉼표(,)를 기준으로 생성
* LadderGame
  * Users 와 높이를 입력하면 Ladder 생성
  * 특정 유저의 사다리 결과 요청이 들어오면 Ladder 에게 특정 유저를 파라미터로 실행메시지를 던진 후 결과를 받아온다.
* Ladder
  * UserCount 의 LadderLink 를 가진 LadderLine 을 heightCount 만큼 만든다.
  * 사다리를 실행하여 결과 인덱스를 구한 후 사라디 결과에게 결과 값을 요청한다.
* LadderLine
  * 유저 수를 입력 받고 유저수 만큼(처음은 default로 DIS_CONNECT) LadderLink를 생성한다.
* LadderLink
  * LadderLink는 생선 전략과 이전 LadderLink 에 의존하여 만들어진다. 
  * LadderLink 는 이전의 LadderLink 가 CONNECT 되었다면 CONNECT 될 수 없다.
* LadderReward
  * 정상적인 실행 결과
  * 유효하지 않은 실행 결과 (User.size != Result.size)
  * index를 가진 결과값 요청이 들어왔을때 그에 맞는 결과를 반환해준다.
