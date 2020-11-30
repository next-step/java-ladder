package nextstep.ladder.domain;

public class Point {
    private final int index;
    private final Direction direction;

    private Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(boolean right) {
        return new Point(0, Direction.first(right));
    }

    public Point next() {
        return new Point(index + 1, direction.next());
    }

    public Point next(boolean nextRight) {
        return new Point(index + 1, direction.next(nextRight));
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    /**
     * @return 다음(아래) Point의 index 반환
     */
    public int move() {
        if (direction.isLeft()) {
            return index - 1;
        }

        if (direction.isRight()) {
            return index + 1;
        }

        return index;
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", direction=" + direction +
                '}';
    }
}
