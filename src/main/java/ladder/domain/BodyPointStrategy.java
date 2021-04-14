package ladder.domain;

import ladder.util.RandomUtil;

public class BodyPointStrategy implements PointStrategy {
    private final Point previousPoint;
    private final PointNew previousPointNew;

    public BodyPointStrategy(Point previousPoint) {
        this.previousPoint = previousPoint;
        this.previousPointNew = new PointNew(0, new DirectionNew(false, false));
    }

    public BodyPointStrategy(PointNew previousPointNew) {
        this.previousPointNew = previousPointNew;
        this.previousPoint = new Point(Position.DEFAULT);
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

    @Override
    public PointNew point() {
        if (previousPointNew.hasRightDirection()) {
            return new PointNew(previousPointNew.nextIndex(), new DirectionNew(false, false));
        }
        if (previousPointNew.hasLeftDirection()) {
            return new PointNew(previousPointNew.nextIndex(), new DirectionNew(false, RandomUtil.trueOrFalse()));
        }
        boolean trueOrFalse = RandomUtil.trueOrFalse();
        return new PointNew(previousPointNew.nextIndex(), new DirectionNew(trueOrFalse, !trueOrFalse));
    }
}
