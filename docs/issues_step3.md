# 3단계 - 사다리(게임 실행)
## Ladder - LadderGame 리팩토링
- LadderGame은 사다리에 대한 정보를 갖지 않음
  - Ladder의 사다리 정보에 Player, Result 정보를 결합
## Player 리팩토링
- Result는 Player가 갖는 상태라고 볼 수 있음
  - Player는 Result를 필드로 가짐
  - Player의 Result를 변경 -> Result가 변경된 새로운 Player를 반환
  - LadderGameResult는 Players를 필드로 가짐
  - Players는 입력 받은 String에 대한 Player를 반환