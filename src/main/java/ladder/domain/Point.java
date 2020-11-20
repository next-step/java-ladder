package ladder.domain;

public class Point {
    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    int move() {
        return index + direction.getMove();
    }

    private boolean isLeft() {
        return direction == Direction.LEFT;
    }

    @Override
    public String toString() {
        return isLeft()
                ? "-----|"
                : "     |";
    }
}
