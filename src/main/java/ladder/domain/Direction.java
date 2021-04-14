package ladder.domain;

public class Direction {

    private static final boolean LINE = true;
    private static final boolean EMPTY = false;

    private final boolean hasLeftLine;
    private final boolean hasRightLine;

    public Direction(boolean hasLeftLine, boolean hasRightLine) {
        validate(hasLeftLine, hasRightLine);
        this.hasLeftLine = hasLeftLine;
        this.hasRightLine = hasRightLine;
    }

    private void validate(boolean hasLeftLine, boolean hasRightLine) {
        if (hasLeftLine && hasRightLine) {
            throw new IllegalStateException("한 쪽의 방향만 입력할 수 있습니다.");
        }
    }

    public boolean hasLeftLine() {
        return hasLeftLine;
    }

    public boolean hasRightLine() {
        return hasRightLine;
    }

    public static Direction first(boolean right) {
        return new Direction(EMPTY, right);
    }

    public Direction next(boolean right) {
        if (this.hasRightLine) {
            return new Direction(LINE, EMPTY);
        }
        return new Direction(EMPTY, right);
    }
}
