package ladder.domain;

public class FirstPointStrategy implements PointStrategy {
    private final boolean nextRight;

    public FirstPointStrategy(boolean nextRight) {
        this.nextRight = nextRight;
    }

    @Override
    public Point point() {
        return new Point(0, new Direction(false, nextRight));
    }
}
