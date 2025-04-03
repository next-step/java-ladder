package nextstep.ladder.domain;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomCreateRungStrategy implements CreateRungStrategy {
    @Override
    public void create(Junction curr, Junction right) {
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
