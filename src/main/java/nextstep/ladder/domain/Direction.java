package nextstep.ladder.domain;

public class Direction {
    private static final int ZERO = 0;

    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        this.validateDirection(left, right);
        this.left = left;
        this.right = right;
    }

    private void validateDirection(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("both left and right can not be true");
        }
    }

    public static Direction first(MovementGenerator movementGenerator) {
        return new Direction(false, movementGenerator.isMove());
    }

    public static Direction of(Direction prevDirection, MovementGenerator movementGenerator) {
        boolean availableMoveRight = prevDirection.isRight();
        if (availableMoveRight) {
            return new Direction(true, false);
        }

        return new Direction(false, movementGenerator.isMove());
    }

    public static Direction last(Direction prevDirection) {
        return new Direction(prevDirection.isRight(), false);
    }

    public int move() {
        if (this.left) {
            return -1;
        }

        if (this.right) {
            return 1;
        }

        return ZERO;
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public Direction next(MovementGenerator movementGenerator) {
        if (this.right) {
            return new Direction(true, false);
        }
        return new Direction(false, movementGenerator.isMove());
    }
}
