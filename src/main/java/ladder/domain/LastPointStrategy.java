package ladder.domain;

public class LastPointStrategy implements PointStrategy {
    private final Point previousPoint;

    public LastPointStrategy(Point previousPoint) {
        this.previousPoint = previousPoint;
    }

    @Override
    public Point point() {
        return previousPoint.next(false);
    }
}
