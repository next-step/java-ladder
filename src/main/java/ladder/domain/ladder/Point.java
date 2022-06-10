package ladder.domain.ladder;

public class Point {
    private final int idx;
    private Direction direction;

    public Point(int idx, Direction direction) {
        this.idx = idx;
        this.direction = direction;
    }

    public static Point first(boolean generate) {
        return new Point(0, new Direction(false, generate));
    }

    public Point next() {
        return new Point(idx + 1, direction.next());
    }

    public Point last() {
        return new Point(idx + 1, direction.last());
    }

    public int move() {
        if(direction.isRight()) {
            return idx + 1;
        }

        if(direction.isLeft()) {
            return idx - 1;
        }

        return this.idx;
    }

    public boolean isRight() {
        return direction.isRight();
    }
}
