package ladder.domain;

import java.security.SecureRandom;
import java.util.Random;

public class RandomDirectionMakingStrategy implements DirectionMakingStrategy {
    private static final int TENTH = 10;

    private static final int DECISION_PERCENTAGE = 5;

    private final Random random = new SecureRandom();

    @Override
    public Direction generate() {
        if (random.nextInt(TENTH) < DECISION_PERCENTAGE) {
            return Direction.RIGHT;
        }
        return Direction.NONE;
    }
}
