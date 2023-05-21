package ladder.domain;

import java.util.Objects;

public class Direction {

    private final boolean leftLine;
    private final boolean rightLine;

    public Direction(boolean leftLine, boolean rightLine) {
        checkValid(leftLine, rightLine);
        this.leftLine = leftLine;
        this.rightLine = rightLine;
    }

    public Direction createNext(LineStrategy lineStrategy) {
        if (rightLine) {
            return new Direction(true, false);
        }
        return new Direction(false, lineStrategy.add());
    }

    public Direction createLast() {
        if (rightLine) {
            return new Direction(true, false);
        }
        return new Direction(false, false);
    }

    public boolean hasLeftLine() {
        return leftLine;
    }

    public boolean hasRightLine() {
        return rightLine;
    }

    private static void checkValid(boolean leftLine, boolean rightLine) {
        if (leftLine && rightLine) {
            throw new IllegalArgumentException("가로 라인은 겹칠 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Direction direction = (Direction) o;
        return leftLine == direction.leftLine && rightLine == direction.rightLine;
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftLine, rightLine);
    }
}
