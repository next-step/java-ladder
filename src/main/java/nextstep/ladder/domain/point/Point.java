package nextstep.ladder.domain.point;

public class Point {

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
            return this.position + 1;
        }

        if (this.direction.isLeft()) {
            return this.position - 1;
        }

        return this.position;
    }
}
