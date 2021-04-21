package ladder.domain;

public class BodyPointStrategy implements PointStrategy {
    private final Point previousPoint;
    private final boolean nextRight;

    public BodyPointStrategy(Point previousPoint, boolean nextRight) {
        this.previousPoint = previousPoint;
        this.nextRight = nextRight;
    }

    @Override
    public Point point() {
        if (previousPoint.hasRightDirection()) {
            return previousPoint.next(false);
        }
        return previousPoint.next(nextRight);
    }
}
