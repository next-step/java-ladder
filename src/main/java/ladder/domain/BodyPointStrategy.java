package ladder.domain;

public class BodyPointStrategy implements PointStrategy {
    private final Point previousPoint;
    private final boolean right;

    public BodyPointStrategy(Point previousPoint, boolean right) {
        this.previousPoint = previousPoint;
        this.right = right;
    }

    @Override
    public Point point() {
        if (previousPoint.hasRightDirection()) {
            return new Point(previousPoint.next(), new Direction(true, false));
        }
        return new Point(previousPoint.next(), new Direction(false, right));
    }
}
