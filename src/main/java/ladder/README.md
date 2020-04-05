#사다리

기능 목록

- 사다리 게임 참여자 (최대 5자, nonnull, nonEmpty, LadderNo)
- 게임참여자 리스트 일급 컬렉션 (시작 시 각 LadderNo 는 순서대로 되어있어야 함.)
- 라인 (사다리 가로 줄)
  - List<Boolean> 사다리사이의 bar 들이 있는지 리스트
  - move(LadderNo Number)
- 라인 메이커 (라인의 bar 들 랜덤으로 배치 해주는 메이커 클래스)
- 레더 (라인 리스트 일급 컬렉션)
- 사다리 번호 mutable
  - ladderNo
  - int getNo()
