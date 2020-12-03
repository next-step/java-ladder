package nextstep.ladder2;

class Direction {
    private static final Direction LEFT = new Direction(true, false);
    private static final Direction RIGHT = new Direction(false, true);
    private static final Direction NEUTRAL = new Direction(false, false);
    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException();
        }
        if (left) {
            return LEFT;
        }
        if (right) {
            return RIGHT;
        }
        return NEUTRAL;
    }

    public static Direction first(boolean right) {
        return of(false, right);
    }

    public Direction last() {
        return of(right, false);
    }

    public Direction next(boolean right) {
        return of(this.right, right);
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }
}
