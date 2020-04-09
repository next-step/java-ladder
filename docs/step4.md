# 4단계 - 사다리(리팩토링)

## 기능 요구사항
- 기능 요구사항 3단계와 같다.
- 추가로 제공되는 객체 설계 힌트를 참고해 철저하게 TDD로 재구현해 본다.

## 실행 결과
- 위 요구사항에 따라 4명의 사람을 위한 5개 높이 사다리를 만들 경우, 프로그램을 실행한 결과는 다음과 같다.
```
참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)
pobi,honux,crong,jk

실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)
꽝,5000,꽝,3000

최대 사다리 높이는 몇 개인가요?
5

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

## 객체 추출 힌트
### 사다리 한 Line 추상화
- 사다리 게임에서 한 Line을 LadderLine으로 이름을 붙이고 다음과 같이 구현
- 사다리 Line의 모든 Point 초기화와 이동을 담당

```java
import java.util.ArrayList;
import java.util.List;

import static codesquad.LadderPointGenerator.generatePoint;

public class LadderLine {
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public static LadderLine init(int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        point = initBody(sizeOfPerson, points, point);
        initLast(points, point);
        return new LadderLine(points);
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

    private static Point initFirst(List<Point> points) {
        Point point = Point.first(generatePoint());
        points.add(point);
        return point;
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }
}
```
<br>

- LadderLine에 대한 테스트 코드는 다음과 같다.
```java
public class LadderLineTest {
    @Test
    public void init() {
        int sizeOfPerson = 5;
        System.out.println(LadderLine.init(sizeOfPerson));
    }

    @Test
    public void move() {
        LadderLine line = LadderLine.init(2);
        System.out.println("ladder result : " + line.move(0));
    }
}
```
<br>

- LadderLine의 두 점과 현재 위치를 Point로 추상화
- LadderLine에서 위치와 각 점의 방향을 관리

```java
public class Point {
    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
        System.out.println("is left? " + direction.isLeft());
        System.out.println("is right? " + direction.isRight());

        if (direction.isRight()) {
            return index + 1;
        }

        if (direction.isLeft()) {
            return index - 1;
        }

        return this.index;
    }

    public Point next() {
        return new Point(index + 1, direction.next());
    }

    public Point next(Boolean right) {
        return new Point(index + 1, direction.next(right));
    }
		
    public Point last() {
        return new Point(index + 1, direction.last());
    }

    public static Point first(Boolean right) {
        return new Point(0, Direction.first(right));
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", direction=" + direction +
                '}';
    }
}
```
<br>

- Point에 대한 테스트 코드는 다음과 같다.
```java
import org.junit.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PointTest {
    @Test
    public void first() {
        assertThat(Point.first(TRUE).move(), is(1));
        assertThat(Point.first(FALSE).move(), is(0));
    }

    @Test
    public void next_stay() {
        Point second = Point.first(FALSE).next(FALSE);
        assertThat(second.move(), is(1));
    }

    @Test
    public void next_left() {
        Point second = Point.first(TRUE).next(FALSE);
        assertThat(second.move(), is(0));
    }

    @Test
    public void next_right() {
        Point second = Point.first(FALSE).next(TRUE);
        assertThat(second.move(), is(2));
    }

    @Test
    public void next() {
        Point second = Point.first(TRUE).next();
        assertThat(second.move(), is(0));
    }
}
```
<br>

### 각 Point의 좌/우 방향을 Direction으로 추상화
- 각 Point의 좌/우 방향 정보를 가진다.
- 현재 Point에서 다음 Point를 생성하는 역할
```java
import java.util.Objects;

import static codesquad.LadderPointGenerator.generatePoint;
import static java.lang.Boolean.FALSE;

public class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException();
        }

        this.left = left;
        this.right = right;
        System.out.println(this);
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public Direction next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public Direction next() {
        if (this.right) {
            return next(FALSE);
        }
        return next(generatePoint());
    }

    public static Direction of(boolean first, boolean second) {
        return new Direction(first, second);
    }

    public static Direction first(boolean right) {
        return of(FALSE, right);
    }
		
    public Direction last() {
        return of(this.right, FALSE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction pair = (Direction) o;
        return left == pair.left &&
                right == pair.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return "Direction{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}

```
<br>

- Direction에 대한 테스트 코드는 다음과 같다.
```java
import org.junit.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DirectionTest {
    @Test
    public void init() {
        assertThat(Direction.of(true, false), is(Direction.of(true, false)));
    }

    @Test(expected = IllegalStateException.class)
    public void init_invalid() {
        Direction.of(TRUE, TRUE);
    }

    @Test
    public void next_random_true() {
        Direction next = Direction.first(TRUE).next();
        assertThat(next, is(Direction.of(TRUE, FALSE)));
    }

    @Test
    public void next_random_false() {
        for (int i = 0; i < 100; i++) {
            Direction.first(FALSE).next();
        }
    }

    @Test
    public void next_true() {
        Direction next = Direction.of(TRUE, FALSE).next(TRUE);
        assertThat(next, is(Direction.of(FALSE, TRUE)));
    }

    @Test
    public void next_false() {
        Direction next = Direction.of(FALSE, TRUE).next(FALSE);
        assertThat(next, is(Direction.of(TRUE, FALSE)));
    }

    @Test
    public void first() {
        Direction first = Direction.first(TRUE);
        assertThat(first.isLeft(), is(FALSE));
    }

    @Test
    public void last() {
        Direction last = Direction.first(TRUE).last();
        assertThat(last, is(Direction.of(TRUE, FALSE)));
    }
}
```