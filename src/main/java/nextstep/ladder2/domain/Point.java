package nextstep.ladder2.domain;

public class Point {

    private static final int FIRST_INDEX = 0;
    private static final int PLUS_INDEX = 1;

    private final Direction direction;
    private int index;


    public Point(Direction direction, int index) {
        this.direction = direction;
        this.index = index;
    }

    public static Point first(boolean right) {
        return new Point(Direction.first(right), FIRST_INDEX);
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

    public Point next(boolean right) {
        return new Point(direction.next(right), index + PLUS_INDEX);
    }

    public Point next() {
        return new Point(direction.next(), index + PLUS_INDEX);
    }

    public Point last() {
        return new Point(direction.last(), index + PLUS_INDEX);
    }

    public boolean isRight() {
        return direction.isRight();
    }
}
