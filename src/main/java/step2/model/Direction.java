package step2.model;

import java.util.Arrays;

public enum Direction {
    RIGHT(false, true, 1),
    LEFT(true, false, -1),
    DOWN(false, false, 0);

    private boolean left;
    private boolean current;
    private int move;

    Direction(boolean left, boolean current, int move) {
        if (left && current) {
            throw new IllegalStateException();
        }

        this.left = left;
        this.current = current;
        this.move = move;
    }

    public boolean getCurrent() {
        return current;
    }

    public static Direction findDirection(boolean left, boolean current) {
        return Arrays.stream(Direction.values())
                        .filter(direction -> isMatch(direction, left, current))
                        .findFirst()
                        .orElseThrow(IllegalStateException::new);
    }

    private static boolean isMatch(Direction direction, boolean left, boolean current) {
        return left == direction.left && current == direction.current;
    }

    public int getMove() {
        return move;
    }
}
