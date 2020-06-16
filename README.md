# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## 기능
### step2
- 사람 이름 입력받기
    - 사람의 이름은 최대 5글자
    - 사람 이름은 쉼표를 기준으로 구분
    ```
    참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)
    pobi,honux,crong,jk
    ```
- 최대 사다리 높이 입력받기
    ```
    최대 사다리 높이는 몇 개인가요?
    5
    ```
- 사다리 라인 그리기
    - 사다리의 라인이 `|-----|-----|`처럼 겹치면 안 된다. 
    - 사다리의 라인을 랜덤하게 그린다.
- 사다리 출력하기
    - 사람 이름도 같이 출력
    - 사람 이름이 겹치지 않도록 사다리의 폭이 넓어야 한다.
    ```
    실행결과
    
    pobi  honux crong   jk
        |-----|     |-----|
        |     |-----|     |
        |-----|     |     |
        |     |-----|     |
        |-----|     |-----|
    ```
  
### step3
- 사다리 결과 입력받기
    ```
    참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)
    pobi,honux,crong,jk
    
    실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)
    꽝,5000,꽝,3000
    
    최대 사다리 높이는 몇 개인가요?
    5
    ```

- 사다리 결과 출력하기
    - 개인별 이름을 입력하면 개인별 결과를 출력
    - "all"을 입력하면 전체 참여자의 결과를 출력
    ```
    사다리 결과
    
    pobi  honux crong   jk
        |-----|     |-----|
        |     |-----|     |
        |-----|     |     |
        |     |-----|     |
        |-----|     |-----|
    꽝    5000  꽝    3000
        
    결과를 보고 싶은 사람은?
    pobi
    
    실행 결과
    꽝
    
    결과를 보고 싶은 사람은?
    all
    
    실행 결과
    pobi : 꽝
    honux : 3000
    crong : 꽝
    jk : 5000
    ```
  
### step4
아래의 객체 설계 힌트를 참고하여 TDD로 재구현한다.

```
public class LadderLine {
    private final List<Point> points;

    public static LadderLine init(int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        point = initBody(sizeOfPerson, points, point);
        initLast(points, point);
        return new LadderLine(points);
    }

    private static Point initFirst(List<Point> points) {
        Point point = Point.first(LadderPointGenerator.generatePoint());
        points.add(point);
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    public int move(int position) {
        return points.get(position).move();
    }
}
```

```
public class Point {
    private final int index;
    private final Direction direction;

    public static Point first(Boolean right) {
        return new Point(0, Direction.first(right));
    }

    public int move() {
        if (direction.isRight()) {
            return index + 1;
        }

        if (direction.isLeft()) {
            return index - 1;
        }

        return index;
    }

    public Point next() {
        return new Point(index + 1, direction.next());
    }

    public Point next(Boolean right) {
        return new Point(index + 1, direction.next());
    }
}
```

```
public class Direction {
    private final boolean left;
    private final boolean right;

    public Direction next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public Direction next() {
        if (this.right) {
            return next(false);
        }

        return next(LadderPointGenerator.generatePoint());
    }
}
```

  
## 프로그래밍 요구사항
- 자바8 스트림과 람다를 사용한다.
- 모든 엔티티를 작게 유지한다.
- 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
