# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## 사다리게임 (생성)

### next-step 요구사항
- 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
- 사람 이름은 쉼표(,)를 기준으로 구분한다.
- 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
    - 사다리 폭은 -를 5개 사용하는 것이 고정이다
- 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
    - |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.
    - 가로줄이 여기에 생길지 생기지 않을지는 랜덤이다.
    
### 사다리 게임 (생성) 구현을 위한 그림

본격적인 구현에 들어가기 앞서 전체적인 구조를 생각해보자.

1. 사다리는 가로줄과 세로줄이 존재한다.
2. 세로줄에는 점들이 존재한다.
3. 점에는 방향이 존재한다.

전체적인 구조에 맞는 객체에 대한 생각

Ladder, Line, Point, Direction (ENUM)이 존재하게 될 것이다 \
Line은 세로줄을 의마하며 가로줄(계단 같이 생겼으니 Step이라 한다)은 논리적으로 존재한다. \
Point 간에는 DCEL(Doubly connected edge list)이 존재하여 어느 방향에 어떤 점과 연결되어 있는지 정보를 가지고 있다 \
교차지점 말고도 세로줄 꼭짓점 역시 하나의 점으로 간주한다. (즉 가로 5줄 사다리에는 7개의 점이 존재한다)

### 사다리 게임 도메인 기능

1. 사다리 생성하기 \
(N명, M줄)에 대한 사다리가 생성되어야 한

### 사다리 게임 View (Parser) / Controller 기능

1. 사람이름 받아 파싱하기
2. 최대 사다리 높이 받기
3. 사람 이름과 함께 사다리 출력하기

    
