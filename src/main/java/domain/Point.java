package domain;

public class Point {
    private final int position;
    private final Direction direction;

    public Point(int position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public int move() {
        if (direction == Direction.RIGHT) {
            return position + 1;
        }

        if (direction == Direction.LEFT) {
            return position - 1;
        }

        return this.position;
    }

    public static Point first(Movable right) {
        return new Point(0, Direction.first(right));
    }

    public Point last() {
        return new Point(position + 1, direction.last());
    }

    public Point next(Movable right) {
        return new Point(position + 1, direction.next(right));
    }

    public boolean hasIndex(int index) {
        return this.position == index;
    }

    public boolean hasDirection(Direction direction) {
        return this.direction.equals(direction);
    }

    public boolean hasNoneDirection() {
        return this.direction.equals(Direction.NONE);
    }

    public boolean hasMoveDirection() {
        return !hasNoneDirection();
    }

    @Override
    public String toString() {
        return "Point{" +
                "position=" + position +
                ", direction=" + direction +
                '}';
    }
}