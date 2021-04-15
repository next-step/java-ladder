package ladder.domain;

import ladder.util.RandomUtil;

public class LastPointStrategy implements PointStrategy {
    private final PointNew previousPointNew;

    public LastPointStrategy(PointNew previousPointNew) {
        this.previousPointNew = previousPointNew;
    }

    @Override
    public PointNew point() {
        if (previousPointNew.hasDirection()) {
            return new PointNew(previousPointNew.nextIndex(), new DirectionNew(false, false));
        }
        return new PointNew(previousPointNew.nextIndex(), new DirectionNew(RandomUtil.trueOrFalse(), false));
    }
}
