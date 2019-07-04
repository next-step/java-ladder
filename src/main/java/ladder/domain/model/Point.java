package ladder.domain.model;

public class Point {
    private static final Point empty = new Point(Index.of(0), Direction.empty());

    private Index index;
    private Direction direction;

    private Point(Index index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point of(Index index, Direction direction) {
        return new Point(index, direction);
    }

    public static Point empty() {
        return empty;
    }

    public Index getIndex() { return index; }

    public boolean isLeft() { return direction.isLeft(); }

    public boolean isRight() { return direction.isRight(); }

    public boolean isStartPoint() {
        return index.isStartIndex();
    }

    public boolean isSamePoint(int index) {
        return this.index.isSameIndex(index);
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", direction=" + direction +
                '}';
    }
}
