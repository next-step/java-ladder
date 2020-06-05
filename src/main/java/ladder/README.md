## 사다리 게임 구현 기능 목록

### Domain

* Player
    * 게임 참가자 객체
    * 이름에 대한 예외 처리
        * 이름이 NULL이거나 빈 문자열이거나 5자를 넘는 경우 예외 발생

* PlayersGroup
    * 게임 참가지 객체의 리스트(List<Player>) 일급 컬렉션
    * 참가자 객체의 이름 목록을 파라미터로 받아 객체 생성

### View

* InputView
    * 쉼표로 구분되는 게임 참가자(Player) 명단을 입력 받음.
    * 사다리 높이를 입력 받음.
    
### Application
