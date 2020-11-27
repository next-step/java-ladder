## 기능 요구사항
- 사다리 게임에 참여하는 사람의 이름은 최대 5글자이다.
- 사다리를 출력할때 사람 이름도 같이 출력한다.
- 사람 이름의 구분은 쉼표를 기준으로 한다.
- 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야한다.
    - 가로라인이 겹치는 경우 어느 방향으로 이동할지 결정 할 수 없다.

## 프로그래밍 요구사항
- 자바 8의 스트림 람다를 적용한다.
- 모든 엔티티를 작게 유지한다.


## 힌트
- 2차원 배열을 ArrayList Generic을 적용해 구현하면 ArrayList<ArrayList<Boolean>> 과 같이 이해하기 어려운 코드가 된다.
- 사다리 게임에서 한 라인의 좌표값을 가지는 객체를 추가해 구현해 본다.

```java
public class Line{
    private List<Boolean> points = new ArrayList<>();
    
    public Line(int countOfPerson){
        //라인의 좌표값에 선이 있는지 유무를 판단하는 로직 추가
    }   
}
```
- 위와같이 Line객체를 추가하면 ArrayList<ArrayList<Boolean>> 코드를 ArrayList<Line>과 같이 구현하는게 가능해진다.


## 페어프로그래밍 설계

- 사람수 만큼 열 높이고 , 높이만큼 행으로 한다.
- 생각은 배열로 하되 , 리스트로한다.