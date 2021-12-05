package nextstep.ladder.domain;

import java.security.SecureRandom;

public class RandomLineStrategy implements LineStrategy {

    private static final SecureRandom RANDOM = new SecureRandom();

    @Override
    public Boolean isLine() {
        return RANDOM.nextBoolean();
    }
}
