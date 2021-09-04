package step2.model;

import java.util.Arrays;

public enum Direction {
    RIGHT(false, true, 1),
    LEFT(true, false, -1),
    DOWN(false, false, 0);

    private boolean left;
    private boolean right;
    private int move;

    Direction(boolean left, boolean right, int move) {
        if (left && right) {
            throw new IllegalStateException();
        }

        this.left = left;
        this.right = right;
        this.move = move;
    }

    public static Direction findDirection(Point point) {
        return Arrays.stream(Direction.values())
                        .filter(direction -> isMatch(direction, point))
                        .findFirst()
                        .orElseThrow(IllegalStateException::new);
    }

    private static boolean isMatch(Direction direction, Point point) {
        return point.getLeft() == direction.left && point.getCurrent() == direction.right;
    }

    public int getMove() {
        return move;
    }
}
