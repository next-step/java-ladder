package ladder.domain;

import java.util.Random;

public class RandomPointCondition implements PointCondition {

    private static final Random random = new Random();

    @Override
    public boolean pointExist() {
        return random.nextBoolean();
    }
}
