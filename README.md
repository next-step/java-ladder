# 사다리 게임
## STEP1 기능 요구사항
* 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
* 사람 이름은 쉼표(,)를 기준으로 구분한다.
* 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
* 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
  * |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

## Ladder domain 설계
* 사다리(Ladder)는 사다리 라인들(List<LadderLine>)을 가진다.
* 사다리 라인(LadderLine)은 사다리 좌표들(List<Point>)를 가진다.
* 좌표(Point)는 index와 방향(Direction)을 가진다.
* 방향(Direction)은 left, right 방향을 가진다.

## Ladder domain 요구사항
* Direction은 왼쪽과 오른쪽은 겹칠 수 없다.
* n번째 Direction의 right는 n+1 번째 Direction의 left 이다.
* 첫번째 Point의 Direction.left은 항상 연결되지 않는다.
* 마지막 Point의 Direction.right는 항상 연결되지 않는다.

## 핵심 로직
* 유저 수를 입력받아 사다리를 생성한다.
* 사다리를 실행해 결과를 얻는다.
* 사다리 실행 결과와 게임정보를 입력받아 최종결과를 얻는다.
