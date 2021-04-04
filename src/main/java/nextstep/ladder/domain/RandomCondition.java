package nextstep.ladder.domain;

import java.util.Random;

public class RandomCondition implements ConditionStrategy {
    @Override
    public boolean randomBoolean() {
        return new Random().nextBoolean();
    }
}
