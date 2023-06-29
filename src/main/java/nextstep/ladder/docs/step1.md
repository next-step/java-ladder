1. 참여할 사람들 이름을 입력받는다 (Player)
2. 최대 사다리 개수를 입력받는다
3. 실행 결과를 출력한다

### Service
- Game

## domain
- PlayerName
  - String name
- PlayerNames
  - Set\<PlayerName>
- Ladder
  - Map\<LadderPoint, LadderStatus>
- LadderPoint
  - Row
  - Column
- Row
- Column
- LadderBarStatus(e)
  - EMPTY / BAR

### Presentation
- InputView
- ResultView