package nextstep.ladder.domain;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomRungStrategy implements RungStrategy {
    @Override
    public void connect(Junction curr, Junction right) {
        if (curr.hasConnect()) {
            return;
        }

        Random random = ThreadLocalRandom.current();

        if (random.nextBoolean()) {
            return;
        }

        curr.connectRight(right);
    }
}
