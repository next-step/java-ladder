package ladder.domain.ladder;

public class Point {
    public static final Point LEFT_CROSS_POINT = new Point(Cross.CROSS, Cross.NOT_CROSS);
    public static final Point RIGHT_CROSS_POINT = new Point(Cross.NOT_CROSS, Cross.CROSS);
    public static final Point CANNOT_CROSS_POINT = new Point(Cross.NOT_CROSS, Cross.NOT_CROSS);

    private final Cross left;
    private final Cross right;

    Point(Cross left, Cross right) {
        validateCross(left, right);

        this.left = left;
        this.right = right;
    }

    public boolean canCrossLeft() {
        return this.left.isCross();
    }

    public boolean canCrossRight() {
        return this.right.isCross();
    }

    private void validateCross(Cross left, Cross right) {
        if (left.isCross() && right.isCross()) {
            throw new IllegalArgumentException("Point can't cross both directions");
        }
    }

    @Override
    public String toString() {
        if (canCrossRight()) {
            return "|-----";
        }

        return "|     ";
    }
}
