package ladder.domain;

import ladder.util.RandomUtil;

public class FirstPointStrategy implements PointStrategy {

    public FirstPointStrategy() {
    }

    @Override
    public PointNew point() {
        return new PointNew(0, new DirectionNew(false, RandomUtil.trueOrFalse()));
    }
}
