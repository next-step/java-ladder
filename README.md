# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)


## 기능 요구사항
- 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
- 사람 이름은 쉼표(,)를 기준으로 구분한다.
- 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
- 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
  - |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.
  
## 기능 목록
1. LadderLine : 사다리의 1행을 나타내는 클래스
   1. LadderLine은 게임에 참여하는 사람 수 만큼의 boolean 값을 갖는다. 
   2. LadderLine의 boolean 값은 왼쪽으로 연결되어있는 발판의 존재여부이다. 
   3. LadderLine의 boolean 값은 false로 시작한다.(사다리의 첫번째 위치에서 더이상 왼쪽으로 갈수 없기때문이다.) 
   4. LadderLine에서 true값은 연속될 수 없다. 
   5. 위치를 입력받으면 이동 가능한 위치를 반환한다. 

2. Ladder : 사다리 클래스(여러개의 LadderLine으로 구성된다.)
   1. Ladder는 너비를 갖는다. 
   2. Ladder는 높이를 갖는다.
   3. 시작 위치를 받아서 결과 위치를 반환해준다. 

3. LadderGame : 사다리 게임을 실행하는 클래스
   1. 참여자 정보를 유지한다.
   2. 결과 정보를 유지한다. 
   3. 참여자 수와 전달받은 사다리 높이를 기반으로 사다리를 생성한다.
   4. 참여자 이름을 받으면 해당 참여자의 사다리게임 결과를 반환해준다.
   5. 모든 참여자의 결과를 한번에 반화해줄 수 있다.

4. Name : 참여자 이름 클래스
   1. 이름은 최소 1글자, 최대 5글자로 부여할수 있다.

5. LadderGameInfo : 사다리게임의 참여자목록, 결과목록 정보 클래스
   1. 참여자목록과 결과목록의 수는 같아야한다. 
   2. 참여자이름이 주어지면 참여자의 위치를 알 수있다. 
   3. 위치가 주어지면 결과를 알 수 있다.
   
7. InputView : 입력처리하는 클래스
8. ResultView : 출력처리하는 클래스
 
9. RandomValueGenerator : 랜덤한 값을 생성하는 util클래스
