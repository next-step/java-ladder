package nextstep.ladder.step4;

public class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
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
