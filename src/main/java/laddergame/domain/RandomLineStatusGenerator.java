package laddergame.domain;

import java.util.Random;

public class RandomLineStatusGenerator implements LadderLineStatusGenerator {
    private static final Random RANDOM = new Random();

    @Override
    public boolean generate() {
        return RANDOM.nextBoolean();
    }
}
