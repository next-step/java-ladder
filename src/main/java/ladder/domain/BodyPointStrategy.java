package ladder.domain;

import ladder.util.RandomUtil;

public class BodyPointStrategy implements PointStrategy {
    private final Point previousPoint;

    public BodyPointStrategy(Point previousPoint) {
        this.previousPoint = previousPoint;
    }

    @Override
    public Direction direction() {
        if (previousPoint.haveRightDirection()) {
            return Direction.LEFT;
        }

        if (RandomUtil.trueOrFalse()) {
            return Direction.RIGHT;
        }

        return Direction.NO_DIRECTION;
    }
}
