package nextstep.step2.domain;

import java.util.Random;

public class RandomLineGenerator {
    private static final Random random = new Random();
    private final int countOfParticipant;
    private int booleanCount = 0;

    public RandomLineGenerator(final int countOfParticipant) {
        this.countOfParticipant = countOfParticipant;
    }

    public static RandomLineGenerator from(final int countOfParticipant) {
        return new RandomLineGenerator(countOfParticipant);
    }

    public boolean createRandomBoolean(final int position) {
        boolean nextBoolean = random.nextBoolean();

        if (booleanCount > 0 || position == countOfParticipant) {
            return false;
        }

        if (nextBoolean) {
            booleanCount++;
            return true;
        }

        return false;
    }
}
