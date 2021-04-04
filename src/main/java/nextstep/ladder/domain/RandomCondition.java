package nextstep.ladder.domain;

import java.util.Random;

public class RandomCondition implements ConditionStrategy {
    private final static Random random = new Random();

    @Override
    public boolean randomBoolean() {
        return random.nextBoolean();
    }
}
