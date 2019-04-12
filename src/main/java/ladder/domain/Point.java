package ladder.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Point {
    public static final int MOVE_POINT = 1;

    private int index;
    private Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first() {
        return new Point(0, Direction.first());
    }

    public Point next() {
        return new Point(index + MOVE_POINT, direction.next());
    }

    public int move() {
        if(direction.isRight()) {
            return index + MOVE_POINT;
        }

        if(direction.isLeft()) {
            return index - MOVE_POINT;
        }
        return this.index;
    }

    public boolean isRight() {
        return direction.isRight();
    }
}
