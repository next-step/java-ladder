package ladder;

public class LastElementStrategy implements LadderStrategy {
    private final Point point;
    private final Point previousPoint;

    public LastElementStrategy(Point point, Point previousPoint) {
        this.point = point;
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
