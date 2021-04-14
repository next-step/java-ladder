package ladder.domain;

import ladder.util.RandomUtil;

public class LastPointStrategy implements PointStrategy {
    private final Point previousPoint;
    private final PointNew previousPointNew;

    public LastPointStrategy(Point previousPoint) {
        this.previousPoint = previousPoint;
        this.previousPointNew = new PointNew(0, new DirectionNew(false, false));
    }

    public LastPointStrategy(PointNew previousPointNew) {
        this.previousPointNew = previousPointNew;
        this.previousPoint = new Point(Position.DEFAULT);
    }

    @Override
    public Direction direction() {
        if (previousPoint.haveRightDirection()) {
            return Direction.LEFT;
        }
        return Direction.NO_DIRECTION;
    }

    @Override
    public PointNew point() {
        if (previousPointNew.hasDirection()) {
            return new PointNew(previousPointNew.nextIndex(), new DirectionNew(false, false));
        }
        return new PointNew(previousPointNew.nextIndex(), new DirectionNew(RandomUtil.trueOrFalse(), false));
    }
}
