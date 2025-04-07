# 2단계 - 사다리 (생성)
## 사다리 구현
### Ladder
- 사다리 객체는 사다리의 높이와 폭을 가지고 있어야 한다.
### LadderLine
- 사다리 줄은 List<Boolean> 필드를 가진다
- 사다리의 폭은 사람 수보다 1 적다
- List<Boolean> 내부의 값은 사다리 줄이 있는지 없는지를 나타낸다.
### LadderLineGenerator
- 내부에서 상태를 가지고 있을 필요가 없어서 static 메소드 제공하는 형태로 구현
### LadderGame
- 참여 인원, 사다리 높이를 입력받아 사다리 객체를 생성한다.
### Player
- isEmpty vs. isBlank
  - isEmpty는 문자열의 길이가 0일 경우 true
  - isBlank는 문자열이 비어있거나 공백으로만 이루어져 있을 경우 true
## IntelliJ
- 신규 파일 생성 시 Github 자동 추가
  - 버전 관리 -> 확인
