package step2.domain;

public class Point {
    private static final int NEXT_INDEX = 1;
    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        if (direction.isLeft() && direction.isRight()) {
            throw new IllegalArgumentException("양 쪽으로 갈 수 없습니다.");
        }
        this.index = index;
        this.direction = direction;
    }

    public static Point first(int index, Direction direction) {
        return new Point(index, direction);
    }

    public static Point middle(Point point, BooleanGenerator booleanGenerator) {
        return new Point(point.index + NEXT_INDEX, Direction.middle(point.direction.isRight(), booleanGenerator));
    }

    public static Point last(Point point) {
        return new Point(point.index + NEXT_INDEX, Direction.last(point.direction.isRight()));
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

    public boolean hasLine() {
        return direction.isRight();
    }

}
