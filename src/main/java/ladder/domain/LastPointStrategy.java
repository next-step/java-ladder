package ladder.domain;

public class LastPointStrategy implements PointStrategy {
    private final Point previousPoint;

    public LastPointStrategy(Point previousPoint) {
        this.previousPoint = previousPoint;
    }

    @Override
    public Direction direction() {
        if (previousPoint.haveRightDirection()) {
            return Direction.LEFT;
        }
        return Direction.NO_DIRECTION;
    }
}
