# 사다리 게임
## 진행 방법
* 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
* 사람 이름은 쉼표(,)를 기준으로 구분한다.
* 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
* 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
    * |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

## 프로그래밍 요구사항
* 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
* 규칙 6: 모든 엔티티를 작게 유지한다.

# step2
[O]InputView 구현
- 5글자 이상 일때 exception
[O]ResultView 구현
 - Ladder 객체 출력시 사람이름도 출력..
   
-> Ladder 역할 책임
최대 사다리 높이와 입력한 사람 수만큼 Line 들을 생성
Line 한테 그려졌니 ? 그려졌으면 안그릴라고 메세지 물어보는 역할!
[O] List<Line>
[O] Ladder 의 Line 이 몇줄 있니? 메세지
[O] Ladder 의 참가자가 몇명 이니 ? 메세지 
[O] 외부에서 havePoints 메세지 보내면 라인한테 협력함.

-> Line 역할 과 책임
참가한 사람의 갯수 와 사다리 높이 만큼 생성 되어야 한다.
line은 상태를 가진다. 그린 라인인지  안그린 라인인지.
line은 생성 될 때, 즉 한 줄이 그려질 때는 랜덤하게 그려야 함 ,
인접하는하는 선에 그린 적이 있으면 안그린다. 
[O] 생성 시 random 하게 생성 로직
[O] 생성 시 인접에 생성됬는지 판단 로직
[O] Line이 Points 를 가지고 있니 없니 메세지 구현

[O] 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
--------------------------------------------------------------------
# step3

##기능 요구사항
* 사다리 실행 결과를 출력해야 한다.
* 개인별 이름을 입력하면 개인별 결과를 출력하고, "all"을 입력하면 전체 참여자의 실행 결과를 출력한다.
##프로그래밍 요구사항
* 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
* 규칙 6: 모든 엔티티를 작게 유지한다.
* 규칙 7: 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.

[O] 실행 결과 InputView 구현
[O] 결과 담는 Results 객체 구현
[O] 실행 결과 사다리에 ResultView 구현
[O] 결과를 보고 싶은 사람은? InputView 구현
[X] 사람 선택 -> 사다리 move -> 결과 순서로 협력
참가자들 한테 물어본다-> 메세지(이 사람?) 
그러면 참가자들은 번호를 알려줌->메세지(2번째 참가자)
번호를 사다리한테 전달하면(번호)-> 사다리가 move 하고 결과 번호를 return
결과 번호를 결과들한테 물어보면 결과 알려줌
[X] 결과 구현