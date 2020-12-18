package ladder.domain;

import java.util.Random;

public class Point {

    private final static String LADDER_CAN_NOT_BE_CONSECUTIVE = "The ladder cannot be consecutive.";
    private final int index;
    private final Direction direction;
    private final boolean left;
    private final boolean right;

    public Point(int index, boolean left, boolean right) {
        valid(left, right);
        this.index = index;
        this.left = left;
        this.right = right;
    }

    private void valid(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException(LADDER_CAN_NOT_BE_CONSECUTIVE);
        }
    }

    public static Point of(Point previous) {
        if (previous.right) {
            return new Point(previous.index + 1, true, false);
        }
        return new Point(previous.index + 1, false, new Random().nextBoolean());
    }

    public static Point firstOf() {
        return new Point(0, false, new Random().nextBoolean());
    }

    public static Point lastOf(Point previous) {
        if (previous.right) {
            return new Point(previous.index + 1, true, false);
        }
        return new Point(previous.index + 1, false, false);
    }

    public int move() {
        if (Boolean.TRUE.equals(left)) {
            return moveLeft();
        }

        if (Boolean.TRUE.equals(right)) {
            return moveRight();
        }
        return index;
    }

    private int moveLeft() {
        return index - 1;
    }

    private int moveRight() {
        return index + 1;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }
}
