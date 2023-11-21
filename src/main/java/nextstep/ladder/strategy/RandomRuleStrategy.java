package nextstep.ladder.strategy;

import java.util.Random;

public class RandomRuleStrategy implements RuleStrategy {

    private static final Random RANDOM = new Random();

    @Override
    public boolean build() {
        return RANDOM.nextBoolean();
    }
}
