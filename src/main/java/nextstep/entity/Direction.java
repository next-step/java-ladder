package nextstep.entity;

public class Direction {

    private static final boolean NO_PEDAL = false;
    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("좌측과 우측 모두 페달을 생성할 수 없습니다.");
        }
        this.left = left;
        this.right = right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public boolean isRight() {
        return this.right;
    }

    public static Direction getStartDirection(boolean right) {
        return of(NO_PEDAL, right);
    }

    public Direction next(boolean nextRightPedal) {
        if (this.right) {
            return of(Boolean.TRUE, NO_PEDAL);
        }
        return of(NO_PEDAL, nextRightPedal);
    }

    public Direction getLastDirection() {
        return of(this.right, NO_PEDAL);
    }

    public static Direction getSingleDirection() {
        return of(NO_PEDAL, NO_PEDAL);
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

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
