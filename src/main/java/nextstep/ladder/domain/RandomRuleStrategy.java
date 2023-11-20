package nextstep.ladder.domain;

import java.util.Random;

public class RandomRuleStrategy implements RuleStrategy {

    private static final Random RANDOM = new Random();

    @Override
    public boolean makingFootBoard() {
        return RANDOM.nextBoolean();
    }
}
