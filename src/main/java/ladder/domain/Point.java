package ladder.domain;

public class Point {
    private static final int FIRST_INDEX = 0;

    private final int index;
    private final Direction direction;

    private Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public boolean isLeft() {
        return direction.isLeft();
    }

    public boolean isRight() {
        return direction.isRight();
    }

    // 테스트용
    public static Point of(int index, boolean left, boolean right) {
        Direction direction = Direction.of(left, right);

        return new Point(index, direction);
    }

    public static Point getFirst(boolean right) {
        return new Point(FIRST_INDEX, Direction.getFirst(right));
    }

    public static Point getLast(int index, boolean left) {
        return new Point(index, Direction.getLast(left));
    }

    public Point next(boolean nextRight) {
        Direction nextDirection = direction.next(nextRight);
        return new Point(index + 1, nextDirection);
    }

    public int move() {
        int nextIndex = index;

        if (direction.isRight()) {
            nextIndex++;
        }

        if (direction.isLeft()) {
            nextIndex--;
        }

        return nextIndex;
    }
}
