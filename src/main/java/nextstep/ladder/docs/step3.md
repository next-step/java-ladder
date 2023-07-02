1. 참여할 사람들 이름을 입력받는다
2. !사다리별 실행 결과를 입력받는다
3. 최대 사다리 개수를 입력받는다
4. !사다리 실행 결과를 출력한다
5.
- !개인별 이름을 입력하면 개인별 결과를 출력한다
- !`all`을 입력받으면 전체 참여자의 실행 결과를 출력한다

!는 변경해야하는 내용

# Attributes
## Service
- Main

## domain
- !Player
  - PlayerName
  - !int order
  - !String result
- !Players
  - !Map<PlayerName, Player> players
- !Referee
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

## Presentation
- InputView
- ResultView

# Notes
Players에서 Set<Player>로 players를 구현하고, PlayerName으로도 Player를 찾을 수 있도록 Player를 equals와 hashcode 구현에 PlayerName만 사용하도록 한다
  - 보편적으로 기대하는 상황이 아니기 때문에 문제가 발생할 수도 있을 듯  
vs  
Map<PlayerName, Player>로 players를 구현해서 Player.playerName으로 Player를 찾을 수 있도록 한다
=> 후자쪽이 조금 더 문제가 발생할 일이 적을 것으로 보임

PlayerNames를 List로 변경한다. 사용자는 입력받은 순서대로 이름이 입력되길 기대할 것. Set을 사용했을 때 입력한 순서대로 보장하지도 않고, 어차피 출력 과정에서 선형탐색하기 때문에 성능적인 이점도 없음  

Players는 order에 의해 정렬되어야 함