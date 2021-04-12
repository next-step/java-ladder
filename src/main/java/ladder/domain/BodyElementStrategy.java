package ladder.domain;

import ladder.util.RandomUtil;

public class BodyElementStrategy implements LadderStrategy {
    private final Point previousPoint;

    public BodyElementStrategy(Point previousPoint) {
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
