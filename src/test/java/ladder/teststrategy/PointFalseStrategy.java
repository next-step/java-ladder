package ladder.teststrategy;

import ladder.model.RandomStrategy;

public class PointFalseStrategy implements RandomStrategy {

    @Override
    public boolean hasPoint() {
        return false;
    }
}
