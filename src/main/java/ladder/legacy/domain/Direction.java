package ladder.legacy.domain;

import static ladder.utils.RandomBoolGenerator.generate;

public class Direction {
    private static final int LEFT = -1;
    private static final int RIGHT = 1;
    private static final int STAY = 0;

    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("연속으로 다리를 만들 수 없습니다.");
        }
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public static Direction of(boolean left) {
        if (left) {
            return new Direction(true, false);
        }
        return new Direction(false, generate());
    }

    public boolean getRight() {
        return right;
    }

    public boolean getLeft() {
        return left;
    }

    public Direction getNext() {
        if (right) {
            return new Direction(true, false);
        }
        return new Direction(false, generate());
    }

    public int getDirection() {
        if (left) {
            return LEFT;
        }
        if (right) {
            return RIGHT;
        }
        return STAY;
    }
}
