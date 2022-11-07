package nextstep.ladder.strategy;

import java.security.SecureRandom;

public class RandomLineStrategy implements LineStrategy {
    @Override
    public boolean hasLine() {
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.nextBoolean();
    }
}
