package nextstep.ladder.domain.ladder;

public class Direction {
    private static final boolean NO_RIGHT_WHEN_IS_LAST_OR_LEFT_EXIST = false;
    private static final boolean FIRST_LEFT_DIRECTION = false;
    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean left, boolean right) {
        validateHasBothDirection(left, right);
        return new Direction(left, right);
    }

    public static Direction first(boolean right) {
        return of(FIRST_LEFT_DIRECTION, right);
    }

    private static void validateHasBothDirection(boolean left, boolean right) {
        if (left && right) {
            throw new InvalidDirectionException();
        }
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public Direction next(boolean isLast, boolean right) {
        if (isLast || isRight()) {
            return new Direction(this.right, NO_RIGHT_WHEN_IS_LAST_OR_LEFT_EXIST);
        }
        return new Direction(this.right, right);
    }

    public static Direction last(boolean left) {
        return new Direction(left, NO_RIGHT_WHEN_IS_LAST_OR_LEFT_EXIST);
    }
}
