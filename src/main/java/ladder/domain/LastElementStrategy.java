package ladder.domain;

public class LastElementStrategy implements LadderStrategy {
    private final Point previousPoint;

    public LastElementStrategy(Point previousPoint) {
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
