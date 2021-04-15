package ladder.domain;

import ladder.util.RandomUtil;

public class BodyPointStrategy implements PointStrategy {
    private final PointNew previousPointNew;

    public BodyPointStrategy(PointNew previousPointNew) {
        this.previousPointNew = previousPointNew;
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
