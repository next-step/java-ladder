# 사다리

## 기능 요구사항

- 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
- 사람 이름은 쉼표(,)를 기준으로 구분한다.
- 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
- 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
    - `|-----|-----|` 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.
- 사다리 실행 결과를 출력해야 한다.
- 개인별 이름을 입력하면 개인별 결과를 출력하고, "all"을 입력하면 전체 참여자의 실행 결과를 출력한다.


## 프로그래밍 요구사항

- 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
- 규칙 6: 모든 엔티티를 작게 유지한다.
- 규칙 7: 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.

## Todo List

- Player: 참가자 한명
    - [X] Player는 참가자 이름을 가질 수 있다.
    - [X] 이름은 최대 5글자까지만 가질 수 있다.

- Players: 참가자 목록
    - [X] 여러 Player를 생성할 수 있다.
    - [X] null 또는 0개의 이름이 입력되면 예외를 반환한다.
    - [X] 참가자 이름으로 Players 중 몇 번째인지 순서를 찾을 수 있다.
        - [X] 존재하지 않는 참가자 이름 입력 시 예외를 반환한다.

- Reward: 사다리 결과(보상)
    - [X] 보상명을 가질 수 있다.

- Rewards: 사다리 결과 목록
    - [X] 여러 Reward를 생성할 수 있다.
    - [X] Players 수와 갯수가 같지 않으면 예외를 반환한다.

- Height: 사다리 높이
    - [X] 1이상의 Height을 생성할 수 있다.
    - [X] 1보다 작을 경우 예외를 반환한다.

- GameResult: 참가자 전체 사다리 게임 결과
    - [X] LadderGame 결과를 Player 이름과, Reward 쌍으로 담을 수 있다.

- LadderGame: 사다리 게임
    - [X] Ladder를 생성할 수 있다.
    - [X] 참가자 한명에 대한 사다리 게임 실행 결과를 반환할 수 있다.
    - [X] 참가자 전체에 대한 사다리 게임 실행 결과를 반환할 수 있다. 

- Ladder: 사다리 판
    - [X] Height * Players 개의 Ladder를 생성할 수 있다.

- LadderLine: 사다리 게임 한 단계
    - [X] Players 만큼 Point를 생성 할 수 있다. 

- Point: LadderLine의 좌표 값과 Direction
    - [X] Direction에 따라 이동 한 뒤, 좌표값을 반환할 수 있다. (=move)

- Direction: 사다리 다리의 방향(왼쪽, 오른쪽 방향 존재 여부)
    - [X] 첫번째는 왼쪽 방향이 없는 상태로 Direction을 생성할 수 있다.
    - [X] RandomPointGenerationStrategy을 이용해 Direction을 생성할 수 있다.
    - [X] 마지막은 오른쪽 방향이 없는 상태로 Direction을 생성할 수 있다.

- PointGenerationStrategy, RandomPointGenerationStrategy: Point 생성 전략
    - [X] 무작위로 Point를 생성할 수 있다.

- InputView: 입력
    - [X] ,를 기준으로 참가자 이름을 입력받을 수 있다.
    - [X] Height을 입력받을 수 있다. 
    - [X] ,를 기준으로 실행 결과를 입력받을 수 있다.
    - [X] 결과를 보고 싶은 Player의 이름을 입력 받을 수 있다. 

- OutputView: 실행 결과 출력
    - [X] Players name을 출력할 수 있다.
    - [X] Ladder의 LadderLine을 `|-----|` 모양으로 출력할 수 있다.
    - [X] LadderGame 결과를 출력할 수 있다. 
