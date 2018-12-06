package ladder.domain;

import static ladder.domain.DirectionSelection.of;

public class Point {

    private static final int DEFAULT_ZENO = 0;
    private static final int DEFAULT_ONE = 1;
    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
        return of(direction.isLeft(), direction.isRight()).move(index);
    }

    public static Point first(Boolean right) {
        return new Point(DEFAULT_ZENO, Direction.first(right));
    }

    public Point next(Difficulty difficulty) {
        return new Point(index + DEFAULT_ONE, direction.next(difficulty));
    }

    public Point next(Boolean right) {
        return new Point(index + DEFAULT_ONE, direction.next(right));
    }

    public Point last() {
        return new Point(index + DEFAULT_ONE, direction.last());
    }

    @Override
    public String toString() {
        if (direction.isRight())
            return "|-----";
        return "|     ";
    }
}
