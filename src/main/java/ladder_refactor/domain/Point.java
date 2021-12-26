package ladder_refactor.domain;

public class Point {

    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
        if (direction.isLeft()) {
            return index - 1;
        }

        if (direction.isRight()) {
            return index + 1;
        }

        return index;
    }

    public Point next() {
        return new Point(index + 1, direction.next());
    }

    public static Point first(Boolean right) {
        return new Point(0, Direction.first(right));
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Point{");
        sb.append("index=").append(index);
        sb.append(", direction=").append(direction);
        sb.append('}');
        return sb.toString();
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }
}
