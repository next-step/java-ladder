package step4.domain;

import java.util.Random;

public class RandomLineConditional implements LineConditional {
    private static final Random random = new Random();

    @Override
    public boolean canHaveLine(int index) {
        return random.nextBoolean();
    }
}
