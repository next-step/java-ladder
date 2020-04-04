#사다리

기능 목록

- 사다리 게임 참여자 (최대 5자, nonnull, nonEmpty, LadderNo)
- 게임참여자 리스트 일급 컬렉션 (시작 시 각 LadderNo 는 순서대로 되어있어야 함.)
- 라인 (사다리 가로 줄)
  - 왼쪽으로 갈 지 오른쪽으로 갈 지 제자리에 있을 지 선택하는 Enum list
  - move(LadderNo Number)
- 사다리 번호 mutable
  - VerticalNo
  - int getNo()
