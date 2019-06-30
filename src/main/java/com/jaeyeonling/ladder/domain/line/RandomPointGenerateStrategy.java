package com.jaeyeonling.ladder.domain.line;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomPointGenerateStrategy implements PointGenerateStrategy {

    private final Random random = ThreadLocalRandom.current();

    @Override
    public Boolean generate() {
        return random.nextBoolean();
    }
}
