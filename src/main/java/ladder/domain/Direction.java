package ladder.domain;

public class Direction {

    private static final boolean LINE = true;
    private static final boolean EMPTY = false;

    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        validate(left, right);
        this.left = left;
        this.right = right;
    }

    private void validate(boolean hasLeftLine, boolean hasRightLine) {
        if (hasLeftLine && hasRightLine) {
            throw new IllegalStateException("한 쪽의 방향만 입력할 수 있습니다.");
        }
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public static Direction first(boolean right) {
        return new Direction(EMPTY, right);
    }

    public Direction next(boolean right) {
        if (this.right) {
            return new Direction(LINE, EMPTY);
        }
        return new Direction(EMPTY, right);
    }

    public Direction last() {
        return new Direction(this.right, EMPTY);
    }
}
