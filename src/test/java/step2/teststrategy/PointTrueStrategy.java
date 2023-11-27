package step2.teststrategy;

import step3.model.RandomStrategy;

public class PointTrueStrategy implements RandomStrategy {

    @Override
    public boolean hasPoint() {
        return true;
    }
}
