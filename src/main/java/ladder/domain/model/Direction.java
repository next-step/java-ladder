package ladder.domain.model;

public class Direction {
    private static final Direction empty = new Direction(false, false);

    private boolean left;
    private boolean right;

    private Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public static Direction empty() {
        return empty;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
