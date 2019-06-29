package com.jaeyeonling.ladder;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomPointGenerateStrategy implements PointGenerateStrategy {

    private final Random random = ThreadLocalRandom.current();

    @Override
    public Boolean generate() {
        return random.nextBoolean();
    }
}
