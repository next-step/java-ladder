package step3.domain;

import java.util.Random;

public class RandomLineConditional implements LineConditional {
    private static final Random random = new Random();

    @Override
    public boolean canHaveLine(int index) {
        return getRandomNo() == 1;
    }

    private int getRandomNo() {
        return random.nextInt(2);
    }
}
