package ladder.domain;


import ladder.strategy.MoveStratege;

public class Direction {
    private static final String ILLEGAL_DIRECTION_MESSAGE = "라인이 겹칠 수 없습니다.";
    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        validateDirection(left, right);

        this.left = left;
        this.right = right;
    }

    public static Direction firstDirectionOfPoint(MoveStratege moveStrategy) {
        return new Direction(false, moveStrategy.isMovable());
    }

    public Direction lastDirectionOfPoint() {
        return new Direction(right, false);
    }

    public Direction nextDirectionOfPoint(MoveStratege moveStrategy) {
        if (right) {
            return new Direction(true, false);
        }

        return new Direction(false, moveStrategy.isMovable());
    }

    public boolean canMoveNext() {
        return right;
    }

    public boolean canMovePrevious() {
        return left;
    }

    private void validateDirection(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException(ILLEGAL_DIRECTION_MESSAGE);
        }
    }

}
