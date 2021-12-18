package nextstep.ladder.step4.domain.ladder.strategy;

import java.security.SecureRandom;

public class RandomLineStrategy implements LineStrategy {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public RandomLineStrategy() {
    }

    @Override
    public boolean isLine() {
        return SECURE_RANDOM.nextBoolean();
    }

}
