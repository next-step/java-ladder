package nextstep.step2.domain;

import java.util.Random;

public class RandomLineGenerator {
    private static final Random random = new Random();
    private int booleanCount=0;

    public boolean createRandomBoolean() {
        boolean nextBoolean = random.nextBoolean();

        if (booleanCount > 0) {
            return false;
        }

        if (nextBoolean) {
            booleanCount++;
            return true;
        }

        return false;
    }
}
