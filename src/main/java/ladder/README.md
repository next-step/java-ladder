#사다리

기능 목록

### Gamer

- 사다리 게임 참여자 (최대 5자, nonnull, nonEmpty, LadderNo)
- LadderNo 갖고 있음.

### Gamers

- 게임참여자 리스트 일급 컬렉션 (시작 시 각 LadderNo 는 순서대로 되어있어야 함.)

### Line

- 사다리 가로 줄
  - List<Boolean> 사다리사이의 bar 들이 있는지 리스트
  - move(LadderNo Number)
  
### LineMaker

- 라인의 bar 들 랜덤으로 배치 해주는 메이커 클래스

### Ladder

- 생성자로 Gamers 받기
- 라인 리스트 일급 컬렉션
- LadderResultDto(LadderResult candidateResult)

### LadderNo

- 사다리 번호 mutable
  - int getNo()
  
### LadderResult

- 사다리 결과 String 리스트 일급 컬렉션

### LadderResultDto

- 사다리 전체 결과 값들 map
- key = gamerName, value = resultString