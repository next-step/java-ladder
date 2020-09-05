package ladder.domain;

import static ladder.utils.RandomBoolGenerator.generate;

public class Direction {

    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("연속으로 다리를 만들 수 없습니다.");
        }
        return new Direction(left, right);
    }

    public static Direction of(boolean left) {
        return new Direction(left, !left);
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
}
