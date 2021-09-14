package nextstep.ladder.domain;

import java.util.Random;

public class RandomGenerator implements LadderGenerator {
    private static final Random random = new Random();

    @Override
    public boolean randomGenerate() {
        return random.nextBoolean();
    }

}
