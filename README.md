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
- Direction class
  - boolean left property
  - boolean right property
  - isRight method : void -> boolean
  - isLeft method : void -> boolean
  
- Point class
  - int index property
  - Direction direction property
  - move method : void -> int
  - hasLeftLeg : void -> boolean
  
- Name class
  - String name property
  
- Player class
  - Name name property
  - int position property
  - ride method : Ladder -> void
  
- Players class
  - List<Player> players property
  - ride method : Ladder -> void
  - produceResult : Ladder, PrizeSheet -> ResultSheet
  - print method : void -> void

- LadderLine class
  - List<Point> points property
  - move method : int -> int
  - print method : void -> void
  
- Ladder class
  - List<LadderLine> ladderLines property
  - move method : int -> int
  - print method : void -> void
  
- Prize class
  - String prize property
  
- PrizeSheet class
  - List<Prize> prizes property
  - getSize method : void -> int
  - get method : int -> Prize
  - print method : void -> void
  
- ResultSheet class
  - Map<String, Prize> resultSheet property
  - checkResult method : String -> Prize
  - print method : void -> void
  