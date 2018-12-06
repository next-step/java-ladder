package domain;

public class Point {

    private final int index;
    private final Direction direction;

    public Point(final int index, final Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
        if (direction.isRight()) return index + 1;
        if (direction.isLeft()) return index - 1;
        return this.index;
    }

    public static Point first(final Boolean rightMoved) {
        return new Point(0, Direction.first(rightMoved));
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    public Point next() {
        return new Point(index + 1, direction.next());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        if (direction.isRight()) {
            sb.append("|-----");
        } else {
            sb.append("|     ");
        }
        return sb.toString();
    }

}
