package nextstep.ladder.step4;


import static nextstep.ladder.step4.LadderPointGenerator.generatePoint;

public class Direction {
    public static final String INVALID_STATE_ERR_MSG = "Direction의 left와 right가 모두 true일 수 없습니다.";
    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException(INVALID_STATE_ERR_MSG);
        }

        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public static Direction first(boolean right) {
        return Direction.of(false, right);
    }

    public static Direction last(boolean left) {
        return Direction.of(left, false);
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public Direction next() {
        if (this.right) {
            return Direction.of(true, false);
        }

        return Direction.of(false, generatePoint());
    }

    public Direction next(boolean nextRight) {
        return Direction.of(this.right, nextRight);
    }

    public Direction last() {
        return Direction.of(this.right, false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Direction)) return false;

        Direction direction = (Direction) o;

        if (left != direction.left) return false;
        return right == direction.right;
    }

    @Override
    public int hashCode() {
        int result = (left ? 1 : 0);
        result = 31 * result + (right ? 1 : 0);
        return result;
    }
}
