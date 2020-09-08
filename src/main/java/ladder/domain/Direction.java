package ladder.domain;

public enum Direction {

    LEFT(-1),
    RIGHT(1),
    NONE(0);

    private static final boolean BLOCK = false;

    private final int moveIndex;

    Direction(int moveIndex) {
        this.moveIndex = moveIndex;
    }

    public static Direction of(Direction prevDirection, boolean hasDirection) {

        if (prevDirection.isRight()) {
            return Direction.LEFT;
        }

        if (hasDirection) {
            return Direction.RIGHT;
        }

        return Direction.NONE;
    }

    public static Direction leftCorner(boolean right) {
        return of(Direction.NONE, right);
    }

    public static Direction rightCorner(Direction prevDirection) {
        return of(prevDirection, BLOCK);
    }

    public boolean isRight() {
        return this == Direction.RIGHT;
    }

    public int move() {
        return moveIndex;
    }
}
