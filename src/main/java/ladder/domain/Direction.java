package ladder.domain;

public class Direction {
    private static final PointGenerator POINT_GENERATOR = new LadderPointGenerator();
    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException();
        }
        return new Direction(left, right);
    }

    public static Direction first(boolean right) {
        return new Direction(false, right);
    }

    public Direction next() {
        if (this.right) {
            return next(false);
        }
        return new Direction(this.right, POINT_GENERATOR.generate());
    }

    public Direction next(boolean nextRight) {
        return new Direction(this.right, nextRight);
    }

    public Direction last() {
        return new Direction(this.right, false);
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }
}
