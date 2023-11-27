package step2.teststrategy;

import step2.model.RandomStrategy;

public class PointTrueStrategy implements RandomStrategy {

    @Override
    public boolean hasPoint() {
        return true;
    }
}
