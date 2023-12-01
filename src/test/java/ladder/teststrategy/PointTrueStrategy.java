package ladder.teststrategy;

import ladder.model.RandomStrategy;

public class PointTrueStrategy implements RandomStrategy {

    @Override
    public boolean hasPoint() {
        return true;
    }
}
