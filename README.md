# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 기능 요구 사항
* 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
* 사람 이름은 쉼표(,)를 기준으로 구분한다.
* 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
* 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
* |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

## 구현해야 할 사항
* 사다리 게임에 참여하는 사람의 이름을 받는 InputView를 구현한다.
  * System.in을 통해 이름을 입력으로 받는다.
  * 사다리 높이를 입력받는다.
* 사다리를 출력하는 OutputView를 구현한다.
  * 사다리 폭을 알맞은 크기로 만들어 출력한다.
  * 사다리 높이에 맞게 사다리를 출력한다.
* Domain과 View를 연결하는 Controller를 구현한다.
  * 입력을 받은 뒤 이름을 쉼표로 구분해서 분리한다.
  * 참여자 factory로 참여자를 만드는 것을 요청한다.
  * 참여자 수와 사다리 높이를 인자로 하여 Ladder class를 만든다.
* 참여자의 이름은 Name으로 구현한다.
  * 참여자의 이름이 5글자 이하인지 확인한다.
* 참여자인 Participant class를 구현한다.
  * Participant는 Name을 member 변수로 가진다.
* 참여자의 일급 collection인 Participants class를 구현한다.
* 참여자를 만드는 factory class를 구현한다.
  * 참여자의 이름을 받아 Participants class를 리턴한다.
* 사다리의 층을 이루는 Stair class를 구현한다.
  * Random class를 이용해 계단의 유무를 결정한다.
  * 참여자 수를 통해 계단의 유무 개수를 정한다.
* Stair class의 일급 collection인 Stairs class를 구현한다.
  * 사다리 높이를 인자로 받아 Stair를 생성한다.
  * 출력 여부를 결정하는 boolean을 2-d array로 제공한다.
* Ladder class를 구현한다.
  * 참여자 수와 사다리 높이를 받아 Stairs를 생성한다. 
  * 사다리 높이와 Stairs를 member 변수로 가진다.
  * Stairs class를 통해 출력 데이터를 제공한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)