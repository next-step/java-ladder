package nextstep.ladder.domain;

import java.util.Random;

public class RandomLineDecisionStrategy implements LineDecisionStrategy {
    private final Random random = new Random();

    @Override
    public boolean shouldDrawLine() {
        return random.nextDouble() < 0.5;
    }
}
