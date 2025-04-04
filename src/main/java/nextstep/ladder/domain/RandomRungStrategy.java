package nextstep.ladder.domain;

import java.util.Random;

public class RandomRungStrategy implements RungStrategy {

    private final Random random;

    public RandomRungStrategy(Random random) {
        this.random = random;
    }

    @Override
    public void apply(Junction curr, Junction right) {
        if (curr.hasConnect()) {
            return;
        }

        if (!random.nextBoolean()) {
            return;
        }

        curr.connectRight(right);
    }
}
