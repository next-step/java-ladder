# 사다리 타기
## Step 2
### 기능 요구 사항
* 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
* 사람 이름은 쉼표(,)를 기준으로 구분한다.
* 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
* 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
* |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

### 힌트
* 2차원 배열을 ArrayList, Generic을 적용해 구현하면 ArrayList<ArrayList<Boolean>>와 같이 이해하기 어려운 코드가 추가된다.
* 사다리 게임에서 한 라인의 좌표 값을 가지는 객체를 추가해 구현해 본다.
```java
public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line (int countOfPerson) {
        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
    }

    [...]
}
```
* 위와 같이 Line 객체를 추가하면 ArrayList<ArrayList<Boolean>> 코드를 ArrayList<Line>과 같이 구현하는 것이 가능해 진다.

* Model
    * Member
        [x] Member 는 게임에 참여하는 멤버
        [x] 이름의 최대 글자수는 다섯 글자이다.
    * Members
        [x] Members 는 member 의 일급 컬렉션이다.
    * LadderGame
        [x] LadderGame 은 사다리 게임 클래스이다.
        [x] 외부에서 입력되는 LadderHeight 을 받아서 Ladder 를 생성한다.
    * LadderHeight
        [x] LadderHeight 는 외부에서 입력되는 숫자로 LadderHeight 를 생성한다. 
    * Ladder
        [x] Ladder 는 사다리 클래스이다.
        [x] Line 을 가지고 있다.
    * LadderLine
        [x] LadderLine 은 사다리의 한 라인을 의미하는 클래스이다.
        [x] LadderBridge 를 가지고 있다. 
    * LadderBridge
        [x] LadderBridge 는 enum class 이다.
        [x] Bridge 가 Exist 인지 Not Exist 인지 상태를 가지고 있다.
        [x] 이전 Bridge 에 따라, 현재 Bridge 를 만든다.
    
    
* View
    * InputView
    * OutputView

* Main