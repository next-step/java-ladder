package ladder.domain;

import java.security.SecureRandom;

public class RandomDirectionMakingStrategy implements DirectionMakingStrategy {
    private static final int TENTH = 10;

    private static final int DECISION_PERCENTAGE = 5;

    private final SecureRandom secureRandom = new SecureRandom();

    @Override
    public Direction generate() {
        if (secureRandom.nextInt(TENTH) < DECISION_PERCENTAGE) {
            return Direction.RIGHT;
        }
        return Direction.NONE;
    }
}
