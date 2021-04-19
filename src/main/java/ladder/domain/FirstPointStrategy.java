package ladder.domain;

public class FirstPointStrategy implements PointStrategy {
    private final boolean right;

    public FirstPointStrategy(boolean right) {
        this.right = right;
    }

    @Override
    public Point point() {
        return new Point(0, new Direction(false, right));
    }
}
