package nextstep.ladder.domain;

public class Movement {
    private static final int ZERO = 0;

    private final boolean left;
    private final boolean right;

    private Movement(boolean left, boolean right) {
        this.validateMovement(left, right);
        this.left = left;
        this.right = right;
    }

    private void validateMovement(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("both left and right can not be true");
        }
    }

    public static Movement first(MovementGenerator movementGenerator) {
        return new Movement(false, movementGenerator.isMove());
    }

    public static Movement of(Movement prevMovement, MovementGenerator movementGenerator) {
        boolean left = prevMovement.isRight();
        if (left) {
            return new Movement(prevMovement.isRight(), false);
        }

        return new Movement(prevMovement.isRight(), movementGenerator.isMove());
    }

    public static Movement last(Movement prevMovement) {
        return new Movement(prevMovement.isRight(), false);
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
}
