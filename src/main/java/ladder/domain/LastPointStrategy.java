package ladder.domain;

import ladder.util.RandomUtil;

public class LastPointStrategy implements PointStrategy {
    private final Point previousPoint;

    public LastPointStrategy(Point previousPoint) {
        this.previousPoint = previousPoint;
    }

    @Override
    public Point point() {
        if (previousPoint.hasDirection()) {
            return new Point(previousPoint.nextIndex(), new Direction(false, false));
        }
        return new Point(previousPoint.nextIndex(), new Direction(RandomUtil.trueOrFalse(), false));
    }
}
