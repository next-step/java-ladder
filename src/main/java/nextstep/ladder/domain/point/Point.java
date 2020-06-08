package nextstep.ladder.domain.point;

public class Point {

    private static final int RIGHT_POSITION = 1;
    private static final int LEFT_POSITION = -1;

    private final int position;
    private final Direction direction;

    public Point(int position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public static Point first(PointGenerator pointGenerator) {
        return new Point(0, Direction.first(pointGenerator));
    }

    public Point last() {
        return new Point(this.position + 1, direction.last());
    }

    public Point next(PointGenerator pointGenerator) {
        return new Point(this.position + 1, direction.next(pointGenerator));
    }

    public boolean isValid(Point pre) {
        return this.direction.isValid(pre.direction);
    }

    public boolean isRight() {
        return this.direction.isRight();
    }

    public int move() {
        if (this.direction.isRight()) {
            return this.position + RIGHT_POSITION;
        }

        if (this.direction.isLeft()) {
            return this.position + LEFT_POSITION;
        }

        return this.position;
    }
}
