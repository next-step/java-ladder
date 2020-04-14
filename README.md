# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## 구현 설계

### Domain
- Position class
  - int position property
  - isAdjacent method
  - isFirst method : void -> boolean
  - getLeft method : void -> Position
  
- Name class
  - String name property
  
- Player class
  - Position position property
  - Name name property
  - isAdjacent method : Player -> boolean
  
- Players class
  - List<Player> players property
  
- LadderLine class
  - Map<Position, Position> movingRule property
  - move method : Position -> Position
  - getWidth method : void -> int
  
- Ladder class
  - List<LadderLine> ladderLines property
  - ride method : Player -> Player
  - ride method : Players -> Players
  
- Prize class
  - String prize property
  
- PrizeSheet class
  - Map<Position, Prize> prizeSheet property
  - checkPrize method : Player -> Prize
  - produceResult : Players -> ResultSheet
  
- ResultSheet class
  - Map<Name, Prize> resultSheet property
  - checkResult method : String -> Prize
  
- LadderGame class
  - Ladder ladder property
  - PrizeSheet prizeSheet property
  - play method : Players -> ResultSheet