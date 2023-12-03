package ladder.domain;

import java.util.Random;

public class RandomLineCondition implements LineCondition {

    private static final Random random = new Random();

    @Override
    public boolean lineExist() {
        return random.nextBoolean();
    }
}
