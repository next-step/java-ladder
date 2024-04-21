package ladder.domain.ladder.line;

public enum Direction {

    LEFT(-1),
    RIGHT(1),
    DOWN(0);

    private final int delta;

    Direction(final int delta) {
        this.delta = delta;
    }

    public int move(final int position) {
        return position + this.delta;
    }

    public static Direction of(final boolean isLeftConnected, final boolean isRightConnected) {
        if (isLeftConnected) {
            return Direction.LEFT;
        }

        if (isRightConnected) {
            return Direction.RIGHT;
        }

        return Direction.DOWN;
    }
}
